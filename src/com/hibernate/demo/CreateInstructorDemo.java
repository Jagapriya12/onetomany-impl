package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			Instructor tempInstructor = 
					new Instructor("priya","patel","priyapatel@gmail.com");
			InstructorDetail tempInstructdetail =
					new InstructorDetail("acefam","gardening");
			
			tempInstructor.setInstructorDetail(tempInstructdetail);
			
			
			session.beginTransaction();
			
			System.out.println("saving tempinstructor "+tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("done!!!");

		}
		finally
		{
			session.close();
			factory.close();
		}
		
		

	}

}
