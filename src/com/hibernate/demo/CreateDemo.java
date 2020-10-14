package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			Instructor tempInstructor = 
					new Instructor("madhu","patel","madhu@gmail.com");
			InstructorDetail tempInstructdetail =
					new InstructorDetail("acefam","kidding");
			
			tempInstructor.setInstructorDetail(tempInstructdetail);
			
			
			session.beginTransaction();
			
			System.out.println("saving tempinstructor "+tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("done!!!");

		}
		finally
		{
			factory.close();
		}
		
		

	}

}
