package 프로그래머스.Lv0;

public class 커피심부름 {
	public static void main(String[] args) {
		String[] order = { "cafelatte", "americanoice", "hotcafelatte", "anything" };
		System.out.println(solution(order));
	}

	static public int solution(String[] order) {
		int answer = 0;
		for (int i = 0; i < order.length; i++) {
			if (order[i].contains("americano")) { // 아메리카노
				answer += 4500;
			} else if (order[i].contains("cafelatte")) { // 카페라떼
				answer += 5000;
			} else { // 아무거나는 아메리카노
				answer += 4500;
			}
		}
		return answer;
	}
}
