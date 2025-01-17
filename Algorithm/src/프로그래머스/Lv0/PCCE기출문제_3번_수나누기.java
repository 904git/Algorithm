package 프로그래머스.Lv0;

import java.util.Scanner;

public class PCCE기출문제_3번_수나누기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int answer = 0;

		for (int i = 0; number > 0; i++) { // 수정
			answer += number % 100;
			number /= 100;
		}

		System.out.println(answer);
	}
}
