package 프로그래머스.Lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 주차요금계산 {
	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		System.out.println(Arrays.toString(solution(fees, records)));
	}

	static public int[] solution(int[] fees, String[] records) {
		HashMap<Integer, Integer> parking = new HashMap<>(); // 입차 기록
		HashMap<Integer, Integer> cars = new HashMap<>(); // 차량별 사용 시간
		for (int i = 0; i < records.length; i++) {
			String[] str_split = records[i].split(" ");
			int carNum = Integer.parseInt(str_split[1]);
			if (str_split[2].equals("IN")) { // 입차
				parking.put(carNum, timeToInt(str_split[0]));
			} else { // 출차
				int start = parking.remove(carNum); // 해당 차량의 입차시간
				int end = timeToInt(str_split[0]); // 출차 시간
				if (cars.containsKey(carNum)) { // 이전에 주차했던 기록이 있으면
					cars.replace(carNum, cars.get(carNum) + (end - start)); // 사용시간 추가
				} else { // 처음 주차
					cars.put(carNum, (end - start)); // 새로 등록
				}
			}
		}
		for (Integer car : parking.keySet()) { // 출차 기록이 없는 차량들
			int start = parking.get(car);
			int end = timeToInt("23:59"); // 23:59분에 출차한 것으로 간주
			if (cars.containsKey(car)) {
				cars.replace(car, cars.get(car) + (end - start));
			} else {
				cars.put(car, (end - start));
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new MySort()); // 차량번호 오름차순 정렬
		for (Integer car : cars.keySet()) {
			int fee = fees[1]; // 기본 요금
			if (fees[0] < cars.get(car)) { // 기본 시간 초과로 사용 시
				int use = (cars.get(car) - fees[0]) % fees[2] != 0 ? (cars.get(car) - fees[0]) / fees[2] + 1
						: (cars.get(car) - fees[0]) / fees[2]; // 사용량 계산 [(사용 시간 - 기본요금) / 사용 단위] 나누어 떨어지지 않으면 1 추가
				fee += use * fees[3]; // 금액 계산
			}
			pq.add(new int[] { car, fee });
		}
		int[] answer = new int[pq.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = pq.poll()[1];
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 오름차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}

	static public int timeToInt(String time) { // 문자열 시각을 분으로 변경 "01:30" -> 90
		int result = 0;
		String[] str_split = time.split(":");
		result = Integer.parseInt(str_split[0]) * 60 + Integer.parseInt(str_split[1]);
		return result;
	}
}
