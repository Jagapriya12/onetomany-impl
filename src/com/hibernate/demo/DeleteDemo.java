package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			int instructor_id =1;
			session.beginTransaction();
			
			Instructor instr = session.get(Instructor.class, instructor_id);
			
			System.out.println("found instuctro "+instr);
			
			if(instr!= null)
			{
				System.out.println("deleting instructor "+instr);
				session.delete(instr);
			}
			session.getTransaction().commit();
			
			System.out.println("done!!!");

		}
		finally
		{
			factory.close();
		}
		
		

	}

}
