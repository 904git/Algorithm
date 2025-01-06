package 프로그래머스.Lv0;

public class 가까운1찾기 {
	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 1 };
		int idx = 1;
		System.out.println(solution(arr, idx));
	}

	static public int solution(int[] arr, int idx) {
		int answer = -1;
		for (int i = idx; i < arr.length; i++) { // idx 번호부터 search
			if (arr[i] == 1) { // 1을 찾으면 인덱스 저장 후 반복문 종료
				answer = i;
				break;
			}
		}
		return answer;
	}
}
