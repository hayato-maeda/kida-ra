/**
 * クラス名：	KiddaLaController
 * 概要　　：	KIDDA-LA業務システムコントローラ
 * 作成者名：前田隼人
 * 作成日　：6月10日
 * 修正者名：
 * 修正日　：
 */

package control;

import java.util.ArrayList;

import action.CustomerModifyAction;
import action.CustomerSearchAction;
import action.CustomerSearchDisplayAction;
import action.DeliveryCompleteAction;
import action.DeliveryConfirmAction;
import action.ItemMenuDisplayAction;
import action.MainMenuDisplayAction;
import action.OrderHistoryAction;
import action.OrderInputDisplayAction;
import action.OrderRegisterAction;
import action.PrintOutAction;
import model.Customer;
import model.OrderDetail;
import view.DeliveryConfirmFrame;

public class KiddaLaController {

	public static void customerSearchDisplay() {
		CustomerSearchDisplayAction action = new CustomerSearchDisplayAction();
		action.execute();
	}

	public static String[][] customerSearch(String[] data) throws Exception {
		CustomerSearchAction action = new CustomerSearchAction();
		String[][] tableData = action.execute(data);
		return tableData;
	}

	public static void mainMenuDisplay() {
		MainMenuDisplayAction action = new MainMenuDisplayAction();
		action.execute();
	}

	public static Customer orderInputDisplay(String custId) throws Exception {
		OrderInputDisplayAction action = new OrderInputDisplayAction();
		Customer customer = action.execute(custId);
		return customer;
	}

	public static String[][] itemMenuDisplay() throws Exception {
		ItemMenuDisplayAction action = new ItemMenuDisplayAction();
		String[][] tableData = action.execute();
		return tableData;
	}

	public static ArrayList<OrderDetail> deliveryConfirm(String custId) throws Exception {
		DeliveryConfirmAction action = new DeliveryConfirmAction();
		ArrayList<OrderDetail> orderDetailList = action.execute(custId);
		return orderDetailList;
	}

	public static ArrayList<OrderDetail> orderRegister(ArrayList<OrderDetail> orderDetailList) throws Exception {
		OrderRegisterAction action = new OrderRegisterAction();
		orderDetailList = action.execute(orderDetailList);
		return orderDetailList;
	}

	public static int customerModify(Customer customer) throws Exception {
		CustomerModifyAction action = new CustomerModifyAction();
		int count = action.execute(customer);
		return count;
	}

	public static void printOut(DeliveryConfirmFrame frame) throws Exception {
		PrintOutAction action = new PrintOutAction();
		action.execute(frame);
	}

	public static int deliveryComplete(String custId) throws Exception {
		DeliveryCompleteAction action = new DeliveryCompleteAction();
		int count = action.execute(custId);
		return count;
	}
//------------------------追加コード-----------------------------------------------------------
	public static ArrayList<OrderDetail> orderHistory(String custId) throws Exception {
		OrderHistoryAction action = new OrderHistoryAction();
		ArrayList<OrderDetail> orderDetailList = action.execute(custId);
		return orderDetailList;
//------------------------------------------------------------------------------------------
	}
}
