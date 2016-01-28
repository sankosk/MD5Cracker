package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import logic.Cracker;
import logic.MD5WebService1;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel enterMD5Pane;
	private JPanel resultPane;
	private JPanel logsPane;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("MD5 Cracker- Por un tal Sanko surmano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getEnterMD5Pane(), BorderLayout.NORTH);
		//contentPane.add(getResultPane(), BorderLayout.CENTER);
		contentPane.add(getLogsPane(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getEnterMD5Pane() {
		if (enterMD5Pane == null) {
			enterMD5Pane = new JPanel();
			enterMD5Pane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enter MD5's", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			enterMD5Pane.setLayout(new GridLayout(0, 1, 0, 0));
			enterMD5Pane.add(getTextField());
			enterMD5Pane.add(getBtnNewButton());
		}
		return enterMD5Pane;
	}
	private JPanel getResultPane() {
		if (resultPane == null) {
			resultPane = new JPanel();
			resultPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			resultPane.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return resultPane;
	}
	private JPanel getLogsPane() {
		if (logsPane == null) {
			logsPane = new JPanel();
		}
		return logsPane;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getResultPane());
		}
		return scrollPane;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Click to Crack");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resultPane.removeAll();
					revalidate();
					repaint();
					
					JPanel[] webservices = {new ResultPane(new MD5WebService1("http://md5decryption.com/index.php", textField.getText(), false)),
											new ResultPane(new MD5WebService1("http://md5decryption.com/index.php", textField.getText(), false)),
											new ResultPane(new MD5WebService1("http://md5decryption.com/index.php", textField.getText(), false))
											};
					for(JPanel p: webservices){
						resultPane.add(p);
					}
					
					revalidate();
					repaint();
					//resultPane.add();
				}
			});
		}
		return btnNewButton;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
}
