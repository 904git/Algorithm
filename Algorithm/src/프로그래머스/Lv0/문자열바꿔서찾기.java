package 프로그래머스.Lv0;

public class 문자열바꿔서찾기 {
	public static void main(String[] args) {
		String myString = "ABBAA";
		String pat = "AABB";
		System.out.println(solution(myString, pat));
	}

	static public int solution(String myString, String pat) {
		int answer = 0;
		String[] str_split = myString.split("");
		for (int i = 0; i < str_split.length; i++) { // A를 B로, B를 A로 변환
			if (str_split[i].equals("A")) {
				str_split[i] = "B";
			} else {
				str_split[i] = "A";
			}
		}
		myString = String.join("", str_split);
		if (myString.contains(pat)) { // 변환한 myString에 pat이 존재하는지 확인
			answer = 1;
		}
		return answer;
	}
}
