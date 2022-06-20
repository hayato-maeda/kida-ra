/**
 * クラス名：	OrderRegisterDBAccess
 * 概要　　：	注文情報登録DAO
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Item;
import model.OrderDetail;
import model.Tax;

public class OrderRegisterDBAccess extends ControlDBAccess {

	public void registerOrder(ArrayList<OrderDetail> orderDetailList) throws Exception {

		Connection con = createConnection();
		PreparedStatement pstmt = null;

		try {

			for (int i = 0; i < orderDetailList.size(); i++) {

				OrderDetail orderdetail = orderDetailList.get(i);

				Customer customer = orderdetail.getCustomer();
				Item item = orderdetail.getItem();
				Tax tax = orderdetail.getTax();

				int intCustId = customer.getCustId();
				String ItemId = item.getItemId();
				int taxId = tax.getTaxId();

				//taxの情報をすべて取得
				pstmt = con.prepareStatement("INSERT INTO kidda_la.orderdetail(CUSTID,ITEMID,ORDERDATE,QUANTITY,TAXID,STATUS) values(?,?,?,?,?,?)");
				//SQL文に検索キーワードを埋め込む
				pstmt.setInt(1, intCustId);//CUSTID
				pstmt.setString(2, ItemId);//ITEMID
				pstmt.setString(3, orderdetail.getOrderDate());//ORDERDATE
				pstmt.setInt(4, orderdetail.getQuantity());//QUANTITY
				pstmt.setLong(5, taxId);//TAXID
				pstmt.setInt(6, orderdetail.getStatus());//STATUS
				//SQL文を実行
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			throw new Exception("商品情報検索処理に失敗しました！");
		}
	}
}
