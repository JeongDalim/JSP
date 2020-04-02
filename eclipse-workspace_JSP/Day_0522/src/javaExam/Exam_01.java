package javaExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam_01 {
	static List<Integer> list = new ArrayList<Integer>();

	public static int index(int cnt, int input) {
		for (int i = cnt; i < list.size(); i++) {
			if (input == list.get(i)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		list.add(89);
		list.add(84);
		list.add(90);
		list.add(77);
		list.add(95);
		list.add(90);
		list.add(65);
		list.add(100);
		list.add(90);
		list.add(84);
		Scanner scanner = new Scanner(System.in);
		System.out.print("input: ");
		int input = scanner.nextInt();
		int cnt = 0;
		System.out.print(input + "의 인덱스는");
		while (cnt < list.size()) {
			cnt = index(cnt, input);
			if (cnt == -1) {
				break;
			}
			System.out.print(cnt + 1 + ",");
			cnt++;
		}
		System.out.println("입니다.");
		scanner.close();
	}

}
