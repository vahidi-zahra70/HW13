package HibernateManager;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Map;

import javaClass.Drog;
import javaClass.Insurance;
import javaClass.Patient;
import javaClass.SaleDrug;


public class SaleDrugManager {

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

	//inserting a new SaleDrug
	public boolean insertSaleDrug(Integer DrugID,int  quantity,java.sql.Date date ){
		boolean is_exist=false;
		Session session = factory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			Drog d=session.get(Drog.class, DrugID);
			if(d!=null){
				SaleDrug CC=new SaleDrug(d,quantity,date);
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


	//show all Drugs
	//	public Object [][] ShowDrogs( ) throws SQLException {
	//		Object[][] data = null;
	//		Session session = factory.openSession();
	//		Transaction tx = null;
	//		ArrayList<Drog> drogs=new ArrayList<Drog>();
	//		try{
	//			tx = session.beginTransaction();
	//			Criteria criteria = session.createCriteria(Drog.class);
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
	//		}catch (HibernateException e) {
	//			if (tx!=null) tx.rollback();
	//			e.printStackTrace(); 
	//		}finally {
	//			session.close(); 
	//		}
	//		return data;
	//	}

	//show all SaleFullDrug Drugs
	public Object [][] ShowSaleFullDrugs( java.sql.Date sqlDateStart,java.sql.Date sqlDatefinish ) throws SQLException {
		Object[][] data = null;
		Session session = factory.openSession();
		Transaction tx = null;
		ArrayList<SaleDrug> saledrogs=new ArrayList<SaleDrug>();
		try{
			tx = session.beginTransaction();


			String hql = "SELECT sum(E.quantity) "
					+ "FROM SaleDrug E 	WHERE E.date >= '" +sqlDateStart+ "' AND E.date< '"+sqlDatefinish+"'"
					+ "group by E.drog";
			Query query = session.createQuery(hql);
			List results =  query.list();
			Iterator itr = results.iterator();
			double AvgSale=0;
			while (itr.hasNext()) {
				long QuantitySale=(long) itr.next();
				AvgSale=AvgSale+QuantitySale;
			}
			AvgSale=AvgSale/results.size();
			System.out.println(AvgSale);


			Query query2 = session.createQuery("SELECT E.drog ,sum(E.quantity) "
					+ "FROM SaleDrug E 	WHERE E.date >= '" +sqlDateStart+ "' AND E.date< '"+sqlDatefinish+"'"
					+ "group by E.drog");
			ArrayList<Drog> drugs=new ArrayList<Drog>();
			ArrayList<Long> sales=new ArrayList<Long>();
			
			List<Object[]> users= (List<Object[]>)query2.list();

			for(Object[] user: users){

				Drog dd = (Drog)user[0];

				System.out.println(dd.getId());

				long sale = (long)user[1];

				System.out.println(sale);
				if(sale>AvgSale){
					drugs.add(dd);
					sales.add(sale);
				}
				

			}
			System.out.println(drugs.size());
			System.out.println(drugs.get(0).getName());
			System.out.println(sales.get(0));
			tx.commit();

			data =new Object[drugs.size()][5];
						for(int i=0;i<drugs.size();i++){
							data[i][0]=drugs.get(i).getId();
							data[i][1]=drugs.get(i).getName();
							data[i][2]=drugs.get(i).getInventory();
							data[i][3]=drugs.get(i).getPrice();
							data[i][4]=sales.get(i);
			
						}

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return data;
	}	
	//	//delete one drug
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
	//	//update the price for a  Drug
	//	public boolean updateOneDrug(Drog t) throws SQLException{
	//
	//		boolean is_exist=false;
	//		Session session = factory.openSession();
	//		Transaction tx = null;
	//		Drog insurance;
	//		try{
	//			tx = session.beginTransaction();
	//			insurance=new Drog();
	//			int id=t.getId();
	//			insurance=	session.get(Drog.class, id);
	//
	//			if(	insurance!=null){
	//				insurance.setPrice(t.getPrice());
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
	//
	//
	//	//update the inventory for a  Drug
	//	public boolean updateInventoryDrug(Integer DrugID,int quantity) throws SQLException{
	//
	//		boolean is_exist=false;
	//		Session session = factory.openSession();
	//		Transaction tx = null;
	//		Drog insurance;
	//		try{
	//			tx = session.beginTransaction();
	//			insurance=new Drog();
	//
	//			insurance=	session.get(Drog.class, DrugID);
	//
	//			if(	insurance!=null){
	//				if(insurance.getInventory()-quantity>=0){
	//					insurance.setInventory(insurance.getInventory()-quantity);
	//					session.update(insurance);
	//					is_exist=true;
	//					System.out.println("successfully update"); 
	//				}
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
