/**
 * クラス名：	MainMenuFrame
 * 概要　　：	「メインメニュー」画面
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import control.KiddaLaController;
import model.OrderControlUtility;

public class MainMenuFrame extends JFrame implements ActionListener {

	public MainMenuFrame() {

		//フレームのアイコンに表示される画像を設定する
		OrderControlUtility.setIconImage(this);

		setTitle("【メインメニュー】 KIDDA-LA 業務システム");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		JButton orderControl = new JButton("01 注文管理");
		orderControl.setBounds(20, 20, 460, 40);
		orderControl.addActionListener(this);
		add(orderControl);

		setVisible(true);
	}

	public void addNotify() {

		super.addNotify();

		Insets insets = getInsets();
		setSize(500 + insets.left + insets.right, 250 + insets.top + insets.bottom);
		setLocationRelativeTo(this);
	}

	public void actionPerformed(ActionEvent e) {

		setVisible(false);

		KiddaLaController.customerSearchDisplay();
	}
}