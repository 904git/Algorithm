package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 3, 5 } };
		System.out.println(solution(jobs));
	}

	static public int solution(int[][] jobs) {
		int answer = 0;
		Arrays.sort(jobs, new MyJobSort());
		PriorityQueue<Disk> disk_pq = new PriorityQueue<>(new MyDiskSort()); // 대기 큐
		int time = 0;
		for (int i = 0; i < jobs.length;) {
			if (disk_pq.isEmpty()) { // 큐가 비어있으면
				time = Math.max(time, jobs[i][0]); // 다음 작업 요청 시각으로 이동
			}

			while (i < jobs.length && jobs[i][0] <= time) { // 현재 시간보다 요청 시각이 빠른 작업은 모두 대기큐에 저장
				disk_pq.add(new Disk(i, jobs[i][0], jobs[i][1]));
				i += 1;
			}

			Disk d = disk_pq.poll();
			time += d.work; // 수행 시간
			answer += time - d.request_time; // 반환 시간
		}
		while (!disk_pq.isEmpty()) { // 남은 작업 수행
			Disk d = disk_pq.poll();
			time += d.work;
			answer += time - d.request_time;
		}
		answer /= jobs.length; // 반환 시간 평균
		return answer;
	}

	static class MyJobSort implements Comparator<int[]> { // 작업 요청 시각 오른차순

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[0] - o2[0];
		}

	}

	static class MyJobSort2 implements Comparator<Disk> { // 작업 요청 시각 오른차순

		@Override
		public int compare(Disk o1, Disk o2) {
			// TODO Auto-generated method stub
			return o1.request_time - o2.request_time;
		}

	}

	static class MyDiskSort implements Comparator<Disk> { // 디스크 처리 우선순위

		@Override
		public int compare(Disk o1, Disk o2) {
			// TODO Auto-generated method stub
			if (o1.work == o2.work) {
				if (o1.request_time == o2.request_time) {
					return o1.num - o2.num; // 작업 번호가 작은 것(3)
				}
				return o1.request_time - o2.request_time; // 요청 시각이 빠른 것(2)
			}
			return o1.work - o2.work; // 작업 시간이 짧은 것(1)
		}

	}

	static class Disk { // 디스크 클래스
		int num, request_time, work; // 작업 번호, 요청 시각, 작업 시간

		Disk(int num, int request_time, int work) {
			this.num = num;
			this.work = work;
			this.request_time = request_time;
		}
	}
}
