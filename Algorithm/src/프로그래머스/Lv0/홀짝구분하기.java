package 프로그래머스.Lv0;

import java.util.Scanner;

public class 홀짝구분하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 0) { // 짝수 판별
			System.out.println(n + " is even");
		} else {
			System.out.println(n + " is odd");
		}
	}
}
