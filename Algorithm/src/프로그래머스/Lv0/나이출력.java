package 프로그래머스.Lv0;

public class 나이출력 {
	public static void main(String[] args) {
		int age = 40;
		System.out.println(solution(age));
	}

	static public int solution(int age) {
		int answer = 2022 - age + 1; // 기준 년도에서 나이 계산
		return answer;
	}

}
