package 프로그래머스.Lv3;

public class 스티커모으기2 {
	public static void main(String[] args) {
		int[] sticker = { 14, 6, 5, 11, 3, 9, 2, 10 };
		System.out.println(solution(sticker));
	}

	static public int solution(int sticker[]) {
		int answer = 0;
		if (sticker.length == 1) { // 길이가 1이면
			answer = sticker[0];
		} else { // 길이가 2 이상이면
			int[][] sum = new int[2][sticker.length];
			sum[0][1] = sticker[0]; // 첫 번째 스티커를 뽑는 경우 누적 합
			sum[1][1] = sticker[1]; // 첫 번째 스티커를 안 뽑는 경우 누적 합
			for (int i = 2; i < sticker.length; i++) {
				sum[0][i] = Math.max(sum[0][i - 1], sum[0][i - 2] + sticker[i - 1]);
				sum[1][i] = Math.max(sum[1][i - 1], sum[1][i - 2] + sticker[i]);
			}
			answer = Math.max(sum[0][sticker.length - 1], sum[1][sticker.length - 1]);
		}
		return answer;
	}

}
