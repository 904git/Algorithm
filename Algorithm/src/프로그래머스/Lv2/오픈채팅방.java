package 프로그래머스.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 오픈채팅방 {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	static public String[] solution(String[] record) {
		HashMap<String, String> users = new HashMap<>(); // {유저 아이디 : 유저 닉네임}
		List<String[]> chatting = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			String[] str_split = record[i].split(" ");
			if (str_split[0].equals("Enter")) { // 입장
				if (users.containsKey(str_split[1])) {
					users.replace(str_split[1], str_split[2]);
				} else {
					users.put(str_split[1], str_split[2]);
				}
				chatting.add(new String[] { str_split[1], "님이 들어왔습니다." });
			} else if (str_split[0].equals("Change")) { // 이름 변경
				users.replace(str_split[1], str_split[2]);
			} else { // 퇴장
				chatting.add(new String[] { str_split[1], "님이 나갔습니다." });
			}
		}
		String[] answer = new String[chatting.size()];
		for (int i = 0; i < chatting.size(); i++) {
			String[] chat = chatting.get(i);
			answer[i] = users.get(chat[0]) + chat[1];
		}
		return answer;
	}
}
