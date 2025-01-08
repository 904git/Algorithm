package 프로그래머스.Lv1;

public class 하샤드수 {
	public static void main(String[] args) {
		int x = 10;
		System.out.println(solution(x));
	}

	static public boolean solution(int x) {
		boolean answer = false;
		int sum = 0, temp = x;
		while (temp > 0) { // 자릿수 더하기
			sum += temp % 10;
			temp /= 10;
		}
		if (x % sum == 0) { // 자깃수 합으로 나누어 떨어지면 하샤드 수
			answer = true;
		}
		return answer;
	}
}
