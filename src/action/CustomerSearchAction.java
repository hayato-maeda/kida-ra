/**
 * クラス名：	CustomerSearchFrame
 * 概要　　：	「顧客情報検索」画面
 * 作成者名： 前田 隼人
 * 作成日　：  6月1日
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;
import java.util.Objects;

import dao.CustomerSearchDBAccess;
import model.Customer;
import model.OrderControlUtility;

public class CustomerSearchAction {

	public String[][] execute(String[] data) throws Exception {

		String[][] tableData = null;
		CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
		ArrayList<Customer> list = null;

		//data[0]とdata[1]の半角スペースと全角スペースを取り除く
		for (int i = 0; i < data.length; i++) {
			data[i] = data[i].replace("　", "").replace(" ", "");
		}

		//電話番号のみ入力された場合
		if ((!data[0].equals("")) && (data[1].equals(""))) {

			String tel = data[0];
			//DAOを生成する
			list = dao.searchCustomerByTel(tel);

		} //カナのみ入力された場合
		else if ((data[0].equals("")) && (!data[1].equals(""))) {
			String kana = data[1];
			//DAOを生成する
			list = dao.searchCustomerByKana(kana);

		} //電話番号・カナ両方入力された場合
		else if ((!data[0].equals("")) && (!data[1].equals(""))) {
			String tel = data[0];
			String kana = data[1];
			//DAOを生成する
			list = dao.searchCustomer(tel, kana);

		}

		//data[0],data[1]が空白だった場合(listがnull)
		if(Objects.isNull(list)) {
			//list.size()を実行させないため
		}
		else if (list.size() > 0) {
			tableData = OrderControlUtility.customerToArray(list);
		}
		return tableData;
	}

}
