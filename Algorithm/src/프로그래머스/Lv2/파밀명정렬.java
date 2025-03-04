package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 파밀명정렬 {
	public static void main(String[] args) {
		String[] files = { "A", "a" };
		System.out.println(Arrays.toString(solution(files)));
	}

	static public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		for (int i = 0; i < files.length; i++) { // 배열 복사
			answer[i] = files[i];
			System.out.println(Arrays.toString(filenameSplit(answer[i])));
		}
		Arrays.sort(answer, new MySort()); // 정렬
		return answer;
	}

	static public String[] filenameSplit(String name) { // 파일 이름을 HEAD, NUMBER, TAIL로 구분
		int headLastIdx = 0, numLastIdx = 0;
		for (int i = 0; i <= name.length(); i++) {
			headLastIdx = i;
			if (headLastIdx == name.length() || Character.isDigit(name.charAt(i))) { // 숫자가 처음 나올때까지 HEAD
				break;
			}
		}
		for (int i = headLastIdx; i <= name.length(); i++) {
			numLastIdx = i;
			if (numLastIdx == name.length() || !Character.isDigit(name.charAt(i))) { // 문자가 처음 나올때까지 NUMBER
				break;
			}
		}
		String[] result = new String[3]; // 문자열의 대소문자 구분이 없으니 모두 소문자로 통일
		result[0] = name.substring(0, headLastIdx).toLowerCase(); // HEAD
		result[1] = name.substring(headLastIdx, numLastIdx); // NUMBER
		result[2] = name.substring(numLastIdx, name.length()).toLowerCase(); // TAIL
		return result;
	}

	static class MySort implements Comparator<String> { // 정렬 규칙

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			String[] o1_split = filenameSplit(o1);
			String[] o2_split = filenameSplit(o2);
			if (o1_split[0].equals(o2_split[0])) { // HEAD가 같으면
				return Integer.parseInt(o1_split[1]) - Integer.parseInt(o2_split[1]); // NUMBER 오름차순
			}
			return o1_split[0].compareTo(o2_split[0]); // HEAD 오름차순
		}

	}
}
