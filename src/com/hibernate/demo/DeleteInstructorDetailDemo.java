package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			int theId=3;
			InstructorDetail tempinstructorDetail = 
					session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructordetail " +tempinstructorDetail);
			
			tempinstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempinstructorDetail);
			
			
			session.getTransaction().commit();
			
			System.out.println("done!!!");

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}
		
		

	}

}
