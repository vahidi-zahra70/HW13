package frameClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.persistence.Column;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import HibernateManager.InsuranceManager;
import HibernateManager.PatientDrugManager;
import HibernateManager.PatientManager;
import javaClass.Insurance;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Salesfirst extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_5;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salesfirst frame = new Salesfirst();
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
	public Salesfirst() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JLabel label = new JLabel("\u062B\u0628\u062A \u0627\u0637\u0627\u0639\u0627\u062A \u0647\u0645\u0631\u0627\u0647 \u062F\u0641\u062A\u0631\u0686\u0647 \u0628\u06CC\u0645\u0647 ");
		label.setBounds(158, 59, 239, 14);
		contentPane.add(label);
		JButton button = new JButton("\u06A9\u0627\u0631\u062A\u0627\u0628\u0644 \u062F\u0627\u0631\u0648 \u0647\u0627 \u0648 \u063A\u06CC\u0631\u0647 ");
		button.setBounds(744, 25, 131, 23);
		contentPane.add(button);



		JLabel label5 = new JLabel();
		label5.setBounds(0, 0, 0, 0);
		label5.setIcon(new ImageIcon("C:\\Users\\mandegar\\Desktop\\download.jpg"));// your image here
		contentPane.add(label5);




		JButton button_1 = new JButton("\u06A9\u0627\u0631\u062A\u0627\u0628\u0644 \u0628\u06CC\u0645\u0627\u0631\u0627\u0646");
		button_1.setBounds(500, 25, 117, 23);
		contentPane.add(button_1);

		JLabel label_1 = new JLabel("\u0646\u0627\u0645 :");
		label_1.setBounds(314, 84, 46, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u0646\u0627\u0645 \u062E\u0627\u0646\u0648\u0627\u062F\u06AF\u06CC : ");
		label_2.setBounds(302, 114, 95, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u0646\u0648\u0639 \u0628\u06CC\u0645\u0647 ");
		label_3.setBounds(314, 221, 46, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u062A\u0627\u0631\u06CC\u062E \u0645\u0631\u0627\u062C\u0639\u0647 :");
		label_4.setBounds(316, 179, 64, 14);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setBounds(190, 84, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(190, 123, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);


		JComboBox comboBox = new JComboBox();
		//		Integer [] a2 = new Integer []{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		//		JComboBox<Integer> comboBox = new JComboBox<Integer>(a2);
		comboBox.setBounds(239, 176, 45, 20);
		contentPane.add(comboBox);

		//month Patient
		JComboBox comboBox_1 = new JComboBox();
		//		String [] m2 = new String[]{"\u0641\u0631\u0648\u0631\u062F\u06CC\u0646","\u0627\u0631\u062F\u06CC\u0628\u0647\u0634\u062A","\u062E\u0631\u062F\u0627\u062F","\u062A\u06CC\u0631","\u0645\u0631\u062F\u0627\u062F","\u0634\u0647\u0631\u06CC\u0648\u0631","\u0645\u0647\u0631","\u0622\u0628\u0627\u0646","\u0622\u0630\u0631","\u062F\u06CC","\u0628\u0647\u0645\u0646","\u0627\u0633\u0641\u0646\u062F"};
		//		JComboBox<String> comboBox_1 = new JComboBox<String>(m2);
		comboBox_1.setBounds(176, 176, 60, 20);
		contentPane.add(comboBox_1);

		//year
		JComboBox comboBox_2 = new JComboBox();
		//		Integer y2[] =new Integer[]{1390,1391,1392,1393,1394,1395,1396};
		//		JComboBox<Integer> comboBox_2 = new JComboBox<Integer>(y2);
		comboBox_2.setBounds(106, 176, 60, 20);
		contentPane.add(comboBox_2);

		JLabel label_5 = new JLabel("\u0631\u0648\u0632");
		label_5.setBounds(242, 151, 46, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("\u0645\u0627\u0647");
		label_6.setBounds(176, 154, 46, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("\u0633\u0627\u0644");
		label_7.setBounds(106, 151, 46, 14);
		contentPane.add(label_7);

		//Getting Insurances names from database
		JComboBox comboBox_3 = new JComboBox();
		InsuranceManager MM=new InsuranceManager ();

		String b[]=MM.ShowInsurancesNames();

		//		JComboBox<String> comboBox_3 = new JComboBox<String>(b);
		//		comboBox_3.setBounds(158, 218, 120, 20);
		contentPane.add(comboBox_3);

		JLabel label_8 = new JLabel("\u0645\u0634\u062E\u0635\u0627\u062A \u062F\u0627\u0631\u0648\u06CC \u0628\u06CC\u0645\u0627\u0631 :");
		label_8.setBounds(1056, 44, 145, 14);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0627\u0631 ");
		label_9.setBounds(1103, 84, 46, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("\u06A9\u062F \u062F\u0627\u0631\u0648");
		label_10.setBounds(1103, 126, 46, 14);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("\u062A\u0639\u062F\u0627\u062F \u062F\u0627\u0631\u0648 ");
		label_11.setBounds(1087, 179, 64, 14);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("\u0647\u0632\u06CC\u0646\u0647 \u0646\u0647\u0627\u06CC\u06CC \u0646\u0633\u062E\u0647 \u0628\u06CC\u0645\u0627\u0631:");
		label_12.setBounds(1027, 269, 120, 14);
		contentPane.add(label_12);

		textField_2 = new JTextField();
		textField_2.setBounds(968, 81, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(968, 123, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(968, 173, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_14 = new JLabel("\u062B\u0628\u062A \u0627\u0637\u0627\u0639\u0627\u062A \u0628\u062F\u0648\u0646 \u062F\u0641\u062A\u0631\u0686\u0647 \u0628\u06CC\u0645\u0647  ");
		label_14.setBounds(598, 84, 196, 14);
		contentPane.add(label_14);

		JLabel label_15 = new JLabel("\u06A9\u062F \u062F\u0627\u0631\u0648 ");
		label_15.setBounds(763, 129, 46, 14);
		contentPane.add(label_15);

		JLabel label_16 = new JLabel("\u062A\u0639\u062F\u0627\u062F \u062F\u0627\u0631\u0648 ");
		label_16.setBounds(763, 179, 46, 14);
		contentPane.add(label_16);

		JLabel label_17 = new JLabel("\u062A\u0627\u0631\u06CC\u062E");
		label_17.setBounds(763, 235, 46, 14);
		contentPane.add(label_17);

		JLabel label_18 = new JLabel("\u0631\u0648\u0632");
		label_18.setBounds(677, 221, 46, 14);
		contentPane.add(label_18);

		JLabel label_19 = new JLabel("\u0645\u0627\u0647 ");
		label_19.setBounds(590, 221, 46, 14);
		contentPane.add(label_19);

		JLabel label_20 = new JLabel("\u0633\u0627\u0644");
		label_20.setBounds(500, 221, 46, 14);
		contentPane.add(label_20);


		//day
		JComboBox comboBox_4 = new JComboBox();
		//		Integer [] a = new Integer []{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		//		JComboBox <Integer> comboBox_4 = new JComboBox<Integer>(a);
		comboBox_4.setBounds(675, 249, 45, 20);
		contentPane.add(comboBox_4);


		//month
		JComboBox comboBox_5 = new JComboBox();
		//		String [] m = new String[]{"\u0641\u0631\u0648\u0631\u062F\u06CC\u0646","\u0627\u0631\u062F\u06CC\u0628\u0647\u0634\u062A","\u062E\u0631\u062F\u0627\u062F","\u062A\u06CC\u0631","\u0645\u0631\u062F\u0627\u062F","\u0634\u0647\u0631\u06CC\u0648\u0631","\u0645\u0647\u0631","\u0622\u0628\u0627\u0646","\u0622\u0630\u0631","\u062F\u06CC","\u0628\u0647\u0645\u0646","\u0627\u0633\u0641\u0646\u062F"};
		//		JComboBox<String> comboBox_5 = new JComboBox<String>(m);
		comboBox_5.setBounds(589, 249, 60, 20);
		contentPane.add(comboBox_5);


		//year
		JComboBox comboBox_6 = new JComboBox();
		//		Integer y[] =new Integer[]{1390,1391,1392,1393,1394,1395,1396}; 
		//		JComboBox<Integer> comboBox_6 = new JComboBox<Integer>(y);
		comboBox_6.setBounds(497, 246, 60, 20);
		contentPane.add(comboBox_6);

		textField_7 = new JTextField();
		textField_7.setBounds(608, 126, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(608, 176, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		JLabel label_21 = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0627\u0631 ");
		label_21.setBounds(0, 0, 0, 0);
		contentPane.add(label_21);

		textField_9 = new JTextField();
		textField_9.setBounds(0, 0, 0, 0);
		textField_9.setColumns(10);
		contentPane.add(textField_9);

		JLabel label_22 = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0627\u0631 ");
		label_22.setBounds(0, 0, 0, 0);
		contentPane.add(label_22);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 0, 0);
		contentPane.add(lblNewLabel);

		JLabel label_23 = new JLabel("\u0646\u0627\u0645 :");
		label_23.setBounds(0, 0, 0, 0);
		contentPane.add(label_23);

		JLabel label_24 = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0627\u0631");
		label_24.setBounds(84, 84, 46, 14);
		contentPane.add(label_24);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(43, 111, 86, 20);
		contentPane.add(textField_10);

		//Inserting a new Patient
		JButton button_2 = new JButton("\u062A\u0627\u06CC\u06CC\u062F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("")
						|| textField_10.getText().equals("")){
					JOptionPane.showMessageDialog(contentPane, "Please insert the id, name and family of the Patient to insert a new Patient!");
				}
				else{
					try {
						Integer id=Integer.parseInt(textField_10.getText());
						String name=textField.getText();
						String family=textField_1.getText();
						Integer day =(Integer) comboBox.getItemAt(comboBox.getSelectedIndex());
						int month =comboBox_1.getSelectedIndex()+1;
						Integer year =(Integer) comboBox_2.getItemAt(comboBox_2.getSelectedIndex());
						String InsuranceType =(String) comboBox_3.getItemAt(comboBox_3.getSelectedIndex());
						String date=year+"/"+month+"/"+day;


						PatientManager II=new PatientManager();
						if(!II.insertPateint(id, name, family, date, InsuranceType)){
							JOptionPane.showMessageDialog(contentPane, "The Patient you want to insert exist in the table!");
						}
						textField.setText("");
						textField_1.setText("");
						textField_10.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Insert a number as the Patient Id!");
					} 
				}	

			}
		});
		button_2.setBounds(190, 248, 117, 23);
		contentPane.add(button_2);

		//inserting the drugs for the patient
		JButton button_3 = new JButton("\u062A\u0627\u06CC\u06CC\u062F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals("") || textField_3.getText().equals("")
						|| textField_4.getText().equals("")){
					JOptionPane.showMessageDialog(contentPane, "Please insert the id, name and family of the Patient to insert a new Patient!");
				}
				else{
					try {
						Integer PatientID=Integer.parseInt(textField_2.getText());
						Integer DrugID=Integer.parseInt(textField_3.getText());
						Integer quantity=Integer.parseInt(textField_4.getText());


						PatientDrugManager II=new PatientDrugManager();
						if(!II.insertPateintDrug(PatientID, DrugID, quantity)){
							JOptionPane.showMessageDialog(contentPane, "The field can not be inserted!");
						}
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Insert a number as the Patient Id and Drug ID and Quantity of drug!");
					} 
				}	



			}
		});
		button_3.setBounds(968, 217, 117, 23);
		contentPane.add(button_3);

		JLabel label_13 = new JLabel("");
		label_13.setBounds(922, 269, 95, 14);
		contentPane.add(label_13);

		JLabel label_25 = new JLabel("\u06A9\u062F \u0628\u06CC\u0645\u0627\u0631 ");
		label_25.setBounds(1103, 297, 46, 14);
		contentPane.add(label_25);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(968, 294, 86, 20);
		contentPane.add(textField_5);


		//computing the total cost for the Patient
		JButton button_4 = new JButton("\u0645\u062D\u0627\u0633\u0628\u0647 \u0647\u0632\u06CC\u0646\u0647 \u0646\u0633\u062E\u0647 \u0628\u06CC\u0645\u0627\u0631");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_5.getText().equals("") ){
					JOptionPane.showMessageDialog(contentPane, "Please insert the ID for the Patient you want to compute total cost!");
				}
				else{
					try {
						Integer PatientID=Integer.parseInt(textField_5.getText());
						PatientDrugManager II=new PatientDrugManager();
						if(II.totalCostPateintDrug(PatientID)==-1){
							JOptionPane.showMessageDialog(contentPane, "This Patient does not exist!");
						}
						else{
							label_13.setText(Integer.toString(II.totalCostPateintDrug(PatientID)));
							
						}
						textField_5.setText("");

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Insert a number as the Patient Id and Drug ID and Quantity of drug!");
					} 
				}


			}
		});
		button_4.setBounds(968, 325, 160, 23);
		contentPane.add(button_4);




	}
}
