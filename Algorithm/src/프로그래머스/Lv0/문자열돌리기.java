package 프로그래머스.Lv0;

import java.util.Scanner;

public class 문자열돌리기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length(); i++) {
			sb.append(a.charAt(i) + "\n");
		}
		System.out.println(sb.toString());
	}
}
