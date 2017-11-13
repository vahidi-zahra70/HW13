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


public class DrogManager {

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

	//show all Drugs
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

	//show all Critical Drugs
	public Object [][] ShowCriticalDrogs( ) throws SQLException {
		Object[][] data = null;
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<Drog> drogs=new ArrayList<Drog>();
		try{
			tx = session.beginTransaction();
			String hql = "FROM Drog E WHERE E.inventory < 10";
			Query query = session.createQuery(hql);
			List results =  query.list();
			Iterator itr = results.iterator();
			while (itr.hasNext()) {
				Drog emp = (Drog) itr.next();
				drogs.add(emp);
				System.out.println(emp.getName());
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
	//delete one drug
	public boolean deleteOneInsurance(int id) throws SQLException{

		boolean is_exist=false;
		Session session = factory.openSession();
		Transaction tx = null;
		Insurance ticket;
		try{
			tx = session.beginTransaction();
			ticket=new Insurance();
			ticket=	session.get(Insurance.class, id);

			if(	ticket!=null){

				session.delete(ticket); 
				is_exist=true;
				System.out.println("successfully deleted");
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return is_exist;
	}

	//update the price for a  Drug
	public boolean updateOneDrug(Drog t) throws SQLException{

		boolean is_exist=false;
		Session session = factory.openSession();
		Transaction tx = null;
		Drog insurance;
		try{
			tx = session.beginTransaction();
			insurance=new Drog();
			int id=t.getId();
			insurance=	session.get(Drog.class, id);

			if(	insurance!=null){
				insurance.setPrice(t.getPrice());
				session.update(insurance);
				is_exist=true;
				System.out.println("successfully update"); 

			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return is_exist;
	}


	//update the inventory for a  Drug
	public boolean updateInventoryDrug(Integer DrugID,int quantity) throws SQLException{

		boolean is_exist=false;
		Session session = factory.openSession();
		Transaction tx = null;
		Drog insurance;
		try{
			tx = session.beginTransaction();
			insurance=new Drog();

			insurance=	session.get(Drog.class, DrugID);

			if(	insurance!=null){
				if(insurance.getInventory()-quantity>=0){
					insurance.setInventory(insurance.getInventory()-quantity);
					session.update(insurance);
					is_exist=true;
					System.out.println("successfully update"); 
				}
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return is_exist;
	}





}
