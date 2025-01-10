package 프로그래머스.Lv0;

public class 컨트롤제트 {
	public static void main(String[] args) {
		String s = "1 2 Z 3";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = 0;
		String[] str_split = s.split(" ");
		for (int i = 0; i < str_split.length; i++) {
			if (str_split[i].equals("Z")) { // Z면 이전 숫자 빼기
				answer -= Integer.parseInt(str_split[i - 1]);
			} else { // 숫자면 더하기
				answer += Integer.parseInt(str_split[i]);
			}
		}
		return answer;
	}
}
