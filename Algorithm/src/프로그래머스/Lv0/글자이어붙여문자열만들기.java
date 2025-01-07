package 프로그래머스.Lv0;

public class 글자이어붙여문자열만들기 {
	public static void main(String[] args) {
		String my_string = "cvsgiorszzzmrpaqpe";
		int[] index_list = { 16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7 };
		System.out.println(solution(my_string, index_list));
	}

	static public String solution(String my_string, int[] index_list) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < index_list.length; i++) {
			sb.append(my_string.charAt(index_list[i]));
		}
		answer = sb.toString();
		return answer;
	}
}
