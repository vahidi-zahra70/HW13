package frameClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import HibernateManager.DrogManager;
import HibernateManager.InsuranceManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;



public class Managerfirst extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button_3;
	private JButton button_4;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	JTable table_2;
	DefaultTableModel model;
	
	JTable table_3;
	DefaultTableModel model1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Managerfirst frame = new Managerfirst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Managerfirst() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(1077, 272, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);


		JLabel lblUsername = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0647");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(1096, 247, 67, 14);
		contentPane.add(lblUsername);
		JButton button = new JButton("\u062F\u0627\u0631\u0648\u0647\u0627\u06CC \u0628\u062D\u0631\u0627\u0646\u06CC");
		button.setBounds(1043, 43, 120, 30);
		contentPane.add(button);

		JButton button_1 = new JButton("\u062F\u0627\u0631\u0648\u0647\u0627\u06CC \u067E\u0631 \u0641\u0631\u0648\u0634");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(1043, 96, 120, 30);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u06A9\u0627\u0631\u062A\u0627\u0628\u0644 \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(1043, 152, 120, 30);
		contentPane.add(button_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(946, 272, 86, 20);
		contentPane.add(textField_1);

		button_3 = new JButton("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0628\u06CC\u0645\u0647");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(1068, 322, 95, 23);
		contentPane.add(button_3);

		button_4 = new JButton("\u062D\u0630\u0641 \u0628\u06CC\u0645\u0647");
		button_4.setBounds(937, 322, 95, 23);
		contentPane.add(button_4);

		JLabel label = new JLabel("\u0646\u0648\u0639 \u0628\u06CC\u0645\u0647");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(964, 247, 67, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0648 \u062D\u0630\u0641 \u0628\u06CC\u0645\u0647");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(1063, 219, 100, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0648 \u062D\u0630\u0641 \u062F\u0627\u0631\u0648");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(1063, 379, 100, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u06A9\u062F \u062F\u0627\u0631\u0648");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(1096, 404, 67, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u0646\u0627\u0645 \u062F\u0627\u0631\u0648");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(964, 404, 67, 14);
		contentPane.add(label_4);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1077, 429, 86, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(946, 429, 86, 20);
		contentPane.add(textField_3);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(565, -54, 1184, 661);
		contentPane.add(panel);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(1077, 272, 86, 20);
		panel.add(textField_4);

		JLabel label_5 = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0647");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(1096, 247, 67, 14);
		panel.add(label_5);

		JButton button_5 = new JButton("\u062F\u0627\u0631\u0648\u0647\u0627\u06CC \u0628\u062D\u0631\u0627\u0646\u06CC");
		button_5.setBounds(1043, 43, 120, 30);
		panel.add(button_5);

		JButton button_6 = new JButton("\u062F\u0627\u0631\u0648\u0647\u0627\u06CC \u067E\u0631 \u0641\u0631\u0648\u0634");
		button_6.setBounds(1043, 96, 120, 30);
		panel.add(button_6);

		JButton button_7 = new JButton("\u06A9\u0627\u0631\u062A\u0627\u0628\u0644 \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		button_7.setBounds(1043, 152, 120, 30);
		panel.add(button_7);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(946, 272, 86, 20);
		panel.add(textField_5);

		JButton button_8 = new JButton("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0628\u06CC\u0645\u0647");
		button_8.setBounds(1068, 322, 95, 23);
		panel.add(button_8);

		JButton button_9 = new JButton("\u062D\u0630\u0641 \u0628\u06CC\u0645\u0647");
		button_9.setBounds(937, 322, 95, 23);
		panel.add(button_9);

		JLabel label_6 = new JLabel("\u0646\u0648\u0639 \u0628\u06CC\u0645\u0647");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(964, 247, 67, 14);
		panel.add(label_6);

		JLabel label_7 = new JLabel("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0648 \u062D\u0630\u0641 \u0628\u06CC\u0645\u0647");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(1063, 219, 100, 14);
		panel.add(label_7);

		JLabel label_8 = new JLabel("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0648 \u062D\u0630\u0641 \u062F\u0627\u0631\u0648");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(1063, 379, 100, 14);
		panel.add(label_8);

		JLabel label_9 = new JLabel("\u06A9\u062F \u062F\u0627\u0631\u0648");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(1096, 404, 67, 14);
		panel.add(label_9);

		JLabel label_10 = new JLabel("\u0646\u0627\u0645 \u062F\u0627\u0631\u0648");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(964, 404, 67, 14);
		panel.add(label_10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1077, 429, 86, 20);
		panel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(946, 429, 86, 20);
		panel.add(textField_7);

		JLabel label_11 = new JLabel("\u0642\u06CC\u0645\u062A \u062F\u0627\u0631\u0648");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(295, 459, 67, 14);
		panel.add(label_11);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(276, 482, 86, 20);
		panel.add(textField_8);

		JButton button_10 = new JButton("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u062F\u0627\u0631\u0648");
		button_10.setBounds(504, 528, 95, 23);
		panel.add(button_10);

		JButton button_11 = new JButton("\u062D\u0630\u0641 \u062F\u0627\u0631\u0648");
		button_11.setBounds(373, 528, 95, 23);
		panel.add(button_11);

		JLabel label_12 = new JLabel("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0633\u0647\u0645 \u0628\u06CC\u0645\u0647");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(499, 579, 100, 14);
		panel.add(label_12);

		JLabel label_13 = new JLabel("\u06A9\u062F \u062F\u0627\u0631\u0648");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setBounds(531, 607, 67, 14);
		panel.add(label_13);

		JLabel label_14 = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0647");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(399, 607, 67, 14);
		panel.add(label_14);

		JLabel label_15 = new JLabel("\u0633\u0647\u0645 \u0628\u06CC\u0645\u0647");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setBounds(295, 608, 67, 14);
		panel.add(label_15);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(513, 633, 86, 20);
		panel.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(382, 633, 86, 20);
		panel.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(277, 632, 86, 20);
		panel.add(textField_11);

		JButton button_12 = new JButton("\u0648\u06CC\u0631\u0627\u06CC\u0634 \u0633\u0647\u0645 \u0628\u06CC\u0645\u0647");
		button_12.setBounds(1043, 618, 120, 23);
		contentPane.add(button_12);

		//Table of Drugs
		String[] columns = new String[] {
				"Id", "Name","Inventory", "Price"  };
		DrogManager DD=new DrogManager();
		Object[][] data =DD.ShowDrogs();
    	model = new DefaultTableModel(data,columns);
		table_2 = new JTable(model);
		table_2.setBounds(10, 10, 175, 200);
		//size of Drug table
		table_2.getColumnModel().getColumn(0).setPreferredWidth(400);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(400);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(400);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(400);
    	//
		JScrollPane	pane = new JScrollPane(table_2);
		pane.setBorder(BorderFactory.createTitledBorder ("Drugs"));
		pane.setSize(260, 129);
		pane.setLocation(43, 51);
		contentPane.add(pane);
		
		//Table of Insurances
				String[] columns2 = new String[] {
						"Id", "Type"  };
				InsuranceManager DD2=new InsuranceManager();
				Object[][] data2 =DD2.ShowInsurances();
		    	model1 = new DefaultTableModel(data2,columns2);
				table_3 = new JTable(model1);
				table_3.setBounds(300, 10, 175, 200);
				
				//size of Insurance table
				table_3.getColumnModel().getColumn(0).setPreferredWidth(400);
				table_3.getColumnModel().getColumn(1).setPreferredWidth(400);
				
		    	//
				JScrollPane	pane2 = new JScrollPane(table_3);
				pane2.setBorder(BorderFactory.createTitledBorder ("Insurances"));
				pane2.setSize(260, 129);
				pane2.setLocation(343, 51);
				contentPane.add(pane2);
	}
}
