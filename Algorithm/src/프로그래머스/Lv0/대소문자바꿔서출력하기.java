package 프로그래머스.Lv0;

import java.util.Scanner;

public class 대소문자바꿔서출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length(); i++) {
			if (Character.isUpperCase(a.charAt(i))) { // 대문자면
				sb.append(Character.toLowerCase(a.charAt(i))); // 소문자로
			} else { // 소문자면
				sb.append(Character.toUpperCase(a.charAt(i))); // 대문자로
			}
		}
		System.out.println(sb.toString());
	}
}
