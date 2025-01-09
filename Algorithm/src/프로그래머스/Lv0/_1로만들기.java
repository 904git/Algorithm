package 프로그래머스.Lv0;

public class _1로만들기 {
	public static void main(String[] args) {
		int[] num_list = { 12, 4, 15, 1, 14 };
		System.out.println(solution(num_list));
	}

	static public int solution(int[] num_list) {
		int answer = 0;
		for (int i = 0; i < num_list.length; i++) {
			while (num_list[i] > 1) {
				if (num_list[i] % 2 == 0) { // num_list[i]가 짝수이면
					num_list[i] /= 2;
				} else { // num_list[i]가 홀수이면
					num_list[i] = (num_list[i] - 1) / 2;
				}
				answer += 1;
			}
		}
		return answer;
	}

}
