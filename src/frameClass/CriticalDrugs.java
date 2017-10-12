package frameClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import HibernateManager.DrogManager;

import javax.swing.JLabel;

public class CriticalDrugs extends JFrame {

	private JPanel contentPane;
	JTable table_2;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			CriticalDrugs frame = new CriticalDrugs();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CriticalDrugs() throws SQLException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Table of CriticalDrugs
		String[] columns = new String[] {
				"Id", "Name","Inventory", "Price"  };

		DrogManager DD=new DrogManager();
		Object[][] data =DD.ShowCriticalDrogs();
		model = new DefaultTableModel(data,columns);
		table_2 = new JTable(model);
		table_2.setBounds(10, 10, 175, 200);

		//size of Drug table
		table_2.getColumnModel().getColumn(0).setPreferredWidth(400);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(400);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(400);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(400);

		JScrollPane	pane = new JScrollPane(table_2);
		pane.setBorder(BorderFactory.createTitledBorder ("Critical Drugs"));
		pane.setSize(260, 550);
		pane.setLocation(73, 21);
		contentPane.add(pane);
	}
}
