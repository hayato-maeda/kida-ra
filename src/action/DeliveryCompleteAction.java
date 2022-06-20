/**
 * クラス名：	DeliveryCompleteAction
 * 概要　　：	配達完了アクション
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package action;

import dao.DeliveryCompleteDBAccess;

public class DeliveryCompleteAction {

	public int execute(String custId) throws Exception {

		DeliveryCompleteDBAccess dao = new DeliveryCompleteDBAccess();
		int count = dao.completeDeliveryByCustId(custId);

		return count;
	}
}
