package javaExam;

import java.util.Scanner;

public class Exam_06 {

	public static int CtoF(int cOndo) {
		int fOndo = cOndo * 9 / 5 + 32;
		return fOndo;

	}

	public static int FtoC(int fOndo) {
		int cOndo = (fOndo - 32) * 5 / 9;
		return cOndo;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("섭씨 온도를 화씨 온도로 바꾸려면 C 또는 c를 입력하시오.\r\n" + "화씨 온도를 섭씨 온도로 바꾸려면 F 또는 f를 입력하시오.");
		System.out.print("입력: ");
		String option1 = scn.nextLine();
		if (option1.equalsIgnoreCase("C") || option1.equalsIgnoreCase("F")) {
			if (option1.equalsIgnoreCase("C")) {
				System.out.print("섭씨 온도를 입력하시오: ");
				int cOndo = scn.nextInt();
				String num = String.format("%.2f", (double) cOndo);
				String num2 = String.format("%.2f", (double) CtoF(cOndo));
				System.out.println("섭씨" + num + "도는 화씨 " + num2 + "도입니다.");

			} else if (option1.equalsIgnoreCase("F")) {
				System.out.print("화씨 온도를 입력하시오: ");
				int fOndo = scn.nextInt();
				String num = String.format("%.2f", (double) fOndo);
				String num2 = String.format("%.2f", (double) FtoC(fOndo));
				System.out.println("화씨" + num + "도는 섭씨 " + num2 + "도입니다.");
			}
		} else {
			System.err.println("잘못된 입력입니다.");
		}
		scn.close();
	}
}