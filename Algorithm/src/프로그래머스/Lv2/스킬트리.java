package 프로그래머스.Lv2;

import java.util.HashMap;

public class 스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		System.out.println(solution(skill, skill_trees));
	}

	static public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			boolean isPossible = true;
			boolean[] skill_master = new boolean[skill.length()];
			for (int j = 0; j < skill_trees[i].length(); j++) {
				char s = skill_trees[i].charAt(j);
				int idx = skill.indexOf(s);
				if (0 <= idx) { // 선행 스킬이 있는 스킬
					if (0 != idx && !skill_master[idx - 1]) { // 선행스킬 안 배움
						isPossible = false;
						break;
					}
					skill_master[idx] = true; // 스킬 배우기
				}
			}
			if (isPossible) { // 스킬트리 가능
				answer += 1;
			}
		}
		return answer;
	}

	static public int solution2(String skill, String[] skill_trees) {
		int answer = 0;
		HashMap<Character, Integer> hashMap = new HashMap<>(); // 배우는데 순서가 필요한 스킬들
		for (int i = 0; i < skill.length(); i++) {
			hashMap.put(skill.charAt(i), i);
		}
		for (int i = 0; i < skill_trees.length; i++) {
			boolean isPossible = true;
			boolean[] skill_master = new boolean[skill.length()];
			for (int j = 0; j < skill_trees[i].length(); j++) {
				char s = skill_trees[i].charAt(j);
				if (hashMap.containsKey(s)) { // 선행 스킬이 있는 스킬
					if (0 != hashMap.get(s) && !skill_master[hashMap.get(s) - 1]) { // 선행스킬 안 배움
						isPossible = false;
						break;
					}
					skill_master[hashMap.get(s)] = true; // 스킬 배우기
				}
			}
			if (isPossible) { // 스킬트리 가능
				answer += 1;
			}
		}
		return answer;
	}
}
