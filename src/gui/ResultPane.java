package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.Font;

import logic.Cracker;
import javax.swing.JTextField;

public class ResultPane extends JPanel {
	private JPanel panel;
	private JLabel webserviceLbl;
	private JPanel panel_1;
	private Cracker cracker;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public ResultPane(Cracker cracker) {
		this.cracker = cracker;
		setLayout(new GridLayout(1, 2, 0, 0));
		add(getPanel());
		add(getPanel_1());

	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getWebserviceLbl());
		}
		return panel;
	}
	private JLabel getWebserviceLbl() {
		if (webserviceLbl == null) {
			webserviceLbl = new JLabel(""+cracker.getUrl()+": ");
			webserviceLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return webserviceLbl;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			panel_1.add(getTextField());
		}
		return panel_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField(""+cracker.getCrackedHash());
			textField.setEditable(false);
			textField.setColumns(10);
		}
		return textField;
	}
}
