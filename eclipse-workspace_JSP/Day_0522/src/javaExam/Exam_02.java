package javaExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Alice", 23);
		map.put("Peter", 19);
		map.put("Andy", 25);
		map.put("David", 19);
		map.put("Tom", 22);
		map.put("Bob", 31);
		map.put("Paul", 25);
		map.put("Karen", 40);
		map.put("Cindy", 30);
		map.put("Sally", 28);
		map.put("Sue", 32);
		System.out.print("Enter name : ");
		String name = scanner.nextLine();
		if(map.get(name)!=null){
		System.out.println(name + "is "+map.get(name)+" years old.");
		}else {
		System.out.println(name + " is not exist");	
		}
		scanner.close();
	}
}
