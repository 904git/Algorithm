package 프로그래머스.Lv2;

public class 최댓값과최솟값 {
	public static void main(String[] args) {
		String s = "1 2 3 4";
		System.out.println(solution(s));
	}

	static public String solution(String s) {
		String answer = "";
		String[] str_split = s.split(" ");
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < str_split.length; i++) {
			if (max < Integer.parseInt(str_split[i])) { // 최댓값 구하기
				max = Integer.parseInt(str_split[i]);
			}

			if (Integer.parseInt(str_split[i]) < min) { // 최솟값 구하기
				min = Integer.parseInt(str_split[i]);
			}
		}
		answer = min + " " + max;
		return answer;
	}

}
