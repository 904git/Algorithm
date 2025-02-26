package 프로그래머스.Lv1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임 {
	public static void main(String[] args) {
		String dartResult = "1D2S3T*";
		System.out.println(solution(dartResult));
	}

	static public int solution(String dartResult) {
		int answer = 0;
		String[] num = dartResult.split("[SDT][*#]?");
		String[] order = dartResult.split("[0-9]+");
		int[] score = new int[3];
		// 3세트 점수 계산
		for (int i = 0; i < num.length; i++) {
			score[i] = Integer.parseInt(num[i]);
			if (order[i + 1].charAt(0) == 'D') { // 더블
				score[i] = score[i] * score[i];
			} else if (order[i + 1].charAt(0) == 'T') { // 트리플
				score[i] = score[i] * score[i] * score[i];
			}

			if (1 < order[i + 1].length()) {
				if (order[i + 1].charAt(1) == '*') { // 스타상
					score[i] *= 2; // 점수 2배
					if (0 < i) { // 직전 점수도 2배
						score[i - 1] *= 2;
					}
				} else { // 아차상
					score[i] *= -1; // 점수 마이너스
				}
			}
		}
		for (int i = 0; i < num.length; i++) { // 점수 합산
			answer += score[i];
		}
		return answer;
	}

	static public int solution2(String dartResult) {
		int answer = 0;
		// 문자열에서 숫자 추출
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(dartResult);
		int[] num = new int[3];
		for (int i = 0; i < num.length; i++) {
			if (m.find()) {
				num[i] = Integer.parseInt(m.group());
			}
		}
		// 문자열에서 문자 추출
		p = Pattern.compile("[SDT][*#]?");
		m = p.matcher(dartResult);
		String[] order = new String[3];
		for (int i = 0; i < num.length; i++) {
			if (m.find()) {
				order[i] = m.group();
			}
		}
		// 3세트 점수 계산
		for (int i = 0; i < order.length; i++) {
			if (order[i].charAt(0) == 'D') { // 더블
				num[i] = num[i] * num[i];
			} else if (order[i].charAt(0) == 'T') { // 트리플
				num[i] = num[i] * num[i] * num[i];
			}

			if (1 < order[i].length()) {
				if (order[i].charAt(1) == '*') { // 스타상
					num[i] *= 2; // 점수 2배
					if (0 < i) { // 직전 점수도 2배
						num[i - 1] *= 2;
					}
				} else { // 아차상
					num[i] *= -1; // 점수 마이너스
				}
			}
		}
		for (int i = 0; i < num.length; i++) { // 점수 합산
			answer += num[i];
		}
		return answer;
	}
}
