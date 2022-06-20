/**
 * クラス名：	ItemMenuDisplayAction
 * 概要　　：	商品情報表示アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;

import dao.ItemMenuDisplayDBAccess;
import dao.TaxSearchDBAccess;
import model.Item;
import model.OrderControlUtility2;
import model.Tax;

public class ItemMenuDisplayAction {

	public String[][] execute()  throws Exception {

		ItemMenuDisplayDBAccess imdDao = new ItemMenuDisplayDBAccess();
		ArrayList<Item> list = imdDao.searchAllItem();

		TaxSearchDBAccess tsDao = new TaxSearchDBAccess();
		Tax tax = tsDao.searchCurrentTax();
		double taxRate = tax.getRate();

		String[][] tableData = OrderControlUtility2.itemToArray(list);

		for (String[] rowData : tableData) {

			//単価×消費税
			int intPrice = Integer.parseInt(rowData[4]);
			intPrice = (int)(intPrice * (1 + taxRate));

			rowData[4] = String.format("%1$,d", intPrice);
		}

		return tableData;
	}
}
