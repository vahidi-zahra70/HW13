package HibernateManager;


import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javaClass.Drog;


public class DrogManager {
	
	Configuration cfg=null;
	SessionFactory factory=null;

	{
		cfg= new Configuration(); 
		cfg.configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	
	
	public Object [][] ShowDrogs( ) throws SQLException {
		Object[][] data = null;
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Drog> drogs=new ArrayList<Drog>();
		try{
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Drog.class);
			List tickets2 = criteria.list();
			Iterator itr = tickets2.iterator();
			while (itr.hasNext()) {
				Drog emp = (Drog) itr.next();
				drogs.add(emp);
			}
			tx.commit();
			
		    data =new Object[drogs.size()][4];
			for(int i=0;i<drogs.size();i++){
				data[i][0]=drogs.get(i).getId();
				data[i][1]=drogs.get(i).getName();
				data[i][2]=drogs.get(i).getInventory();
				data[i][3]=drogs.get(i).getPrice();
			
			}

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return data;
	}
	
	

}
