package 프로그래머스.Lv0;

public class 옷가게할인받기 {
	public static void main(String[] args) {
		int price = 150000;
		System.out.println(solution(price));
	}

	static public int solution(int price) {
		int answer = 0;
		if (price >= 500000) { // 50만원 이상일 때 20% 할인
			answer = (int) (price * 0.8);
		} else if (price >= 300000) {// 30만원 이상일 때 10% 할인
			answer = (int) (price * 0.9);
		} else if (price >= 100000) {// 10만원 이상일 때 5% 할인
			answer = (int) (price * 0.95);
		} else {
			answer = price;
		}
		return answer;
	}

}
