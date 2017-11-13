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
import javaClass.SaleDrug;


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
	public boolean insertPateint(Integer id,String name,String family,java.sql.Date  date,String InsuranceType){
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

	//show all SaleFullDrug Drugs
//	public Object [][] ShowSaleFullDrugs( java.sql.Date sqlDateStart,java.sql.Date sqlDatefinish ) throws SQLException {
//		Object[][] data = null;
//		Session session = factory.openSession();
//		Transaction tx = null;
//		ArrayList<SaleDrug> saledrogs=new ArrayList<SaleDrug>();
//		try{
//			tx = session.beginTransaction();
//
//
//
//
//
//			Query query2 = session.createQuery("SELECT * "
//					+ "FROM Patient E 	WHERE E.date >= '" +sqlDateStart+ "' AND E.date< '"+sqlDatefinish+"'"
//					+ "group by E.drog");
//			Query query=session.createQuery(arg0)
//			List tickets2 = criteria.list();
//			Iterator itr = tickets2.iterator();
//			while (itr.hasNext()) {
//				Drog emp = (Drog) itr.next();
//				drogs.add(emp);
//			}
//			tx.commit();
//
//			data =new Object[drogs.size()][4];
//			for(int i=0;i<drogs.size();i++){
//				data[i][0]=drogs.get(i).getId();
//				data[i][1]=drogs.get(i).getName();
//				data[i][2]=drogs.get(i).getInventory();
//				data[i][3]=drogs.get(i).getPrice();
//
//			}
//			
////			Query query2 = session.createQuery("SELECT * "
////					+ "FROM Patient E 	WHERE E.date >= '1396-06-01' AND E.date< '1396-06-31'"
////					+ "group by E.drog");
////			
////			System.out.println(drugs.size());
////			System.out.println(drugs.get(0).getName());
////			System.out.println(sales.get(0));
////			tx.commit();
////
////			data =new Object[drugs.size()][5];
////						for(int i=0;i<drugs.size();i++){
////							data[i][0]=drugs.get(i).getId();
////							data[i][1]=drugs.get(i).getName();
////							data[i][2]=drugs.get(i).getInventory();
////							data[i][3]=drugs.get(i).getPrice();
////							data[i][4]=sales.get(i);
////			
////						}
////			
//
//			tx.commit();
//
//
//
//		}catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace(); 
//		}finally {
//			session.close(); 
//		}
//		return data;
//	}	


}

