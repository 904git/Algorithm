package 프로그래머스.Lv1;

import java.util.HashSet;

public class 폰켓몬 {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 3 };
		System.out.println(solution(nums));
	}

	static public int solution(int[] nums) {
		int answer = 0;
		HashSet<Integer> hash = new HashSet<>(); // 가질 수 있는 모든 종류
		for (int i = 0; i < nums.length; i++) {
			hash.add(nums[i]);
		}
		answer = Math.min(hash.size(), nums.length / 2); // 가질 수 있는 종류의 최대는 N/2
		return answer;
	}
}
