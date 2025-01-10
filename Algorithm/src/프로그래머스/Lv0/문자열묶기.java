package 프로그래머스.Lv0;

public class 문자열묶기 {
	public static void main(String[] args) {
		String[] strArr = { "a", "bc", "d", "efg", "hi" };
		System.out.println(solution(strArr));
	}

	static public int solution(String[] strArr) {
		int answer = 0;
		int[] lenCnt = new int[31]; // 길이별 원소 개수
		for (int i = 0; i < strArr.length; i++) {
			lenCnt[strArr[i].length()] += 1;
		}
		for (int i = 0; i < lenCnt.length; i++) {
			if (answer < lenCnt[i]) {
				answer = lenCnt[i];
			}
		}
		return answer;
	}
}
