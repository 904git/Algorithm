package 프로그래머스.Lv0;

public class 가위바위보 {
	public static void main(String[] args) {
		String rsp = "2";
		System.out.println(solution(rsp));
	}

	static public String solution(String rsp) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		String[] rsp_split = rsp.split("");
		for (int i = 0; i < rsp_split.length; i++) {
			if (rsp_split[i].equals("2")) {// 가위를 냄
				sb.append("0");
			} else if (rsp_split[i].equals("0")) {// 바위를 냄
				sb.append("5");
			} else {// 보를 냄
				sb.append("2");
			}
		}
		answer = sb.toString();
		return answer;
	}

}
