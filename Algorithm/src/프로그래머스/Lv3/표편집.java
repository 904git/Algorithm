package 프로그래머스.Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 표편집 {
	public static void main(String[] args) {
		int n = 8, k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
		System.out.println(solution(n, k, cmd));
	}

	// 시간초과
	static public String solution(int n, int k, String[] cmd) {
		String answer = "";
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int select = k;
		for (int i = 0; i < cmd.length; i++) {
			String[] str_split = cmd[i].split(" ");
			if (str_split[0].equals("U")) { // 위로 이동
				select -= Integer.parseInt(str_split[1]);
			} else if (str_split[0].equals("D")) { // 아래로 이동
				select += Integer.parseInt(str_split[1]);
			} else if (str_split[0].equals("C")) { // 삭제
				stack.add(list.remove(select));
				if (list.size() == select) { // 마지막 행 삭제시
					select -= 1;
				}
			} else { // 복구
				int num = stack.pop();
				int idx = findIndex(list, num, 0, list.size()); // 복구할 자리 찾기
				list.add(idx, num);
				if (idx <= select) {
					select += 1;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append("O");
		}
		while (!stack.isEmpty()) { // 삭제된 행 X로 표시
			int idx = stack.pop();
			sb.replace(idx, idx + 1, "X");
		}
		answer = sb.toString();
		return answer;
	}

	static public int findIndex(List<Integer> list, int num, int left, int right) { // 이진탐색으로 자리 찾기
		if (right <= left) {
			return left;
		}
		int mid = (left + right) / 2;
		if (num < list.get(mid)) {
			return findIndex(list, num, left, mid);
		} else if (list.get(mid) < num) {
			return findIndex(list, num, mid + 1, right);
		}
		return mid;
	}
}
