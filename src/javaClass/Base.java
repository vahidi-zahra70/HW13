package javaClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration	cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");
		SessionFactory	factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();	

//		Drog b = new Drog((Integer) 100,"drog1",100,200); 
//		Drog b1 = new Drog( (Integer) 101,"drog2",50,300); 
//		session.save(b); 
//		session.save(b1);
//		Insurance p = new Insurance((Integer) 1,"KhadamatDarmani"); 
//		Insurance p1 = new Insurance((Integer) 2,"TamineEjtemaee"); 
//		Insurance p2 = new Insurance((Integer) 3,"NiroohayeMosalah"); 
//		Insurance p3 = new Insurance((Integer) 4,"Salamat"); 
//		session.save(p);
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
//
//
//		DrogInsurance bp = new DrogInsurance(b, p1, 20); 
//		session.save(bp);
//		User u=new User("n.nasher","12345","Manager");
//		User u1=new User("z.vahidi","12346","Employee");
//		User u2=new User("a.aslani","12347","SalesOperator");
//		session.save(u);
//		session.save(u1);
//		session.save(u2);
		
		
		Drog dd=session.get(Drog.class, 100);
		Insurance ii=session.get(Insurance.class, 2);
		
		DrogInsurance bp2 = new DrogInsurance(dd, ii, 40);
		
		//System.out.println(bp2.getId());
		DrogInsurance bp3=session.get(DrogInsurance.class, bp2.getId());
		//bp3.setShare(10);
	//	session.update(bp3);
		System.out.println(bp3.getId().insuranceId);


		tx.commit();
	}

}
