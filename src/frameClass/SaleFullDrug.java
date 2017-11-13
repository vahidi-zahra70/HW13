package frameClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import HibernateManager.DrogManager;
import HibernateManager.SaleDrugManager;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleFullDrug extends JFrame {

	private JPanel contentPane;
	JTable table_2;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleFullDrug frame = new SaleFullDrug();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//		});
//	}


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public SaleFullDrug() throws SQLException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		//day
			//	JComboBox comboBox_4 = new JComboBox();
				Integer [] a = new Integer []{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
				JComboBox <Integer> comboBox_4 = new JComboBox<Integer>(a);
				comboBox_4.setBounds(589, 70, 45, 20);
				contentPane.add(comboBox_4);


				//month
				//JComboBox comboBox_5 = new JComboBox();
				String [] m = new String[]{"\u0641\u0631\u0648\u0631\u062F\u06CC\u0646","\u0627\u0631\u062F\u06CC\u0628\u0647\u0634\u062A","\u062E\u0631\u062F\u0627\u062F","\u062A\u06CC\u0631","\u0645\u0631\u062F\u0627\u062F","\u0634\u0647\u0631\u06CC\u0648\u0631","\u0645\u0647\u0631","\u0622\u0628\u0627\u0646","\u0622\u0630\u0631","\u062F\u06CC","\u0628\u0647\u0645\u0646","\u0627\u0633\u0641\u0646\u062F"};
				JComboBox<String> comboBox_5 = new JComboBox<String>(m);
				comboBox_5.setBounds(508, 70, 60, 20);
				contentPane.add(comboBox_5);


				//year
				//JComboBox comboBox_6 = new JComboBox();
				Integer y[] =new Integer[]{1390,1391,1392,1393,1394,1395,1396}; 
				JComboBox<Integer> comboBox_6 = new JComboBox<Integer>(y);
				comboBox_6.setBounds(438, 70, 60, 20);
				contentPane.add(comboBox_6);

				
				//to
				//JComboBox comboBox_7 = new JComboBox();
				Integer [] aa = new Integer []{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
				JComboBox <Integer> comboBox_7 = new JComboBox<Integer>(aa);
				comboBox_7.setBounds(589, 140, 45, 20);
				contentPane.add(comboBox_7);


				//month
				//JComboBox comboBox_8 = new JComboBox();
				String [] mm = new String[]{"\u0641\u0631\u0648\u0631\u062F\u06CC\u0646","\u0627\u0631\u062F\u06CC\u0628\u0647\u0634\u062A","\u062E\u0631\u062F\u0627\u062F","\u062A\u06CC\u0631","\u0645\u0631\u062F\u0627\u062F","\u0634\u0647\u0631\u06CC\u0648\u0631","\u0645\u0647\u0631","\u0622\u0628\u0627\u0646","\u0622\u0630\u0631","\u062F\u06CC","\u0628\u0647\u0645\u0646","\u0627\u0633\u0641\u0646\u062F"};
				JComboBox<String> comboBox_8 = new JComboBox<String>(mm);
				comboBox_8.setBounds(508, 140, 60, 20);
				contentPane.add(comboBox_8);


				//year
				//JComboBox comboBox_9 = new JComboBox();
				Integer yy[] =new Integer[]{1390,1391,1392,1393,1394,1395,1396}; 
				JComboBox<Integer> comboBox_9 = new JComboBox<Integer>(yy);
				comboBox_9.setBounds(438, 140, 60, 20);
				contentPane.add(comboBox_9);

				
				
				JLabel label = new JLabel("\u0631\u0648\u0632");
				label.setBounds(589, 45, 46, 14);
				contentPane.add(label);
				
				JLabel label_1 = new JLabel("\u0645\u0627\u0647");
				label_1.setBounds(522, 43, 46, 14);
				contentPane.add(label_1);
				
				JLabel label_2 = new JLabel("\u0633\u0627\u0644");
				label_2.setBounds(452, 45, 46, 14);
				contentPane.add(label_2);
				
				//to
				JLabel label_3 = new JLabel("\u0631\u0648\u0632");
				label_3.setBounds(589, 120, 46, 14);
				contentPane.add(label_3);
				
				JLabel label_4 = new JLabel("\u0645\u0627\u0647");
				label_4.setBounds(522, 120, 46, 14);
				contentPane.add(label_4);
				
				JLabel label_5 = new JLabel("\u0633\u0627\u0644");
				label_5.setBounds(452, 120, 46, 14);
				contentPane.add(label_5);
				
				JButton button = new JButton("\u0646\u0645\u0627\u06CC\u0634 \u062F\u0627\u0631\u0648\u0647\u0627\u06CC \u067E\u0631\u0641\u0631\u0648\u0634");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String date;
						java.sql.Date sqlDateStart = null;
						
						Integer day =(Integer) comboBox_4.getItemAt(comboBox_4.getSelectedIndex());
						int month =comboBox_5.getSelectedIndex()+1;
						Integer year =(Integer) comboBox_6.getItemAt(comboBox_6.getSelectedIndex());
						
						if(day<=9 && month>=10){
							date=year+"/"+month+"/0"+day;
						}
						else if(day>=10 && month<=9){
							date=year+"/0"+month+"/"+day;
						}
						else if(day<=9 && month<=9){
							date=year+"/0"+month+"/0"+day;
						}
						else{
							date=year+"/"+month+"/"+day;
						}
						SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

						try {
							java.util.Date utilDate = format.parse(date);
							sqlDateStart = new java.sql.Date(utilDate.getTime());
							System.out.println(sqlDateStart);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
						//Obtaining Finish Date
						String date2;
						java.sql.Date sqlDatefinish = null;
						
						Integer day2 =(Integer) comboBox_7.getItemAt(comboBox_7.getSelectedIndex());
						int month2 =comboBox_8.getSelectedIndex()+1;
						Integer year2 =(Integer) comboBox_9.getItemAt(comboBox_9.getSelectedIndex());
						
						if(day2<=9 && month2>=10){
							date2=year2+"/"+month2+"/0"+day2;
						}
						else if(day2>=10 && month2<=9){
							date2=year2+"/0"+month2+"/"+day2;
						}
						else if(day2<=9 && month2<=9){
							date2=year2+"/0"+month2+"/0"+day2;
						}
						else{
							date2=year2+"/"+month2+"/"+day2;
						}
						SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");

						try {
							java.util.Date utilDate = format.parse(date2);
							sqlDatefinish = new java.sql.Date(utilDate.getTime());
							System.out.println(sqlDatefinish);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
						
						
						//table
						
						//Table of  Sale full
						String[] columns = new String[] {
								"Id", "Name","Inventory", "Price","Sale"  };
				
						SaleDrugManager DD=new SaleDrugManager();
						try{
						Object[][] data =DD.ShowSaleFullDrugs(sqlDateStart,sqlDatefinish);
						
						model = new DefaultTableModel(data,columns);
						table_2 = new JTable(model);
						table_2.setBounds(10, 10, 175, 200);
				
						//size of Drug table
						table_2.getColumnModel().getColumn(0).setPreferredWidth(400);
						table_2.getColumnModel().getColumn(1).setPreferredWidth(400);
						table_2.getColumnModel().getColumn(2).setPreferredWidth(400);
						table_2.getColumnModel().getColumn(3).setPreferredWidth(400);
						table_2.getColumnModel().getColumn(4).setPreferredWidth(400);
				
						JScrollPane	pane = new JScrollPane(table_2);
						pane.setBorder(BorderFactory.createTitledBorder ("SaleFulll Drugs"));
						pane.setSize(360, 550);
						pane.setLocation(21, 21);
						contentPane.add(pane);
						}
						catch(Exception e2){
							e2.printStackTrace();
							
						}
						
						
					}
				});
				button.setBounds(438, 184, 140, 23);
				contentPane.add(button);
	}
}
