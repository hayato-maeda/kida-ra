package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlDBAccess {

	protected Connection createConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

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
	protected void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("DB切断時にエラーが発生しました。");
			e.printStackTrace();
		}
	}
}
