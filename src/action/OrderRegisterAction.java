/**
 * クラス名：	OrderRegisterAction
 * 概要　　：	注文情報登録アクション
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;

import dao.OrderConfirmDBAccess;
import dao.OrderRegisterDBAccess;
import dao.TaxSearchDBAccess;
import model.Customer;
import model.OrderDetail;
import model.Tax;

public class OrderRegisterAction {

	public ArrayList<OrderDetail> execute(ArrayList<OrderDetail> orderDetailList) throws Exception {

		OrderDetail orderdetail = orderDetailList.get(0);

		Customer customer = orderdetail.getCustomer();

		//お客様IDを取得
		int intCustId = customer.getCustId();

		TaxSearchDBAccess dao_t = new TaxSearchDBAccess();
		Tax tax = dao_t.searchCurrentTax();

		//orderDetailListに値が格納されている間(要素が存在する間)ループ処理を行う
		for (int i = 0; i < orderDetailList.size(); i++) {
			orderdetail = orderDetailList.get(i);
			orderdetail.setCustomer(customer);
			orderdetail.setTax(tax);
		}

		OrderRegisterDBAccess dao_o = new OrderRegisterDBAccess();
		dao_o.registerOrder(orderDetailList);

		OrderConfirmDBAccess dao_con = new OrderConfirmDBAccess();
		orderDetailList = dao_con.searchOrderByCustId(intCustId);

		return orderDetailList;
	}
}
