package 프로그래머스.Lv2;

public class 조이스틱 {
	public static void main(String[] args) {
		String name = "BBBBAAAABA"; // JEROEN
		System.out.println(solution(name));
	}

	static public int solution(String name) {
		int answer = 0;
		int move = name.length() - 1; // 좌우로 움직이는 횟수
		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(26 - (name.charAt(i) - 'A'), (name.charAt(i) - 'A')); // 레버 위아래로 움직여야 하는 횟수
			int y = i + 1;
			while (y < name.length() && name.charAt(y) == 'A') {
				y++;
			}
			move = Math.min(move, Math.min(2 * i + (name.length() - y), 2 * (name.length() - y) + i));
		}
		return answer + move;
	}

	static public int solution2(String name) {
		int answer = 0;
		boolean[] visit = new boolean[name.length()];
		int i = 0;
		while (!check(visit)) {
			visit[i] = true;

			int right = name.length() <= i + 1 ? 0 : i + 1;
			int left = i - 1 < 0 ? name.length() - 1 : i - 1;
			int rightCnt = 1, leftCnt = 1;
			while (right != i) {
				if (name.charAt(right) != 'A' && !visit[right]) {
					break;
				}
				rightCnt += 1;
				visit[right] = true;
				right = name.length() <= right + 1 ? 0 : right + 1;
			}
			while (left != i) {
				if (name.charAt(left) != 'A' && !visit[left]) {
					break;
				}
				leftCnt += 1;
				visit[left] = true;
				left = left - 1 < 0 ? name.length() - 1 : left - 1;
			}
			if (!visit[right] && rightCnt <= leftCnt) {
				answer += rightCnt;
				i = right;
			} else if (!visit[left] && leftCnt <= rightCnt) {
				answer += leftCnt;
				i = left;
			}
		}
		return answer;
	}

	static public boolean check(boolean[] array) {
		for (int i = 0; i < array.length; i++) {
			if (!array[i]) {
				return false;
			}
		}
		return true;
	}
}
