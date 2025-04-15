package 프로그래머스.Lv1;

public class 키패드누르기 {
	public static void main(String[] args) {
		int[] numbers = { 1, 6, 2, 3, 1 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
		// 1, 2, 3
		// 4, 5, 6
		// 7, 8, 9
		// *, 0, #
	}

	static public String solution(int[] numbers, String hand) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		int[][] point = { { 3, 0 }, { 3, 2 } }; // 왼손, 오른손 위치
		for (int i = 0; i < numbers.length; i++) {
			int[] target = { (numbers[i] - 1) / 3, (numbers[i] - 1) % 3 };
			if (numbers[i] == 0 || numbers[i] % 3 == 2) { // 왼쪽, 오른족 중 더 가까운 손
				if (numbers[i] == 0) { // 0번 위치
					target[0] = 3;
					target[1] = 1;
				}
				int[] dist = new int[2]; // 왼손, 오른손 거리 계산
				for (int j = 0; j < dist.length; j++) {
					dist[j] = Math.abs((point[j][0] - target[0])) + Math.abs((point[j][1] - target[1]));
				}
				if (dist[1] < dist[0]) { // 오른손 거리가 더 짧음
					sb.append("R");
					moveFinger(point[1], target);
				} else if (dist[0] < dist[1]) { // 왼손 거리가 더 짧음
					sb.append("L");
					moveFinger(point[0], target);
				} else { // 거리 같음
					if (hand.equals("right")) { // 오른손잡이
						sb.append("R");
						moveFinger(point[1], target);
					} else { // 왼손잡이
						sb.append("L");
						moveFinger(point[0], target);
					}
				}
			} else if (numbers[i] % 3 == 0) { // (3, 6, 9) 오른손으로
				sb.append("R");
				moveFinger(point[1], target);
			} else { // (1, 4, 7) 왼손으로
				sb.append("L");
				moveFinger(point[0], target);
			}
		}
		answer = sb.toString();
		return answer;
	}

	static public void moveFinger(int[] point, int[] target) { // 손가락 이동
		point[0] = target[0];
		point[1] = target[1];
	}
}
