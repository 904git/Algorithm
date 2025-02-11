package 프로그래머스.Lv0;

public class PCCE기출문제_6번_물부족 {
	public static void main(String[] args) {
		int storage = 5141, usage = 500;
		int[] change = { 10, -10, 10, -10, 10, -10, 10, -10, 10, -10 };
		System.out.println(solution(storage, usage, change));
	}

	static public int solution(int storage, int usage, int[] change) {
		int total_usage = 0;
		for (int i = 0; i < change.length; i++) {
			usage = usage + usage * change[i] / 100; // 수정
			total_usage += usage;
			if (total_usage > storage) {
				return i;
			}
		}
		return -1;
	}
}
