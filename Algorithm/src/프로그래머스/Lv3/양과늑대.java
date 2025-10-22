package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 양과늑대 {
	public static void main(String[] args) {
		int[] info = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 };
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 8 }, { 4, 9 },
				{ 9, 10 }, { 10, 11 }, { 8, 12 }, { 12, 13 }, { 13, 14 }, { 14, 15 }, { 15, 16 } };
		System.out.println(solution(info, edges));
	}

	static public int solution(int[] info, int[][] edges) {
		int answer = 1; // 루트는 항상 양이므로
		Tree tree = new Tree(info[0]); // 양과 늑대 트리
		Arrays.sort(edges, new MySort()); // 연결 정보 오름차순
		for (int i = 0; i < edges.length; i++) {
			tree.addChild(edges[i][0], edges[i][1], info[edges[i][1]]); // 트리 연결
		}
		boolean[] visit = new boolean[info.length];
		Queue<Node> queue = new LinkedList<>();
		visit[0] = true;
		queue.add(tree.root);
		int totalWolf = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Node n = queue.poll();
				if (n.num != 0 && n.value == 0) {
					int wolf = countWolf(n.parent, 0, visit); // 추가되는 늑대 수
					if (totalWolf + wolf < answer) { // 현재 양이 있는 위치까지 가는데 얻을 수 있는 늑대와 양의 수
						// 양의 수가 더 많으면 추가
						System.out.println(n.num + " " + answer + " " + (totalWolf + wolf));
						answer += 1;
						totalWolf += wolf;
						visit[n.num] = true;
					}
				}
				if (n.leftChild != null) {
					queue.add(n.leftChild);
				}
				if (n.rightChild != null) {
					queue.add(n.rightChild);
				}
			}
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 배열 오름차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}

	static class Tree { // 트리
		Node root;

		Tree(int value) {
			this.root = new Node(null, 0, value, 0, null, null);
		}

		public Node findNode(Node now, int num) { // 노드 찾기
			if (now.num == num) {
				return now;
			}
			Node result = null;
			if (result == null && now.leftChild != null) {
				result = findNode(now.leftChild, num);
			}
			if (result == null && now.rightChild != null) {
				result = findNode(now.rightChild, num);
			}
			return result;
		}

		public boolean addChild(int parent, int num, int value) { // 자식 추가
			Node p = findNode(this.root, parent);
			boolean result = false;
			if (p.leftChild == null) {
				p.leftChild = new Node(p, num, value, p.depth + 1, null, null);
			} else if (p.rightChild == null) {
				p.rightChild = new Node(p, num, value, p.depth + 1, null, null);
			} else {
				result = false;
			}
			return result;
		}
	}

	static public int countWolf(Node now, int cnt, boolean[] visit) { // 루트에서 현재 위치까지 오는데 있는 늑대 수
		if (now == null || visit[now.num]) {
			return cnt;
		}
		visit[now.num] = true;
		return countWolf(now.parent, cnt + now.value, visit);
	}

	static class Node { // 노드
		Node parent; // 부모 정보
		int num, value, depth; // 번호, 동물 정보, 깊이
		Node leftChild, rightChild; // 자식 정보

		Node(Node parent, int num, int value, int depth, Node leftChild, Node rightChild) {
			this.parent = parent;
			this.num = num;
			this.value = value;
			this.depth = depth;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

	static public void printTree(Node n) {
		if (n == null) {
			return;
		}
		printTree(n.leftChild);
		printTree(n.rightChild);
		System.out.print("(" + n.num + ", " + n.value + ") ");
	}
}
