package 프로그래머스.Lv0;

public class 문자열여러번뒤집기 {
	public static void main(String[] args) {
		String my_string = "rermgorpsam";
		int[][] queries = { { 2, 3 }, { 0, 7 }, { 5, 9 }, { 6, 10 } };
		System.out.println(solution(my_string, queries));
	}

	static public String solution(String my_string, int[][] queries) {
		String answer = "";
		StringBuffer sb = new StringBuffer(my_string);
		for (int i = 0; i < queries.length; i++) {
			StringBuffer reverse = new StringBuffer(sb.substring(queries[i][0], queries[i][1] + 1)); // 뒤집을 문자열
			reverse.reverse(); // 문자열 뒤집기
			sb.replace(queries[i][0], queries[i][1] + 1, reverse.toString()); // 뒤집은 문자열로 변경
		}
		answer = sb.toString();
		return answer;
	}
}
