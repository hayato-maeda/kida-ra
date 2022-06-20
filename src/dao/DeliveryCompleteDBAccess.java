/**
 * クラス名：	DeliveryCompleteDBAccess
 * 概要　　：	配達完了DAO
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliveryCompleteDBAccess extends ControlDBAccess {

	public int completeDeliveryByCustId(String custId) throws Exception {

		int intCustId = Integer.parseInt(custId);

		Connection con = createConnection();
		PreparedStatement pstmt = null;
		int count = 0;

		try {

			//pstmt = con.prepareStatement("DELETE FROM orderdetail WHERE CUSTID = ?");
			pstmt = con.prepareStatement("UPDATE orderdetail SET STATUS = ? where CUSTID = ?");
			pstmt.setInt(1, 0);
			pstmt.setInt(2, intCustId);
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
