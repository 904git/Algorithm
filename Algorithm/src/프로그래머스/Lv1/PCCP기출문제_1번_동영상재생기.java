package 프로그래머스.Lv1;

public class PCCP기출문제_1번_동영상재생기 {
	public static void main(String[] args) {
		String video_len = "10:55", pos = "00:05", op_start = "00:15", op_en = "06:55";
		String[] commands = { "prev", "next", "next" };
		System.out.println(solution(video_len, pos, op_start, op_en, commands));
	}

	static public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		String answer = "";
		int total_len = timeToInt(video_len);
		int now = timeToInt(pos);
		int op_s = timeToInt(op_start), op_e = timeToInt(op_end);
		for (int i = 0; i < commands.length; i++) {
			if (op_s <= now && now <= op_e) { // 현재 구간이 오프닝 구간이면 오프닝 끝으로 이동
				now = op_e;
			}
			
			if (commands[i].equals("prev")) { // 10초 전으로 이동
				now = Math.max(0, now - 10);
			} else { // 10초 후로 이동
				now = Math.min(total_len, now + 10);
			}
		}
		if (op_s <= now && now <= op_e) { // 현재 구간이 오프닝 구간이면 오프닝 끝으로 이동
			now = op_e;
		}
		answer = String.format("%02d:%02d", now / 60, now % 60);
		return answer;
	}

	static int timeToInt(String time) { // 문자열 시간을 숫자로 변환
		String[] str_split = time.split(":");
		return Integer.parseInt(str_split[0]) * 60 + Integer.parseInt(str_split[1]);
	}
}
