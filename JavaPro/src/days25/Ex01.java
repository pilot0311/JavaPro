package days25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Ex01 {
//팀원 이름 일어와서 출력 HashMap + ArraysList		멤버 VO클래스 만들어서
	public static void main(String[] args) {
		String fileName = ".\\src\\days19\\1. Java 팀 구성.txt";
		String line = null;
		ArrayList<MemberVO> teamList = null;
		HashMap<String, ArrayList<MemberVO>> teamGroup = new HashMap<>();
		String teamName;
		String[] tNames = null;
		MemberVO memberVO = null;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((line = br.readLine()) != null) {
				teamName = line;
				line = br.readLine();
				tNames = line.split("\\s*,\\s*");
				teamList = new ArrayList<MemberVO>();
				for (String names : tNames) {
					if (names.contains("(팀장)")) {
						names=names.replaceAll("(팀장)", "");
						 memberVO = new MemberVO(names, "팀장");
					} else {
						 memberVO = new MemberVO(names, "팀원");
					} //else
					teamList.add(memberVO);
				} //foreach
				teamGroup.put(teamName, teamList);
			}
			
			disp(teamGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

	private static void disp(HashMap<String, ArrayList<MemberVO>> teamGroup) {
		Iterator<Entry<String, ArrayList<MemberVO>>> ir = teamGroup.entrySet().iterator();
		ArrayList<MemberVO> teamList = null;
		while (ir.hasNext()) {
			Entry<String, ArrayList<MemberVO>> entry =  ir.next();
			String key = entry.getKey();
			teamList = entry.getValue();
			int count = teamList.size();
			MemberVO teamLeader = teamList.get(0);
			System.out.printf("[%s(%d명):%s]\n",key,count,teamLeader);
		}
		
	}
}
