package 프로그래머스.Lv0;

import java.util.Arrays;

public class 뒤에서5등위로 {
	public static void main(String[] args) {
		int[] num_list = { 12, 4, 15, 46, 38, 1, 14, 56, 32, 10 };
		System.out.println(Arrays.toString(solution(num_list)));
	}

	static public int[] solution(int[] num_list) {
		int[] answer = {};
		Arrays.sort(num_list); // 오름차순 정렬
		answer = Arrays.copyOfRange(num_list, 5, num_list.length); //인덱스 5부터 copy 
		return answer;
	}
}
