package javaExam;

import java.util.ArrayList;
import java.util.List;

public class Exam_03 {
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("tall");
		words.add("school");
		words.add("school");
		words.add("school");
		words.add("hi");
		words.add("hey");
		String word = "";
		int length = 0;
		for (int i = 0; i < words.size(); i++) {
			for (int j = i + 1; j < words.size(); j++) {
				if (words.get(i).length() > words.get(j).length()) {
					length = words.get(i).length();
				}
			}
		}

		for (int z = 0; z < words.size(); z++) {
			if (words.get(z).length() == length) {
				word += words.get(z) + " ";
			}
		}
		System.out.println("output:" + word);
	}
}