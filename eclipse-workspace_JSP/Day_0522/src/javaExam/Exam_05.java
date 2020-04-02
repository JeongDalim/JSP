package javaExam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exam_05 {
	static Map<String, Integer> student = new HashMap<String, Integer>();

	public static void main(String[] args) {
		student.put("Park", 87);
		student.put("Kim", 79);
		student.put("Lee", 90); 
		student.put("Hong", 88);
		student.put("Jong", 95);
		student.put("Scott", 78);
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Name:");

		String name = scn.nextLine();

		Set<String> set = student.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String name2 = iter.next().toString();
			if (student.get(name) < student.get(name2)) {
				System.out.println(name2 + ":" + student.get(name2));
			}
		}

		scn.close();
	}
}
