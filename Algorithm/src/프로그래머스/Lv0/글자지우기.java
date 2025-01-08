package 프로그래머스.Lv0;

public class 글자지우기 {
	public static void main(String[] args) {
		String my_string = "apporoograpemmemprs";
		int[] indices = { 1, 16, 6, 15, 0, 10, 11, 3 };
		System.out.println(solution(my_string, indices));
	}

	static public String solution(String my_string, int[] indices) {
		String answer = "";
		String[] str_split = my_string.split("");
		for (int i = 0; i < indices.length; i++) {
			str_split[indices[i]] = ""; // indices[i] 인덱스의 문자를 빈 문자열로 변환
		}
		answer = String.join("", str_split);
		return answer;
	}
}
