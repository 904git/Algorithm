package 프로그래머스.Lv0;

public class 옹알이1 {
	public static void main(String[] args) {
		String[] babbling = { "aya", "yee", "u", "maa", "wyeoo" };
		System.out.println(solution(babbling));
	}

	static public int solution(String[] babbling) {
		int answer = 0;
		String[] words = { "aya", "ye", "woo", "ma" };
		for (int i = 0; i < babbling.length; i++) {
			int cnt = 0;
			for (int j = 0; j < words.length; j++) {
				int idx = babbling[i].indexOf(words[j]);
				if (0 <= idx) { // 발음할 수 있는 단어가 존재하면
					cnt += words[j].length(); // 단어 길이 증가
				}
			}
			if (cnt == babbling[i].length()) { // 발음할 수 있는 길이와 단어의 길이가 일치하면 수 증가
				answer += 1;
			}
		}
		return answer;
	}
}
