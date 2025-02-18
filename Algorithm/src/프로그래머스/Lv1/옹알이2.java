package 프로그래머스.Lv1;

public class 옹알이2 {
	public static void main(String[] args) {
		String[] babbling = { "aya", "yee", "u", "maa" };
		System.out.println(solution(babbling));
	}

	static public int solution(String[] babbling) {
		int answer = 0;
		String[] dict = { "aya", "ye", "woo", "ma" }; // 발음 사전
		for (int i = 0; i < babbling.length; i++) {
			for (int j = 0; j < dict.length; j++) {
				babbling[i] = babbling[i].replaceAll(dict[j], Integer.toString(j)); // 발음을 숫자로 변환
			}
			System.out.println(babbling[i]);
			int idx = -1; // 발음한 단어의 인덱스
			for (int j = 0; j < babbling[i].length(); j++) {
				if (Character.isAlphabetic(babbling[i].charAt(j))) { // 발음 못하는 단어
					idx = -1; // 발음 실패
					break;
				} else if (0 < j && babbling[i].charAt(j) == babbling[i].charAt(j - 1)) { // 같은 단어 연속
					idx = -1; // 발음 실패
					break;
				} else { // 발음 성공
					idx = j;
				}
			}
			if (0 <= idx) { // 단어 발음에 성공하면 +1
				answer += 1;
			}
		}
		return answer;
	}
}
