package com.project.employee;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    /***********************************************************************************************************
     * Two ways of creating objects used here: - Object creation means the filling of object attributes
     * and not the allocation of memory using new keyword
     * Traditional method of object creation
     * Spring bean method of object creation
     * The major use of XML based spring is we can configure and change objects at any time using XML
     * Example of layouts in Android where XML is used to configure the layout of the screen
     * @param args
     ************************************************************************************************************/
    public static void main(String args[])
    {

        /***********************************************
         * Traditional Method of object creation
         * Uses the normal object and getter setter
         * Values put in the code
         ***********************************************/
        Employee e1 = new Employee();
        e1.setEmployeeId(1);
        e1.setEmployeeName("Parth");
        e1.setEmployeeSalary(25000);
        System.out.println("-----------------Traditional object usage---------------");
        System.out.println(e1);

        /************************************************************************************************************
         * Spring method of object creation
         * Follows these steps
         * 1) Add jar files for spring core
         * 2) Configure Java object in the XML file
         * 3) Use spring IOC container (Bean Factory/ Application Context to get objects constructed using XML.
         *
         * In the beans defined in XML, properties for an id is key value pairing
         * The first one is using the Application Context
         * The second one is using the bean factory
         ************************************************************************************************************/
        ApplicationContext employeebean = new ClassPathXmlApplicationContext("employeebean.xml");
        Employee e2 = (Employee)employeebean.getBean("emp1");
        Employee e3 = employeebean.getBean("emp2",Employee.class);
        System.out.println("----------------Spring IOC container Object Usage by Application Context--------------");
        System.out.println(e2);
        System.out.println(e3);


        Resource resource = new ClassPathResource("employeebean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        Employee e4 = (Employee)factory.getBean("emp1");
        Employee e5 = factory.getBean("emp2", Employee.class);

        System.out.println("----------------Spring IOC Container Object usage by Bean Factory ---------------");
        System.out.println(e4);
        System.out.println(e5);

        /*************************************************************************************************
         * Application Context will create objects for you even though you did not request for it
         * BeanFactory will not create the object until and unless the object reference has been created
         * In Bean Factory, objects will be created when getBeans method is called
         *************************************************************************************************/
    }
}
