package 프로그래머스.Lv0;

public class 배열비교하기 {
	public static void main(String[] args) {
		int[] arr1 = { 49, 13 }, arr2 = { 70, 11, 2 };
		System.out.println(solution(arr1, arr2));
	}

	static public int solution(int[] arr1, int[] arr2) {
		int answer = 0;
		if (arr1.length < arr2.length) { // arr2 길이가 더 크면 -1
			answer = -1;
		} else if (arr2.length < arr1.length) { // arr1 길이가 더 크면 1
			answer = 1;
		} else {
			int sum1 = sumArray(arr1); // arr1 원소 합
			int sum2 = sumArray(arr2); // arr2 원소 합
			if (sum1 < sum2) { // arr2 원소 합이 더 크면 -1
				answer = -1;
			} else if (sum2 < sum1) { // arr1 원소 합이 더 크면 1
				answer = 1;
			}
		}
		return answer;
	}

	// 배열의 원소 합
	static public int sumArray(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
}
