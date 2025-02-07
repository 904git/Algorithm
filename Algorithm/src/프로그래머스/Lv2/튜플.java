package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class 튜플 {
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(s)));
	}

	static public int[] solution(String s) {
		s = s.replaceAll("\\}.\\{", "/"); // 집합 나누는 글자 바꾸기
		s = s.substring(2, s.length() - 2); // 앞뒤 중괄호 없애기
		String[] str_split = s.split("/"); // ["2", "2,1", "2,1,3", "2,1,3,4"]
		int[][] set = new int[str_split.length][]; // 집합
		for (int i = 0; i < str_split.length; i++) { // 집합 정리
			String[] nums = str_split[i].split(",");
			set[i] = new int[nums.length];
			for (int j = 0; j < nums.length; j++) {
				set[i][j] = Integer.parseInt(nums[j]);
			}
		}
		Arrays.sort(set, new MySort()); // 집합을 길이순으로 정렬
		int[] answer = new int[set[set.length - 1].length];
		HashSet<Integer> hash = new HashSet<>(); // 숫자 중복 확인용
		for (int i = 0, idx = 0; i < set.length; i++) {
			for (int j = 0; j < set[i].length; j++) {
				if (!hash.contains(set[i][j])) {
					answer[idx++] = set[i][j];
					hash.add(set[i][j]);
				}
			}
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 배열 길이순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1.length - o2.length;
		}

	}
}
