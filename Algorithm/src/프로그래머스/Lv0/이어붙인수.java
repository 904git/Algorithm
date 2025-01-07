package 프로그래머스.Lv0;

public class 이어붙인수 {
	public static void main(String[] args) {
		int[] num_list = { 3, 4, 5, 2, 1 };
		System.out.println(solution(num_list));
	}

	static public int solution(int[] num_list) {
		int answer = 0;
		StringBuffer odd = new StringBuffer(); // 홀수 이어붙일 버퍼
		StringBuffer even = new StringBuffer(); // 짝수 이어붙일 버퍼
		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] % 2 != 0) { // 홀수
				odd.append(num_list[i]);
			} else { // 짝수
				even.append(num_list[i]);
			}
		}
		answer = Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
		return answer;
	}
}
