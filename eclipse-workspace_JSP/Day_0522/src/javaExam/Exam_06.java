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
		System.out.println("���� �µ��� ȭ�� �µ��� �ٲٷ��� C �Ǵ� c�� �Է��Ͻÿ�.\r\n" + "ȭ�� �µ��� ���� �µ��� �ٲٷ��� F �Ǵ� f�� �Է��Ͻÿ�.");
		System.out.print("�Է�: ");
		String option1 = scn.nextLine();
		if (option1.equalsIgnoreCase("C") || option1.equalsIgnoreCase("F")) {
			if (option1.equalsIgnoreCase("C")) {
				System.out.print("���� �µ��� �Է��Ͻÿ�: ");
				int cOndo = scn.nextInt();
				String num = String.format("%.2f", (double) cOndo);
				String num2 = String.format("%.2f", (double) CtoF(cOndo));
				System.out.println("����" + num + "���� ȭ�� " + num2 + "���Դϴ�.");

			} else if (option1.equalsIgnoreCase("F")) {
				System.out.print("ȭ�� �µ��� �Է��Ͻÿ�: ");
				int fOndo = scn.nextInt();
				String num = String.format("%.2f", (double) fOndo);
				String num2 = String.format("%.2f", (double) FtoC(fOndo));
				System.out.println("ȭ��" + num + "���� ���� " + num2 + "���Դϴ�.");
			}
		} else {
			System.err.println("�߸��� �Է��Դϴ�.");
		}
		scn.close();
	}
}