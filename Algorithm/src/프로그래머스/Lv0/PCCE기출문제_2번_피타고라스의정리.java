package 프로그래머스.Lv0;

import java.util.Scanner;

public class PCCE기출문제_2번_피타고라스의정리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int c = sc.nextInt();

		int b_square = c * c - a * a;

		System.out.println(b_square);
	}
}
