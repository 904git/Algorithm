package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 캐시 {
	public static void main(String[] args) {
		int cacheSize = 2;
		String[] cities = { "Jeju", "Pangyo", "NewYork", "newyork" };
		System.out.println(solution(cacheSize, cities));
	}

	static public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		HashSet<String> cache = new HashSet<>(); // 캐시
		List<String> cityList = new ArrayList<>(); // 삭제해야할 캐시 관리용 리스트
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toLowerCase(); // 도시 소문자로 통일
			if (cache.contains(city)) { // cache hit
				answer += 1;
				// 최근에 사용되었으니 위치 이동
				cityList.remove(city);
				cityList.add(city);
			} else { // cache miss
				answer += 5;
				// 캐시에 저장
				cityList.add(city);
				cache.add(city);
				if (cacheSize < cityList.size()) { // 캐시 크기가 초과하면 사용한지 오래된 것 삭제
					String removeCache = cityList.remove(0);
					cache.remove(removeCache);
				}
			}
		}
		return answer;
	}
}
