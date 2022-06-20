package action;

import java.util.ArrayList;

import dao.OrderHistoryDBAccess;
import model.OrderDetail;

public class OrderHistoryAction {

	public ArrayList<OrderDetail> execute(String custId) throws Exception {

		OrderHistoryDBAccess dao = new OrderHistoryDBAccess();
		int intcustId = Integer.parseInt(custId);
		ArrayList<OrderDetail> orderDetailList = dao.orderHitory(intcustId);

		return orderDetailList;
	}


}
