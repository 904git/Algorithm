package 프로그래머스.Lv1;

public class 숫자문자열과영단어 {
	public static void main(String[] args) {
		String s = "one4seveneight";
		System.out.println(solution(s));
	}

	static public int solution(String s) {
		int answer = 0;
		String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i < number.length; i++) {
			s = s.replaceAll(number[i], Integer.toString(i)); // 영단어를 숫자로 변환
		}
		answer = Integer.parseInt(s);
		return answer;
	}
}
