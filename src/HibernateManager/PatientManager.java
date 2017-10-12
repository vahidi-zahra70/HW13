package HibernateManager;



import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javaClass.Drog;
import javaClass.Insurance;
import javaClass.Patient;


public class PatientManager {

	Configuration cfg=null;
	SessionFactory factory=null;

	{ try{
		DBManager DD=new DBManager();
		cfg=DD.getconn();
		factory=DD.getfactory();
	}
	catch (Exception e) {

		e.printStackTrace(); 
	}

	}
	//show all insurances
	//	public Object [][] ShowInsurances( ) throws SQLException {
	//		Object[][] data = null;
	//		Session session = factory.openSession();
	//		Transaction tx = null;
	//		ArrayList<Insurance> insurances=new ArrayList<Insurance>();
	//		try{
	//			tx = session.beginTransaction();
	//			Criteria criteria = session.createCriteria(Insurance.class);
	//			List insurances2 = criteria.list();
	//			Iterator itr = insurances2.iterator();
	//			while (itr.hasNext()) {
	//				Insurance emp = (Insurance) itr.next();
	//				insurances.add(emp);
	//			}
	//			tx.commit();
	//			
	//		    data =new Object[insurances.size()][2];
	//			for(int i=0;i<insurances.size();i++){
	//				data[i][0]=insurances.get(i).getId();
	//				data[i][1]=insurances.get(i).getType();
	//	
	//			}
	//
	//		}catch (HibernateException e) {
	//			if (tx!=null) tx.rollback();
	//			e.printStackTrace(); 
	//		}finally {
	//			session.close(); 
	//		}
	//		return data;
	//	}
	//	
	//	//show all insurances names for table
	//		public String[] ShowInsurancesNames( ) throws SQLException {
	//			Object[][] data = null;
	//			Session session = factory.openSession();
	//			Transaction tx = null;
	//			ArrayList<String> names=new ArrayList<String>();
	//			try{
	//				tx = session.beginTransaction();
	//				
	//     			String hql = "SELECT E.type FROM Insurance E";
	//     			Query query = session.createQuery(hql);
	//     			List results = query.list();
	//     			Iterator itr = results.iterator();
	//    			while (itr.hasNext()) {
	//    				String emp = (String) itr.next();
	//    				names.add(emp);
	//    				
	//    			}
	//				tx.commit();
	//
	//
	//			}catch (HibernateException e) {
	//				if (tx!=null) tx.rollback();
	//				e.printStackTrace(); 
	//			}finally {
	//				session.close(); 
	//			}
	//			String Names[]=new String[names.size()];
	//			for(int i=0;i<names.size();i++){
	//				Names[i]=names.get(i);
	//			}
	//			return Names;
	//		}
	//	
	//inserting a new Patient
	public boolean insertPateint(Integer id,String name,String family,String date,String InsuranceType){
		boolean is_exist=false;
		Session session = factory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			String hql = "SELECT id FROM Insurance E where E.type like '%" +InsuranceType+ "%'";
			Query query = session.createQuery(hql);
			List results = query.list();
			Iterator itr = results.iterator();
			Integer InsuranceID = (Integer) itr.next();
			Insurance insurance=session.get(Insurance.class, InsuranceID);
			Patient CC=new Patient(id,name,family,insurance,date);
			if(session.get(Patient.class, CC.getId())==null){
				session.save(CC); 
				System.out.println("successfully saved"); 
				is_exist=true;
				tx.commit();
			}

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return is_exist;

	}



	//delete one Insurance
	//	public boolean deleteOneInsurance(int id) throws SQLException{
	//
	//		boolean is_exist=false;
	//		Session session = factory.openSession();
	//		Transaction tx = null;
	//		Insurance ticket;
	//		try{
	//			tx = session.beginTransaction();
	//			ticket=new Insurance();
	//			ticket=	session.get(Insurance.class, id);
	//
	//			if(	ticket!=null){
	//
	//				session.delete(ticket); 
	//				is_exist=true;
	//				System.out.println("successfully deleted");
	//			}
	//			tx.commit();
	//		}catch (HibernateException e) {
	//			if (tx!=null) tx.rollback();
	//			e.printStackTrace(); 
	//		}finally {
	//			session.close(); 
	//		}
	//		return is_exist;
	//	}
	//
	//	//update one Insurance
	//	public boolean uodateOneInsurance(Insurance t) throws SQLException{
	//
	//		boolean is_exist=false;
	//		Session session = factory.openSession();
	//		Transaction tx = null;
	//		Insurance insurance;
	//		try{
	//			tx = session.beginTransaction();
	//			insurance=new Insurance();
	//			int id=t.getId();
	//			insurance=	session.get(Insurance.class, id);
	//
	//			if(	insurance!=null){
	//				insurance.setType(t.getType());
	//				session.update(insurance);
	//				is_exist=true;
	//				System.out.println("successfully update"); 
	//
	//			}
	//			tx.commit();
	//		}catch (HibernateException e) {
	//			if (tx!=null) tx.rollback();
	//			e.printStackTrace(); 
	//		}finally {
	//			session.close(); 
	//		}
	//		return is_exist;
	//	}




}

