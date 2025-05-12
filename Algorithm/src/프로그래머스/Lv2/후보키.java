package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 후보키 {
	static List<Integer> key;
	static HashSet<List<Integer>> hash;

	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		System.out.println(solution(relation));
	}

	static public int solution(String[][] relation) {
		int answer = 0;
		key = new ArrayList<>(); // 후보키 후보
		hash = new HashSet<>(); // 유일성과 최소성을 만족하는 후보키
		for (int i = 1; i <= relation[0].length; i++) { // 속성 개수를 늘려가며 후보키 찾기
			comb(i, 0, 0, relation);
		}
		answer = hash.size();
		return answer;
	}

	static public void comb(int n, int cur, int cnt, String[][] relation) { // 속성 집합 만들기
		if (n == cnt) {
			// 유일성 확인
			HashSet<String> tuple = new HashSet<>();
			boolean flag = true;
			for (int i = 0; i < relation.length; i++) {
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < key.size(); j++) {
					sb.append(relation[i][key.get(j)]);
				}
				if (tuple.contains(sb.toString())) { // 현재 속성 집합으로 튜플을 식별하지 못함
					flag = false;
					break;
				}
				tuple.add(sb.toString());
			}
			if (flag) { // 유일성과 최소성을 만족하는 속성 집합(후보키)
				hash.add(new ArrayList<>(key));
			}
			return;
		}

		for (int i = cur; i < relation[0].length; i++) {
			key.add(i);
			if (minimality()) { // 최소성 확인
				comb(n, i + 1, cnt + 1, relation);
			}
			key.remove(cnt);
		}
	}

	static public boolean minimality() { // 최소성 확인
		for (List<Integer> k : hash) {
			if (key.containsAll(k)) { // 현재 속성 조합에 후보키가 포함되어 있으면 최소성을 만족하지 못함
				return false;
			}
		}
		return true;
	}
}
