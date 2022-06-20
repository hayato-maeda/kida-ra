/**
 * クラス名：	OrderInputDisplayAction
 * 概要　　：	注文情報入力画面表示アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;

import model.Customer;
import dao.OrderInputDisplayDBAccess;

public class OrderInputDisplayAction {

	public Customer execute(String custId) throws Exception {

		int intCustId = Integer.parseInt(custId);

		OrderInputDisplayDBAccess oidDao = new OrderInputDisplayDBAccess();
		Customer customer = oidDao.searchCustomerById(intCustId);

		return customer;
	}
}
