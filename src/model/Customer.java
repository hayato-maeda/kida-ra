/**
 * クラス名：	CustomerSearchFrame
 * 概要　　：	「顧客情報検索」画面
 * 作成者名： 前田 隼人
 * 作成日　：  6月1日
 * 修正者名：
 * 修正日　：
 */

package model;

import java.io.Serializable;

public class Customer implements Serializable {

	private int custId;
	private String custName;
	private String kana;
	private String tel;
	private String address;

	//コンストラクタ
	public Customer(int custId, String custName, String kana, String tel, String address) {
		this.custId = custId;
		this.custName = custName;
		this.kana = kana;
		this.tel = tel;
		this.address = address;
	}

	public Customer() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
