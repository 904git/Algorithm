package 프로그래머스.Lv0;

public class 원소들의곱과합 {
	public static void main(String[] args) {
		int[] num_list = { 3, 4, 5, 2, 1 };
		System.out.println(solution(num_list));
	}

	static public int solution(int[] num_list) {
		int answer = 0;
		int mul = 1, sum = 0;
		for (int i = 0; i < num_list.length; i++) {
			mul *= num_list[i]; // 모든 원소의 곱
			sum += num_list[i]; // 모든 원소의 합
		}
		answer = mul < sum * sum ? 1 : 0;
		return answer;
	}
}
