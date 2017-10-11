package HibernateManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javaClass.User;

public class UserManager {
	
	Configuration cfg=null;
	SessionFactory factory=null;

	{
		cfg= new Configuration(); 
		cfg.configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
	}
	public String validation_of_user(String username,String password){
		String position="NotExist";
		Session session = factory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			User user=session.get(User.class,username);
			if(user!=null && user.getPassword().equals(password)){
				position=user.getPosition();
				
			}
			
			 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return position;
		
		
	}

}
