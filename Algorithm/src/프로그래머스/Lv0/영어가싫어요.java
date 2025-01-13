package 프로그래머스.Lv0;

public class 영어가싫어요 {
	public static void main(String[] args) {
		String numbers = "onetwothreefourfivesixseveneightnine";
		System.out.println(solution(numbers));
	}

	static public long solution(String numbers) {
		long answer = 0;
		String[] number = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i < number.length; i++) {
			numbers = numbers.replaceAll(number[i], Integer.toString(i));
		}
		answer = Long.parseLong(numbers);
		return answer;
	}
}
