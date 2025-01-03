package 프로그래머스.Lv0;

public class 첫번째로나오는음수 {
	public static void main(String[] args) {
		int[] num_list = { 12, 4, 15, 46, 38, -2, 15 };
		System.out.println(solution(num_list));
	}

	static public int solution(int[] num_list) {
		int answer = -1; // 음수가 없다면 -1
		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] < 0) { // 음수가 나오면 인덱스 저장 후 반복문 중단
				answer = i;
				break;
			}
		}
		return answer;
	}

}
