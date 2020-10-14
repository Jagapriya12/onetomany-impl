package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			
			session.beginTransaction();
			
			int theId =1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			Course tempCourse1 =  new Course("Springboot tutorial");
			Course tempCourse2 =  new Course("hibernate tutorial");

			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
							
			
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
