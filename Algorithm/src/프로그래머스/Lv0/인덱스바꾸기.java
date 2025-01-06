package 프로그래머스.Lv0;

public class 인덱스바꾸기 {
	public static void main(String[] args) {
		String my_string = "hello";
		int num1 = 1, num2 = 2;
		System.out.println(solution(my_string, num1, num2));
	}

	static public String solution(String my_string, int num1, int num2) {
		String answer = "";
		String[] str_split = my_string.split("");
		// 문자 바꾸기
		String temp = str_split[num1];
		str_split[num1] = str_split[num2];
		str_split[num2] = temp;
		answer = String.join("", str_split);
		return answer;
	}
}
