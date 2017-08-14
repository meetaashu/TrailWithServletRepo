package springTrialPackage;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Resource resource= new ClassPathResource("classpath:applicationContext.xml");
//BeanFactory factory= new XmlBeanFactory(resource);
//
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student= (Student)context.getBean("studentbean");

student.displayInfo();
	}
}
