package 프로그래머스.Lv1;

public class 카드뭉치 {
	static boolean result;

	public static void main(String[] args) {
		String[] cards1 = { "i", "drink", "water" };
		String[] cards2 = { "want", "to" };
		String[] goal = { "i", "want", "to", "drink", "water" };
		System.out.println(solution(cards1, cards2, goal));
	}

	static public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "";
		result = false;
		game(cards1, cards2, goal, 0, 0, 0); // 카드 게임
		if (result) { // 성공하면
			answer = "Yes";
		} else { // 실패하면
			answer = "No";
		}
		return answer;
	}

	static public void game(String[] cards1, String[] cards2, String[] goal, int goalIdx, int idx1, int idx2) {
		if (goalIdx == goal.length) { // 목표끝까지 완료 되었으면 성공
			result = true;
			return;
		}

		for (int i = goalIdx; i < goal.length; i++) {
			if (idx1 < cards1.length && cards1[idx1].equals(goal[i])) { // card1 뭉치에서 단어 사용 가능하면
				game(cards1, cards2, goal, i + 1, idx1 + 1, idx2);
			} else if (idx2 < cards2.length && cards2[idx2].equals(goal[i])) { // card2 뭉치에서 단어 사용 가능하면
				game(cards1, cards2, goal, i + 1, idx1, idx2 + 1);
			} else { // 둘 다 사용 못 하면
				break;
			}
		}
	}
}
