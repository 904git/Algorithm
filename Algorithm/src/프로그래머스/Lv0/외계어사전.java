package 프로그래머스.Lv0;

public class 외계어사전 {
	public static void main(String[] args) {
		String[] spell = { "p", "o", "s" };
		String[] dic = { "sod", "eocd", "qixm", "adio", "soo" };
		System.out.println(solution(spell, dic));
	}

	static public int solution(String[] spell, String[] dic) {
		int answer = 2; // 존재하지 않으면 2
		for (int i = 0; i < dic.length; i++) {
			int[] alpha = new int[26];
			for (int j = 0; j < dic[i].length(); j++) {
				alpha[dic[i].charAt(j) - 'a'] += 1; // 단어에 들어간 알파벳 수 측정
			}
			boolean check = true;
			// 단어에 들어간 알파벳이 spell에 있는 알파벳을 한번만 사용해서 만들어진 건지 확인
			for (int j = 0; j < spell.length; j++) {
				if (alpha[spell[j].charAt(0) - 'a'] != 1) { // 없거나 한 번만 사용되지 않았으면 false
					check = false;
					break;
				}
			}
			if (check) { // 조건을 만족하는 단어가 존재하면 1
				answer = 1;
				break;
			}
		}
		return answer;
	}
}
