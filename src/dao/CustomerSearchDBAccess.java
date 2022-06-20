/**
 * クラス名：	CustomerSearchFrame
 * 概要　　：	「顧客情報検索」画面
 * 作成者名： 前田 隼人
 * 作成日　：  6月1日
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerSearchDBAccess {

	private Connection createConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//5月30日コメント・受注管理を正式なテーブル名に変更
			con = DriverManager.getConnection("jdbc:mysql://localhost:65534/kidda_la?serverTimezone=JST", "user1",
					"pass1");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB接続時にエラーが発生しました。");
			e.printStackTrace();
		}
		return con;
	}

	//DBとの接続を閉じる
	private void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("DB切断時にエラーが発生しました。");
			e.printStackTrace();
		}
	}
//---------------------------------------------------------------------------------------------------------
	public ArrayList<Customer> searchCustomerByTel(String tel) throws Exception {

		Connection con = createConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			if (con != null) {
				String sql = "SELECT * FROM kidda_la.customer WHERE TEL = ?;";
				//一度だけ最適化を行う
				stmt = con.prepareStatement(sql);
				//SQL文に検索キーワードを埋め込む
				stmt.setString(1, tel);
				//SQL文を実行する
				rs = stmt.executeQuery();

				while (rs.next() == true) {
					int custId = rs.getInt(1);
					String custName = rs.getString(2);
					String kana = rs.getString(3);
					String ctel = rs.getString(4);
					String address = rs.getString(5);
					Customer bean = new Customer(custId, custName, kana, ctel, address);
					list.add(bean);
				}
			}

		} catch (SQLException e) {
			System.out.println("DB接続処理に失敗しました!\n管理者に連絡してください。");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("一致する情報は見つかりませんでした。");
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.out.println("顧客情報検索処理に失敗しました!\n管理者に連絡してください。");
				e.printStackTrace();
			}
		}
		closeConnection(con);
		return list;

	}
//---------------------------------------------------------------------------------------------------------
	public ArrayList<Customer> searchCustomerByKana(String kana) throws Exception {

		Connection con = createConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			if (con != null) {
				String sql = "SELECT * FROM kidda_la.customer WHERE KANA LIKE ?;";
				//一度だけ最適化を行う
				stmt = con.prepareStatement(sql);
				//SQL文に検索キーワードを埋め込む
				stmt.setString(1, '%' + kana + '%');
				//SQL文を実行する
				rs = stmt.executeQuery();
				while (rs.next() == true) {
					int custId = rs.getInt(1);
					String custName = rs.getString(2);
					String ckana = rs.getString(3);
					String ctel = rs.getString(4);
					String address = rs.getString(5);
					Customer bean = new Customer(custId, custName, ckana, ctel, address);
					list.add(bean);
				}
			}

		} catch (SQLException e) {
			System.out.println("DB接続処理に失敗しました!\nDBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("一致する情報は見つかりませんでした。");
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.out.println("顧客情報検索処理に失敗しました!\n管理者に連絡してください。");
				e.printStackTrace();
			}
		}
		closeConnection(con);
		return list;

	}
//---------------------------------------------------------------------------------------------------------

	public ArrayList<Customer> searchCustomer(String tel , String kana) throws Exception {

		Connection con = createConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			if (con != null) {
				String sql = "SELECT * FROM kidda_la.customer WHERE TEL = ? AND KANA LIKE ?;";
				//一度だけ最適化を行う
				stmt = con.prepareStatement(sql);

				//SQL文に検索キーワードを埋め込む
				stmt.setString(1, tel);
				stmt.setString(2, '%' + kana + '%');

				//SQL文を実行する
				rs = stmt.executeQuery();
				while (rs.next() == true) {
					int custId = rs.getInt(1);
					String custName = rs.getString(2);
					String ckana = rs.getString(3);
					String ctel = rs.getString(4);
					String address = rs.getString(5);
					Customer bean = new Customer(custId, custName, ckana, ctel, address);
					list.add(bean);
				}
			}

		} catch (SQLException e) {
			System.out.println("DB接続処理に失敗しました!\\nDBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("一致する情報は見つかりませんでした。");
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.out.println("顧客情報検索処理に失敗しました!\n管理者に連絡してください。");
				e.printStackTrace();
			}
		}
		closeConnection(con);
		return list;

	}
}
