package 프로그래머스.Lv0;

import java.util.Scanner;

public class 문자열반복해서출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(str);
		}
		System.out.println(sb.toString());
	}
}
