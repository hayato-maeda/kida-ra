/**
 * クラス名：	CustomerModifyAction
 * 概要　　：	顧客情報変更アクション
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package action;

import dao.CustomerModifyDBAccess;
import model.Customer;

public class CustomerModifyAction {

	public int execute(Customer customer) throws Exception {

		CustomerModifyDBAccess dao = new CustomerModifyDBAccess();
		int count = dao.modifyCustomer(customer);
		return count;
	}
}
