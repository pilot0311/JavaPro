package javaProject01;

import java.util.Scanner;

public class TennisGame {

	public static void main(String[] args) {

		System.out.println(">");
		Scanner sc = new Scanner(System.in);
		System.out.println("> 세트 수 입력 : ");
		int numberOfSets = Integer.parseInt(sc.nextLine());
		System.out.println("> 단식(1) / 복식(2) 입력 : ");
		int numberOfTeamMember = Integer.parseInt(sc.nextLine());
		String name;
		Team p1, p2;
		TennisCounter tennis = null;
		switch (numberOfTeamMember){
			case(1):
				System.out.println("1번 선수 이름: ");
				name = sc.nextLine();
				 p1 = new Team(name, 0, 0, 0);
				System.out.println(p1);

				System.out.println("2번 선수 이름: ");
				name = sc.nextLine();
				 p2 = new Team(name, p1.point, p1.numberOfWongames, p1.numberOfWonSets);
				System.out.println(p2);
				 tennis = new TennisCounter(numberOfSets, p1, p2);
				tennis.score(p1, p2, numberOfSets);
				tennis.dispScoreBoard();
			break;

			case (2):
				System.out.println("1팀 1번 선수 이름: ");
				name = sc.nextLine();
				System.out.println("1팀 2번 선수 이름: ");
				name = name + "/" + sc.nextLine();
				 p1 = new Team(name, 0, 0, 0);
				System.out.println(p1);

				System.out.println("2팀 1번 선수 이름: ");
				name = sc.nextLine();

				System.out.println("2팀 2번 선수 이름: ");
				name = name + "/" + sc.nextLine();
				 p2 = new Team(name, p1.point, p1.numberOfWongames, p1.numberOfWonSets);
				System.out.println(p2);
				 tennis = new TennisCounter(numberOfSets, p1, p2);
				tennis.score(p1, p2, numberOfSets);
				tennis.dispScoreBoard();
			break;
		}

	




		

	}

}
