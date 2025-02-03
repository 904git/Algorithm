package 프로그래머스.Lv1;

public class 기사단원의무기 {
	public static void main(String[] args) {
		int number = 5, limit = 3, power = 2;
		System.out.println(solution(number, limit, power));
	}

	static public int solution(int number, int limit, int power) {
		int answer = 0;
		for (int num = 1; num <= number; num++) {
			int count = 0;
			// 약수 갯수 구하기
			for (int i = 1; i < Math.sqrt(num); i++) {
				if (num % i == 0) {
					count += 2;
				}
			}
			if (num % Math.sqrt(num) == 0) {
				count += 1;
			}
			// 약수의 갯수가 제한 수치를 넘는지 확인
			if (limit < count) {
				answer += power;
			} else {
				answer += count;
			}
		}
		return answer;
	}
}
