package 프로그래머스.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PCCE기출문제_10번_데이터분석 {
	public static void main(String[] args) {
		int[][] data = { { 1, 20300104, 100, 80 }, { 2, 20300804, 847, 37 }, { 3, 20300401, 10, 8 } };
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";
		int[][] result = solution(data, ext, val_ext, sort_by);
		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}

	static public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		int[][] answer = {};
		List<int[]> list = new ArrayList<>(); // 뽑은 데이터 저장할 리스트
		for (int i = 0; i < data.length; i++) {
			if (underExt(data[i], ext, val_ext)) { // ext이 val_ext보다 작으면
				list.add(data[i]); // 리스트에 추가
			}
		}
		list.sort(new MySort(sort_by)); // sort_by 기준 정렬
		answer = new int[list.size()][4];
		for (int i = 0; i < list.size(); i++) { // 데이터 저장
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static boolean underExt(int[] data, String ext, int val_ext) { // data에서 ext값이 val_ext보다 작은 값인지 확인
		if (ext.equals("code")) {
			return data[0] <= val_ext;
		} else if (ext.equals("date")) {
			return data[1] <= val_ext;
		} else if (ext.equals("maximum")) {
			return data[2] <= val_ext;
		}
		return data[3] <= val_ext; // remain
	}

	static class MySort implements Comparator<int[]> { // sort_by 기준으로 오름차순 정렬
		static String sort_by;

		MySort(String sort_by) {
			this.sort_by = sort_by;
		}

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (sort_by.equals("code")) {
				return o1[0] - o2[0];
			} else if (sort_by.equals("date")) {
				return o1[1] - o2[1];
			} else if (sort_by.equals("maximum")) {
				return o1[2] - o2[2];
			}
			return o1[3] - o2[3]; // remain
		}

	}
}
