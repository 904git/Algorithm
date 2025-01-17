package 프로그래머스.Lv1;

public class 푸드파이트대회 {
	public static void main(String[] args) {
		int[] food = { 1, 3, 4, 6 };
		System.out.println(solution(food));
	}

	static public String solution(int[] food) {
		String answer = "";
		StringBuffer table = new StringBuffer();
		StringBuffer half = new StringBuffer(); // 왼쪽 사람이 먹는 순서
		for (int i = 1; i < food.length; i++) {
			for (int j = 0; j < food[i] / 2; j++) { // 둘이 먹는 양을 똑같이
				half.append(i);
			}
		}
		table.append(half);
		table.append(0); // 가운데 물
		table.append(half.reverse()); // 오른쪽 사람이 먹는 순서
		answer = table.toString();
		return answer;
	}
}
