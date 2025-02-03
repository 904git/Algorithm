package 프로그래머스.Lv0;

public class 다음에올숫자 {
	public static void main(String[] args) {
		int[] common = { 1, 2, 3, 4 };
		System.out.println(solution(common));
	}

	static public int solution(int[] common) {
		int answer = 0;
		if (common[1] - common[0] == common[2] - common[1]) { // 등차수열
			answer = common[0] + (common[1] - common[0]) * common.length;
		} else { // 등비수열
			answer = common[0] * (int) Math.pow((common[1] / common[0]), common.length);
		}
		return answer;
	}
}
