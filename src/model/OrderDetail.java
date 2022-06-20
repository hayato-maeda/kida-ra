/**
 * クラス名：	OrderDetail
 * 概要　　：	注文明細情報
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package model;

import java.io.Serializable;

public class OrderDetail implements Serializable {

	private long no;
	private Customer customer;
	private Item item;
	private String orderDate;
	private int quantity;
	private Tax tax;
	private int status;

	public OrderDetail() {
	}

	public OrderDetail(long no, Customer customer, Item item, String orderDate, int quantity, Tax tax, int status) {
		this.no = no;
		this.customer = customer;
		this.item = item;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.tax = tax;
		this.status = status;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
