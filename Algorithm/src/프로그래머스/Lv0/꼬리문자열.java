package 프로그래머스.Lv0;

public class 꼬리문자열 {
	public static void main(String[] args) {
		String[] str_list = { "abc", "def", "ghi" };
		String ex = "ef";
		System.out.println(solution(str_list, ex));
	}

	static public String solution(String[] str_list, String ex) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str_list.length; i++) {
			if (!str_list[i].contains(ex)) { // ex의 문자열을 포함하지 않는 문자열만 삽입
				sb.append(str_list[i]);
			}
		}
		answer = sb.toString();
		return answer;
	}
}
