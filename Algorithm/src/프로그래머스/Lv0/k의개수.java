package 프로그래머스.Lv0;

public class k의개수 {
	public static void main(String[] args) {
		int i = 1, j = 13, k = 1;
		System.out.println(solution(i, j, k));
	}

	static public int solution(int i, int j, int k) {
		int answer = 0;
		for (int num = i; num <= j; num++) {
			int temp = num;
			while (temp > 0) {
				if (temp % 10 == k) { // 자릿수에 k가 들어가면
					answer += 1;
				}
				temp /= 10;
			}
		}
		return answer;
	}
}
