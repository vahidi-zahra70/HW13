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
import javaClass.Insurance;


public class InsuranceManager {
	
	Configuration cfg=null;
	SessionFactory factory=null;

	{
		cfg= new Configuration(); 
		cfg.configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	
	
	public Object [][] ShowInsurances( ) throws SQLException {
		Object[][] data = null;
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Insurance> insurances=new ArrayList<Insurance>();
		try{
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Insurance.class);
			List insurances2 = criteria.list();
			Iterator itr = insurances2.iterator();
			while (itr.hasNext()) {
				Insurance emp = (Insurance) itr.next();
				insurances.add(emp);
			}
			tx.commit();
			
		    data =new Object[insurances.size()][2];
			for(int i=0;i<insurances.size();i++){
				data[i][0]=insurances.get(i).getId();
				data[i][1]=insurances.get(i).getType();
	
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

