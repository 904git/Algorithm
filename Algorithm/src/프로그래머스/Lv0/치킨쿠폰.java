package 프로그래머스.Lv0;

public class 치킨쿠폰 {
	public static void main(String[] args) {
		int chicken = 100;
		System.out.println(solution(chicken));
	}

	static public int solution(int chicken) {
		int answer = 0;
		while (chicken / 10 > 0) { // 서비스를 더 주문할 수 있을 때까지
			answer += chicken / 10; // 서비스로 주문한 치킨
			chicken = chicken / 10 + chicken % 10; // 서비스로 주문해서 받은 치킨쿠폰과 남아있던 쿠폰 합
		}
		return answer;
	}
}
