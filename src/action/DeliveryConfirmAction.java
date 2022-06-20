/**
 * クラス名：	DeliveryConfirmAction
 * 概要　　：	配達情報確認アクション
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;

import dao.DeliveryConfirmDBAccess;
import model.OrderDetail;

public class DeliveryConfirmAction {

	public ArrayList<OrderDetail> execute(String custId) throws Exception {

		DeliveryConfirmDBAccess dao = new DeliveryConfirmDBAccess();
		int intCustId = Integer.parseInt(custId);
		ArrayList<OrderDetail> orderDetailList = dao.searchDeliveryByCustId(intCustId);

		return orderDetailList;
	}
}
