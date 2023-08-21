package javaProject01;

import java.util.Random;

public class TennisCounter {

	Random rnd = new Random();
	int numberOfSet;
	Team team1, team2; 
	static String[] pointFormat = { "0", "15", "30", "40", "AD", "Game" };

	public TennisCounter(int numberOfSet, Team p1, Team p2) {
		super();
		this.numberOfSet = numberOfSet;
		this.team1 = p1;
		this.team2 = p2;
	}

	public void pointWinner(int p) {

//		if (p == 1) {
//			team1.point = Math.min(team1.point + 1, 5); // 최대값을 5로 제한
//			team1.pointStr = pointFormat[team1.point];
//		} else if (p == 2) {
//			team2.point = Math.min(team2.point + 1, 5); // 최대값을 5로 제한
//			team2.pointStr = pointFormat[team2.point];
//		}

		if (p == 1) {

			team1.point += 1;
			if (team1.point>4){
				team1.pointStr = "AD" + (team1.point-3);
			}else
			team1.pointStr = pointFormat[team1.point];

		} else if (p == 2) {

			team2.point += 1;
			if (team2.point>4){
				team2.pointStr = "AD" + (team2.point-3);
			}else
			team2.pointStr = pointFormat[team2.point];

		}
		// 특정 팀의 포인트 1 증가.
		// 팀을 선택하는 매개변수 p는 1 또는 2의 값을 가진다.
	}


//	public void pointWinner(int p) {
//
////		if (p == 1) {
////			team1.point = Math.min(team1.point + 1, 5); // 최대값을 5로 제한
////			team1.pointStr = pointFormat[team1.point];
////		} else if (p == 2) {
////			team2.point = Math.min(team2.point + 1, 5); // 최대값을 5로 제한
////			team2.pointStr = pointFormat[team2.point];
////		}
//
//		if (p == 1) {
//
//			team1.point += 1;
//			//team1.pointStr = pointFormat[team1.point];
//			team1.pointStr = pointFormat[1];
//		} else if (p == 2) {
//
//			team2.point += 1;
//			//team2.pointStr = pointFormat[team2.point];
//			team2.pointStr = pointFormat[1];
//		}
//		// 특정 팀의 포인트 1 증가.
//		// 팀을 선택하는 매개변수 p는 1 또는 2의 값을 가진다.
//	}

	 public void score(Team team1, Team team2, int numberOfSets) {
     int p = 0;
		 int t1 = 0;
		 int t2 = 0;
     while (team1.numberOfWonSets != (numberOfSets/2)+1 && team2.numberOfWonSets !=(numberOfSets/2)+1 ) {
         p = rnd.nextInt(2)+1;
         pointWinner(p);

         if (team1.point >= 4 && team1.point - team2.point >= 2) {
             team1.numberOfWongames++;
             team1.point=0;
             team2.point=0;
             team2.pointStr = "0";
             team1.pointStr = "0";
			 System.out.println(team1.name + "가 승리 했습니다");
         } else if (team2.point >= 4 && team2.point - team1.point >= 2){
             team2.numberOfWongames++;
             team1.point=0;
             team2.point=0;
             team2.pointStr = "0";
             team1.pointStr = "0";
			 System.out.println(team2.name + "가 승리 했습니다");
         }

         if (team1.numberOfWongames >= 6 && team1.numberOfWongames - team2.numberOfWongames >=2) {
             team1.numberOfWonSets++;
			  t1 = team1.numberOfWongames;
			  t2 = team2.numberOfWongames;
             team1.point=0;
             team2.point=0;
             team1.numberOfWongames = 0;
             team2.numberOfWongames = 0;
             team2.pointStr = "0";
             team1.pointStr = "0";
         } else if(team2.numberOfWongames >= 6 && team2.numberOfWongames - team1.numberOfWongames >=2){
             team2.numberOfWonSets++;
			  t1 = team1.numberOfWongames;
			  t2 = team2.numberOfWongames;
             team1.point=0;
             team2.point=0;
             team1.numberOfWongames = 0;
             team2.numberOfWongames = 0;
             team2.pointStr = "0";
             team1.pointStr = "0";
         }

         dispScoreBoard();
     }
	 System.out.printf("%d, %d", t1, t2);

 }



//	public void score(Team team1, Team team2, int numberOfSets) {
//		int p = 0;
//		while ( team1.numberOfWonSets != (numberOfSets/2)+1 && team2.numberOfWonSets != (numberOfSets/2)+1) {
//			p = rnd.nextInt(2)+1;
//			pointWinner(p);
//	
//			if (team1.point == 4) {
//				team1.numberOfWongames++;
//				team1.point=0;
//				team2.point=0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			} else if (team2.point == 4){
//				team2.numberOfWongames++;
//				team1.point=0;
//				team2.point=0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			}
//			
//			if (team1.numberOfWongames == 6) {
//				team1.numberOfWonSets++;
//				team1.point=0;
//				team2.point=0;
//				team1.numberOfWongames = 0;
//				team2.numberOfWongames = 0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			} else if(team2.numberOfWongames == 6){
//				team2.numberOfWonSets++;	
//				team1.point=0;
//				team2.point=0;
//				team1.numberOfWongames = 0;
//				team2.numberOfWongames = 0;
//				team2.pointStr = "0";
//				team1.pointStr = "0";
//			}
//			  
//			dispScoreBoard();
//		}
//	}
	
	public void dispScoreBoard() {
		String[][] test = new String[3][2+numberOfSet];
		// 결과 템플릿 미리 만들고 값만 넣기 vs 호출할 때 만들기
		
		
		// 현재의 스코어보드를 화면에 출력한다.
		// 객체가 있어야 스코어보드를 출력할 수 있으니, static으로 선언하지 않는다.
		System.out.println( "\n" + team1.toString()+"\n"+ team2.toString());
		
	}
}

class Team {

	String name;
	int point = 0;
	String pointStr = "0";
	int numberOfWongames = 0;
	int numberOfWonSets = 0;

	public Team(String name, int point, int numberOfWongames, int numberOfWonSets) {
		this.name = name;
		this.point = point;
		this.pointStr = TennisCounter.pointFormat[point];
		this.numberOfWongames = numberOfWongames;
		this.numberOfWonSets = numberOfWonSets;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", point=" + point + ", pointStr=" + pointStr + ", numberOfWongames="
				+ numberOfWongames + ", numberOfWonSets=" + numberOfWonSets + "]";
	}

	
}