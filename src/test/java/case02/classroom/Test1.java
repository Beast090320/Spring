package case02.classroom;

import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.classroom.Student;
import com.study.spring.case02.classroom.Teacher;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");

		Student[] students = { ctx.getBean("student1", Student.class), ctx.getBean("student2", Student.class),
				ctx.getBean("student3", Student.class), };

		Arrays.stream(students).forEach(System.out::println);

		Teacher teacher1 = ctx.getBean("teacher1", Teacher.class);
		System.out.println(teacher1);

		// 求指定學生的該學分

		Student student1 = ctx.getBean("student1", Student.class);
		int sum = student1.getClazzs().stream().mapToInt(c -> c.getCredit())
				// .peek(System.out::println)
				.sum();

		System.out.println("sums = " + sum);
		// 將上述邏輯寫成一個Function
		ToIntFunction<Student> func1 = (s) -> s.getClazzs().stream().mapToInt(c -> c.getCredit()).sum();
		// 學生所選科目 (John 3 + 1) 2科平均2 ，(Mary 3 + 2 + 1) 3科平均2 ， 2 + 2 平均為2
		ToDoubleFunction<Student> func2 = (s) -> s.getClazzs().stream().mapToInt(c -> c.getCredit()).average().getAsDouble();
		// teacher1 也就是 Bob 這位老師
		// 他旗下所屬學生的該學分為何?
		// 例如: 若John 的總學分為 3 + 1 = 4, Helen 的總學分為 6 (3+2+1)
		// 則總學分為 10
		int total = teacher1.getStudents().stream().mapToInt(func1).sum();
		System.out.println("Total = " + total);
		double avg = teacher1.getStudents().stream().mapToDouble(func2).average().getAsDouble();
		System.out.println("Avg = " + avg);
		//重構1-Student.java---------------------------------------------------------------------------------------------------------------
		int total2 = teacher1.getStudents().stream().mapToInt(s ->s.getTotalCredits()).sum();
		System.out.println("Total2 = " + total2);
		//重構2-Teacher.java---------------------------------------------------------------------------------------------------------------
		int total3 = teacher1.getTotalByStudentCredit();
		System.out.println("Total3 = " + total3);

	}

}