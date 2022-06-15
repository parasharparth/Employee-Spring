package com.project.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /***********************************************************************************************************
     * Two ways of creating objects used here: -
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
         ************************************************************************************************************/
        ApplicationContext employeebean = new ClassPathXmlApplicationContext("employeebean.xml");
        Employee e2 = (Employee)employeebean.getBean("emp1");
        Employee e3 = employeebean.getBean("emp2",Employee.class);
        System.out.println("----------------Spring IOC container Object Usage--------------");
        System.out.println(e2);
        System.out.println(e3);

    }
}
