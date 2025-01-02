package 프로그래머스.Lv0;

public class 개미군단 {
	public static void main(String[] args) {
		int hp = 23;
		System.out.println(solution(hp));
	}

	static public int solution(int hp) {
		int answer = 0;
		for (int i = 5; i > 0 && hp > 0; i -= 2) { // i는 개미군단의 공격력(장군개미:5, 병정개미:3, 일개미1)
			answer += hp / i; // 공격력이 높은 개미부터 배치할 마릿수 카운트
			hp -= i * (hp / i); // 체력 깎기
		}
		return answer;
	}

}
