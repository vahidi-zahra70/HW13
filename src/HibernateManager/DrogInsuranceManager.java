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

import javaClass.DrogInsurance;
import javaClass.Insurance;

public class DrogInsuranceManager {
	
	Configuration cfg=null;
	SessionFactory factory=null;

	{
		cfg= new Configuration(); 
		cfg.configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	
	
	public Object [][] ShowDrogInsurance( ) throws SQLException {
		Object[][] data = null;
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<DrogInsurance> Droginsurance=new ArrayList<DrogInsurance>();
		try{
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(DrogInsurance.class);
			List insurances2 = criteria.list();
			Iterator itr = insurances2.iterator();
			while (itr.hasNext()) {
				DrogInsurance emp = (DrogInsurance) itr.next();
				Droginsurance.add(emp);
			}
			tx.commit();
			
		    data =new Object[Droginsurance.size()][2];
			for(int i=0;i<Droginsurance.size();i++){
				data[i][0]=Droginsurance.get(i).getDrog();
				//data[i][1]=Droginsurance.get(i).
	
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
