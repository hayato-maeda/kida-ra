/**
 * クラス名：	TaxSearchDBAccess
 * 概要　　：	消費税検索DAO
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Tax;

public class TaxSearchDBAccess extends ControlDBAccess {

	public Tax searchCurrentTax() throws Exception {

		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Tax tax = null;
		try {
			//taxの情報をすべて取得
			pstmt = con.prepareStatement("SELECT * FROM kidda_la.tax;");
			//SQL文を実行
			rs = pstmt.executeQuery();

			//rsに格納されている行の数だけ実行(rs.next() == trueと同じ意味)
			while (rs.next()) {
				//各引数はシーケンス図を参照してください。
				int taxId = rs.getInt(1);//TAXID
				double rate = rs.getDouble(2);//RATE
				String endDate = rs.getString(3);//ENDDATE
				//Taxクラスのコンストラクタを呼び出し、値を設定
				tax = new Tax(taxId, rate, endDate);
			}
		} catch (SQLException e) {
			throw new Exception("商品情報検索処理に失敗しました！");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		closeConnection(con);
		return tax;
	}

}
