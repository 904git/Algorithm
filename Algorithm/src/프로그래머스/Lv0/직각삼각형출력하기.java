package 프로그래머스.Lv0;

import java.util.Scanner;

public class 직각삼각형출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) { // 줄 수
			for (int j = 0; j <= i; j++) {// 별 수
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
