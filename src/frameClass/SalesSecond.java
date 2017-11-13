package frameClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import HibernateManager.DrogInsuranceManager;
import HibernateManager.DrogManager;
import HibernateManager.InsuranceManager;
import javaClass.Drog;
import javaClass.Insurance;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;



public class SalesSecond extends JFrame {

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
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	JTable table_2;
	DefaultTableModel model;

	JTable table_3;
	DefaultTableModel model1;

	JTable table_4;
	DefaultTableModel model2;

	CriticalDrugs criticalDrugs ;
	SaleFullDrug saleFullDrug;

	/**
	 * Launch the application.
	 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			SalesSecond frame = new SalesSecond();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//			});
//		}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public SalesSecond() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.out.println("salllllllllll");

		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(576, -54, 1000, 661);
		contentPane.add(panel);
		
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

		JScrollPane	pane = new JScrollPane(table_2);
		pane.setBorder(BorderFactory.createTitledBorder ("Drugs"));
		pane.setSize(260, 600);
		pane.setLocation(43, 21);
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
		table_3.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(400);

		//
		JScrollPane	pane2 = new JScrollPane(table_3);
		pane2.setBorder(BorderFactory.createTitledBorder ("Insurances"));
		pane2.setSize(200, 329);
		pane2.setLocation(34, 77);
		panel.add(pane2);



		//Table of DrogInsurances
		String[] columns3 = new String[] {
				"Drog ID", "Insurance ID" ,"Share Percent" };
		DrogInsuranceManager DD3=new  DrogInsuranceManager();
		Object[][] data3 =DD3.ShowDrogInsurance();
		model2 = new DefaultTableModel(data3,columns3);
		table_4 = new JTable(model2);
		table_4.setBounds(300, 10, 175, 200);

		//size of Insurance table
		table_4.getColumnModel().getColumn(0).setPreferredWidth(180);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(180);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(200);

		//
		JScrollPane	pane3 = new JScrollPane(table_4);
		pane3.setBorder(BorderFactory.createTitledBorder ("Insurances share for each drog"));
		pane3.setSize(248, 600);
		pane3.setLocation(327, 21);
		contentPane.add(pane3);

		//Inserting a new Insurance
		JButton button_13 = new JButton("\u0627\u0641\u0632\u0648\u062F\u0646 \u0628\u06CC\u0645\u0647");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("")){
					JOptionPane.showMessageDialog(contentPane, "Please insert the id and type of the insurance to insert a new insurance!");
				}
				else{
					try {
						Integer id=Integer.parseInt(textField.getText());
						String type=textField_1.getText();
						Insurance insert=new Insurance(id,type);
						InsuranceManager II=new InsuranceManager();
						if(!II.insertInsurance(insert)){
							JOptionPane.showMessageDialog(contentPane, "The Insurance you want to insert exist in the table!");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Insert a number as the insurance Id!");
					} 
				}

			}
		});
		
	}
}
