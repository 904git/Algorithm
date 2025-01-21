package 프로그래머스.Lv1;

import java.util.Arrays;

public class 비밀지도 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}

	static public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < arr1.length; i++) {
			StringBuffer row1 = new StringBuffer(Integer.toBinaryString(arr1[i])); // 지도 1
			StringBuffer row2 = new StringBuffer(Integer.toBinaryString(arr2[i])); // 지도 2
			while (row1.length() < n) { // 지도 크기에 맞게 0 추가
				row1.insert(0, 0);
			}
			while (row2.length() < n) { // 지도 크기에 맞게 0 추가
				row2.insert(0, 0);
			}

			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < Math.min(row1.length(), row2.length()); j++) {
				// 둘 중에 하나라도 1이 있으면
				if (row1.charAt(row1.length() - 1 - j) == '1' || row2.charAt(row2.length() - 1 - j) == '1') {
					sb.insert(0, "#");
				} else { // 둘 다 0이면
					sb.insert(0, " ");
				}
			}
			answer[i] = sb.toString();
		}
		return answer;
	}
}
