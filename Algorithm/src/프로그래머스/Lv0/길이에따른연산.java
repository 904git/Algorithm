package 프로그래머스.Lv0;

public class 길이에따른연산 {
	public static void main(String[] args) {
		int[] num_list = { 3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1 };
		System.out.println(solution(num_list));
	}

	static public int solution(int[] num_list) {
		int answer = 0;
		if (num_list.length > 10) { // 리스트의 길이가 11 이상이면 원소의 합
			for (int i = 0; i < num_list.length; i++) {
				answer += num_list[i];
			}
		} else { // 리스트의 길이가 10 이하이면 원소의 곱
			answer = 1;
			for (int i = 0; i < num_list.length; i++) {
				answer *= num_list[i];
			}
		}
		return answer;
	}

}
