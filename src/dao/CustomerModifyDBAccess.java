/**
 * クラス名：	CustomerModifyDBAccess
 * 概要　　：	顧客情報変更DAO
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Customer;

public class CustomerModifyDBAccess extends ControlDBAccess {

	public int modifyCustomer(Customer customer) throws Exception {

		Connection con = createConnection();
		PreparedStatement pstmt = null;
		int count = 0;
		try {

			pstmt = con.prepareStatement("UPDATE kidda_la.customer SET CUSTNAME = ?, KANA = ?, TEL = ?, ADDRESS = ? WHERE CUSTID = ?");
			pstmt.setString(1, customer.getCustName());
			pstmt.setString(2, customer.getKana());
			pstmt.setString(3, customer.getTel());
			pstmt.setString(4, customer.getAddress());
			pstmt.setInt(5, customer.getCustId());
			count = pstmt.executeUpdate();


		} catch (SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		closeConnection(con);
		return count;

	}
}
