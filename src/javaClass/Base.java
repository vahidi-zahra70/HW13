package javaClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;



public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration	cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");
		SessionFactory	factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();	

						Drog b = new Drog((Integer) 100,"drog1",100,200); 
						Drog b1 = new Drog( (Integer) 101,"drog2",50,300); 
						session.save(b); 
						session.save(b1);
						Insurance p = new Insurance((Integer) 1,"KhadamatDarmani"); 
						Insurance p1 = new Insurance((Integer) 2,"TamineEjtemaee"); 
						Insurance p2 = new Insurance((Integer) 3,"NiroohayeMosalah"); 
						Insurance p3 = new Insurance((Integer) 4,"Salamat"); 
						session.save(p);
						session.save(p1);
						session.save(p2);
						session.save(p3);
						DrogInsurance bp = new DrogInsurance(b, p1, 20); 
						session.save(bp);
						User u=new User("n.nasher","12345","Manager");
						User u1=new User("z.vahidi","12346","Employee");
						User u2=new User("a.aslani","12347","SalesOperator");
						session.save(u);
						session.save(u1);
						session.save(u2);
						
						Drog b2 = new Drog((Integer) 102,"drog3",900,3); 
						Drog b3 = new Drog( (Integer) 103,"drog4",50,11); 
						Drog b4 = new Drog((Integer) 104,"drog5",10,22); 
						Drog b5 = new Drog( (Integer) 105,"drog6",50,340); 
						Drog b6 = new Drog((Integer) 106,"drog7",10,2); 
						Drog b7 = new Drog( (Integer) 107,"drog8",34,90); 
						session.save(b2);
						session.save(b3); 
						session.save(b4); 
						session.save(b5); 
						session.save(b6); 
						session.save(b7);
						
						Insurance p4=session.get(Insurance.class, 4);
						DrogInsurance bp3 = new DrogInsurance(b3, p4, 60); 
						session.save(bp3);
						
						Insurance p5=session.get(Insurance.class, 3);
						DrogInsurance bp4 = new DrogInsurance(b3, p5, 40); 
						session.save(bp4);
						
						
						//patient
						java.sql.Date sqlDate = null;
						SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

						try {
							java.util.Date utilDate = format.parse("1396/06/06");
							sqlDate = new java.sql.Date(utilDate.getTime());
							System.out.println(sqlDate);
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						Patient d1=new Patient(1,"Patient1","Family1",p,sqlDate);
						//Patient d2=new Patient(2,"Patient2","Family2",p,"1396/07/06");
						session.save(d1); 
						//session.save(d2);
						PatientDrog PD=new PatientDrog(d1,b2,20,sqlDate);
						session.save(PD);
						
						//Sale
						SaleDrug dd=new SaleDrug(b,20,sqlDate);
						session.save(dd);
		     			tx.commit();


		//		Drog dd=session.get(Drog.class, 100);
		//		Insurance ii=session.get(Insurance.class, 2);
		//
		//		DrogInsurance bp2 = new DrogInsurance(dd, ii, 40);
		//
		//		//System.out.println(bp2.getId());
		//		DrogInsurance bp3=session.get(DrogInsurance.class, bp2.getId());
		//		bp3.setShare(10);
		//		session.update(bp3);
		//		System.out.println(bp3.getId().insuranceId);


//		ArrayList<Integer> names=new ArrayList<Integer>();
//
//		int b=2;
//		String hql = "SELECT cost FROM PatientDrog E where E.patient='"+b+"' ";
//
//		Query query = session.createQuery(hql);
//		List results = query.list();
//		Iterator itr = results.iterator();
//		int sum=0;
//		while(itr.hasNext()){
//			sum=sum+(int) itr.next();
//
//		}
//
//		System.out.println(sum);
//
//		tx.commit();

	}

}
