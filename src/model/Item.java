/**
 * クラス名：	Item
 * 概要　　：	商品情報
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package model;

import java.io.Serializable;

public class Item implements Serializable {

	private String itemId;
	private String itemName;
	private String size;
	private int price;

	public Item() {
	}

	public Item(String itemId, String itemName, String size, int price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.size = size;
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
