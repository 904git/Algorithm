package 프로그래머스.Lv3;

public class 기지국설치 {
	public static void main(String[] args) {
		int n = 11;
		int[] stations = { 1 };
		int w = 1;
		System.out.println(solution(n, stations, w));
	}

	static public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int apt_idx = 1; // 전파가 통하지 않는 아파트의 시작위치
		for (int i = 0; i < stations.length; i++) {
			int dist = stations[i] - apt_idx - w; // 전파가 통하지 않는 거리 길이
			if (0 < dist) {
				int cnt = dist % (2 * w + 1) == 0 ? dist / (2 * w + 1) : dist / (2 * w + 1) + 1; // 설치해야할 기지국 개수
				answer += cnt;
			}
			apt_idx = stations[i] + w + 1; // 이동
		}
		if (apt_idx <= n) { // 남은 거리에 기지국 설치
			int dist = n - apt_idx + 1;
			int cnt = dist % (2 * w + 1) == 0 ? dist / (2 * w + 1) : dist / (2 * w + 1) + 1;
			answer += cnt;
		}
		return answer;
	}
}
