package 프로그래머스.Lv0;

public class rny_string {
	public static void main(String[] args) {
		String rny_string = "masterpiece";
		System.out.println(solution(rny_string));
	}

	static public String solution(String rny_string) {
		String answer = rny_string.replaceAll("m", "rn");
		return answer;
	}
}
