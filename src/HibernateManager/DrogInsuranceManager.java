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
import javaClass.DrogInsurance;
import javaClass.Insurance;

public class DrogInsuranceManager {

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

			data =new Object[Droginsurance.size()][3];
			for(int i=0;i<Droginsurance.size();i++){
				data[i][0]=Droginsurance.get(i).getId().getDrogId();
				data[i][1]=Droginsurance.get(i).getId().getInsuranceId();
				data[i][2]=Droginsurance.get(i).getShare();
			}

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return data;
	}


	//Edit a DrugInsurance
	public boolean updateOneDrugInsurance(Integer DrugID,Integer InsuranceID,int Share) throws SQLException{

		boolean is_exist=false;
		Session session = factory.openSession();
		Transaction tx = null;
		Insurance insurance;
		Drog drug;
		try{
			tx = session.beginTransaction();
			insurance=new Insurance();
			insurance=	session.get(Insurance.class, InsuranceID);

			drug=new Drog();
			drug=session.get(Drog.class, DrugID);

			if(	insurance!=null && drug!=null){
				DrogInsurance bp2 = new DrogInsurance(drug, insurance, Share);
				DrogInsurance bp3=session.get(DrogInsurance.class, bp2.getId());
				if(bp3!=null){
					bp3.setShare(Share);
					session.update(bp3);
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
