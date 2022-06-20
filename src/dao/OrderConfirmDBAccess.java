/**
 * クラス名：	OrderConfirmDBAccess
 * 概要　　：	注文情報確認DAO
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Item;
import model.OrderDetail;
import model.Tax;

public class OrderConfirmDBAccess extends ControlDBAccess {

	public ArrayList<OrderDetail> searchOrderByCustId(int custId) throws Exception {

		Connection con = createConnection();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Customer customer = null;
		ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

		try {

			pstmt1 = con.prepareStatement(	"SELECT CUSTNAME, KANA, TEL, ADDRESS " +
											"FROM CUSTOMER " +
											"WHERE CUSTID = ?");

			pstmt2 = con.prepareStatement(
					"SELECT I.ITEMID, ITEMNAME, SIZE, PRICE, " +
					"T.TAXID, RATE, ENDDATE, " +
					"NO, ORDERDATE, QUANTITY " +
					"FROM ORDERDETAIL O " +
					"INNER JOIN ITEM I " +
					"ON O.ITEMID = I.ITEMID " +
					"INNER JOIN TAX T " +
					"ON O.TAXID = T.TAXID " +
					"WHERE O.CUSTID = ? AND STATUS = 1" );

			pstmt1.setInt(1, custId);
			rs = pstmt1.executeQuery();

			if(rs.next()) {

				String custName = rs.getString(1);
				String kana = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				customer = new Customer(custId, custName, kana, tel, address);

				rs.close();

				pstmt2.setInt(1, custId);
				rs = pstmt2.executeQuery();

				while(rs.next()) {

					String itemId = rs.getString(1);
					String itemName = rs.getString(2);
					String size = rs.getString(3);
					int price = rs.getInt(4);
					Item item = new Item(itemId, itemName, size, price);

					int taxId = rs.getInt(5);
					double rate = rs.getDouble(6);
					String endDate = rs.getString(7);
					Tax tax = new Tax(taxId, rate, endDate);

					long no = rs.getLong(8);
					String orderDate = rs.getString(9);
					int quantity = rs.getInt(10);

					OrderDetail orderDetail = new OrderDetail(no, customer, item, orderDate, quantity, tax, 1);

					orderDetailList.add(orderDetail);
				}
			}
		} catch (SQLException e) {
			throw new Exception("配達情報検索処理に失敗しました！");
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt1 != null) {
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt2 != null) {
				try {
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		closeConnection(con);
		return orderDetailList;
	}
}
