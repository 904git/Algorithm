package 프로그래머스.Lv0;

public class 주사위의개수 {
	public static void main(String[] args) {
		int[] box = { 1, 1, 1 };
		int n = 1;
		System.out.println(solution(box, n));
	}

	static public int solution(int[] box, int n) {
		int answer = (box[0] / n) * (box[1] / n) * (box[2] / n); // 각 변의 길이를 주사위 길이로 나눈 몫끼리 곱하기
		return answer;
	}
}
