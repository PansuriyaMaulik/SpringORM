package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        System.out.println("*********Welcome to Spring ORM Application*********");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;

        while (go) {
            System.out.println("Press 1 for add new student");
            System.out.println("Press 2 for fetch all student");
            System.out.println("Press 3 for fetch single student");
            System.out.println("Press 4 for delete student");
            System.out.println("Press 5 for update student");
            System.out.println("Press 6 for exit student");

            try {
                int Input = Integer.parseInt(br.readLine());
                Scanner sc = new Scanner(System.in);

                switch (Input) {
                    case 1:
                        //Insert data
                        System.out.println("Enter the Student ID, Name and City you want to Update:");

                        int id1=sc.nextInt();
                        String name1 = sc.next();
                        String city1 = sc.next();
                        Student student = new Student(id1, name1, city1);
                        int result = studentDao.insert(student);
                        System.out.println("Data inserted.."+result);
                        break;
                    case 2:
                        //Fetch all data
                        List<Student> student2 = studentDao.getAllStudents();
                        for(Student s:student2)
                        {
                            System.out.println(s);
                        }
                        break;
                    case 3:
                        //Fetch single data
                        int id3=sc.nextInt();
                        Student student3 = studentDao.getStudent(id3);
                        System.out.println(student3);
                        break;
                    case 4:
                        //Delete data
                        System.out.println("Enter the Student ID you want to Delete:");
                        int id4=sc.nextInt();
                        studentDao.deleteStudent(id4);
                        System.out.println("Delete Record Successfully");
                        break;
                    case 5:
                        //Update data
                        int id5=sc.nextInt();
                        String name5 = sc.next();
                        String city5 = sc.next();
                        Student student5 = new Student(id5, name5, city5);
                        studentDao.updateStudent(student5);
                        break;
                    case 6:
                        //Exit
                        go = false;
                        break;
                }
            }catch (Exception e) {
                System.out.println("Invalid input please select another..");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you so much for using my application");
    }
}
