package example.powermock.demo.staticvariable;

import example.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class StaticDemo {
//    private static Logger logger = LoggerFactory.getLogger(StaticDemo.class);
    private static  String id = "001";
    private static  Student student = new Student(1111);

    public static String getId(){
        return id;
    }
    public static int getStudentId(){
        return student.getI();
    }
}