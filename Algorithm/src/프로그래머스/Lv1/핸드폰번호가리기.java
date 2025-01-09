package 프로그래머스.Lv1;

public class 핸드폰번호가리기 {
	public static void main(String[] args) {
		String phone_number = "01033334444";
		System.out.println(solution(phone_number));
	}

	static public String solution(String phone_number) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < phone_number.length() - 4; i++) { // 뒷자리 4개 제외한 문자의 수만큼 * 추가
			sb.append("*");
		}
		sb.append(phone_number.substring(phone_number.length() - 4)); // 뒷자리 4개 추가
		answer = sb.toString();
		return answer;
	}
}
