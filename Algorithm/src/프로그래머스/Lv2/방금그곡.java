package 프로그래머스.Lv2;

public class 방금그곡 {
	public static void main(String[] args) {
		String m = "ABC";
		String[] nusicinfos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		System.out.println(solution(m, nusicinfos));
	}

	static public String solution(String m, String[] musicinfos) {
		String answer = "(None)"; // 조건 일치하는 음악 없을 때
		String[] sharp = { "C#", "D#", "F#", "G#", "A#", "B#" }; // 반올림 음계
		int max_len = 0;
		String m_num = sharpToNum(m, sharp); // 반올림 음계 숫자로 변환
		for (int i = 0; i < musicinfos.length; i++) {
			String[] info = musicinfos[i].split(",");
			int time = timeToInt(info[1]) - timeToInt(info[0]); // 재생 시간
			String music = sharpToNum(info[3], sharp); // 반올림 음계 숫자로 변환
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < time; j++) { // 음악 재생
				sb.append(music.charAt(j % music.length()));
			}
			if (0 <= sb.toString().indexOf(m_num) && max_len < time) { // 조건에 일치하는 음악이 있으면
				answer = info[2];
				max_len = time;
			}
		}
		return answer;
	}

	static public String sharpToNum(String music, String[] sharp) { // 반올림 음계 숫자로 변환
		for (int i = 0; i < sharp.length; i++) {
			music = music.replaceAll(sharp[i], Integer.toString(i));
		}
		return music;
	}

	static public int timeToInt(String time) { // 문자열 시간 숫자로 변환
		String[] times = time.split(":");
		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
	}
}
