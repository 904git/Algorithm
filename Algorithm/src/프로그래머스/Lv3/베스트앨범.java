package 프로그래머스.Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class 베스트앨범 {
	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		System.out.println(Arrays.toString(solution(genres, plays)));
	}

	static public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		List<String> genre_list = new ArrayList<>(); // 장르 종류
		List<int[]> genre_cnt = new ArrayList<>(); // 장르별 재생 수
		HashMap<String, List<int[]>> rank = new HashMap<>(); // 장르별 앨범 순위
		for (int i = 0, idx = 0; i < genres.length; i++) {
			if (!genre_list.contains(genres[i])) { // 처음 보는 장르이면
				genre_list.add(genres[i]); // 장르 추가
				genre_cnt.add(new int[] { idx++, plays[i] }); // 재생수 추가
				rank.put(genres[i], new ArrayList<int[]>()); // 앨범 순위 초기화
			} else { // 이미 있는 장르이면
				int[] cnt = genre_cnt.get(genre_list.indexOf(genres[i]));
				genre_cnt.remove(cnt[0]);
				genre_cnt.add(cnt[0], new int[] { cnt[0], cnt[1] + plays[i] }); // 장르별 재생수 갱신
			}
			rank.get(genres[i]).add(new int[] { i, plays[i] }); // 앨범 순위 추가
		}
		genre_cnt.sort(new MySort()); // 재생수 내림차순 정렬
		List<Integer> best = new ArrayList<>(); // 베스트앨범 선정
		for (int i = 0; i < genre_cnt.size(); i++) {
			String genre = genre_list.get(genre_cnt.get(i)[0]); // 많이 들은 장르
			List<int[]> albums = rank.get(genre); // 해당 장르에 포함된 앨범들
			albums.sort(new MySort()); // 재생수 내림차순 정렬
			for (int j = 0; j < Math.min(2, albums.size()); j++) { // 상위 2개만 선정 (1개만 있는 경우는 한곡만)
				best.add(albums.get(j)[0]);
			}
		}
		answer = new int[best.size()];
		for (int i = 0; i < best.size(); i++) {
			answer[i] = best.get(i);
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 재생수 내림차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o2[1] - o1[1];
		}

	}
}
