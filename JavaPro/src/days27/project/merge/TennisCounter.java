package days27.project.merge;

import java.io.File;
import java.io.FileWriter;

public class TennisCounter {

	int numberOfSet;
	Team team1, team2;
	static String[] pointFormat = { "0", "15", "30", "40", "Game", "", "Ad", "Game" };
	int[][] gameScores;
	int currentSet = 0;
	boolean thisSetIsDuece = false;
	String winner = "";

	public TennisCounter(int numberOfSet, Team p1, Team p2) {
		super();
		this.numberOfSet = numberOfSet;
		this.team1 = p1;
		this.team2 = p2;
		this.gameScores = new int[numberOfSet][2];
	}

	public void pointWinner(int p) {
		if (p == 1) {
			team1.point += 1;
			team1.pointStr = pointFormat[team1.point];
		} else if (p == 2) {
			team2.point += 1;
			team2.pointStr = pointFormat[team2.point];
		}
		// 특정 팀의 포인트 1 증가.
		// 팀을 선택하는 매개변수 p는 1 또는 2의 값을 가진다.
	}

	public void dispScoreBoard() {
	      Object[][] printFormat = new Object[3][];
	      if (numberOfSet == 3) {
	         printFormat[0] = new String[] {team1.name.contains("/")?"────────":"───", "Point", "Set1", "Set2", "Set3", "Match" };
	         printFormat[0][currentSet + 2] += "*";
	         printFormat[1] = new Object[] { team1.name, team1.pointStr, gameScores[0][0], gameScores[1][0],
	               gameScores[2][0], (team1.name.equals(winner) ? "WIN" : "") };
	         printFormat[2] = new Object[] { team2.name, team2.pointStr, gameScores[0][1], gameScores[1][1],
	               gameScores[2][1], (team2.name.equals(winner) ? "WIN" : "") };

	      } else if (numberOfSet == 5) {
	         printFormat[0] = new String[] {team1.name.contains("/")?"────────":"───", " Point ", " Set1 ", " Set2 ", " Set3 ", " Set4 ", " Set5 ", "Match " };
	         printFormat[0][currentSet + 2] += "*";
	         printFormat[1] = new Object[] { team1.name, team1.pointStr, gameScores[0][0], gameScores[1][0],
	               gameScores[2][0], gameScores[3][0], gameScores[4][0], (team1.name.equals(winner) ? "WIN" : "") };
	         printFormat[2] = new Object[] { team2.name, team2.pointStr, gameScores[0][1], gameScores[1][1],
	               gameScores[2][1], gameScores[3][1], gameScores[4][1], (team2.name.equals(winner) ? "WIN" : "") };
	      }

	      System.out.println();

	      System.out.println("─".repeat(65));
	      for (int i = 0; i < printFormat.length; i++) {
	         for (int j = 0; j < printFormat[i].length; j++) {
	            String s = String.valueOf(printFormat[i][j]);
	            System.out.printf("%5s\t│%s",s,(j == printFormat[i].length - 1 ? "\n" : ""));
	            //System.out.print(printFormat[i][j] + "\t│" + (j == printFormat[i].length - 1 ? "\n" : ""));
	         }
	         System.out.println("─".repeat(65));
	      }
	      if (thisSetIsDuece) {
	         System.out.printf("현재 Set %d는 게임스코어 듀스 진행 중입니다.\n\n", currentSet + 1);
	      }
	      // 결과 템플릿 미리 만들고 값만 넣기 vs 호출할 때 만들기

	      // 현재의 스코어보드를 화면에 출력한다.
	      // 객체가 있어야 스코어보드를 출력할 수 있으니, static으로 선언하지 않는다.
//	      System.out.println(numberOfSet + ", " + team1.toString() + ", " + team2.toString());

	   }

	public void fileWrite() {
		String pathname = ".\\src\\days27\\project\\merge\\gameInfo.txt";
		File file = new File(pathname);
		Object[][] printFormat = new Object[3][];
		
		try(FileWriter fw = new FileWriter(file, false)) {
			if (numberOfSet == 3) {
				printFormat[0] = new String[] {team1.name.contains("/")?"────────":"───", "Point", "Set1", "Set2", "Set3", "Match" };
				printFormat[0][currentSet + 2] += "*";
				printFormat[1] = new Object[] { team1.name, team1.pointStr, gameScores[0][0], gameScores[1][0],
						gameScores[2][0], (team1.name.equals(winner) ? "WIN" : "") };
				printFormat[2] = new Object[] { team2.name, team2.pointStr, gameScores[0][1], gameScores[1][1],
						gameScores[2][1], (team2.name.equals(winner) ? "WIN" : "") };

			} else if (numberOfSet == 5) {
				printFormat[0] = new String[] {team1.name.contains("/")?"────────":"───", " Point ", " Set1 ", " Set2 ", " Set3 ", " Set4 ", " Set5 ", "Match " };
				printFormat[0][currentSet + 2] += "*";
				printFormat[1] = new Object[] { team1.name, team1.pointStr, gameScores[0][0], gameScores[1][0],
						gameScores[2][0], gameScores[3][0], gameScores[4][0], (team1.name.equals(winner) ? "WIN" : "") };
				printFormat[2] = new Object[] { team2.name, team2.pointStr, gameScores[0][1], gameScores[1][1],
						gameScores[2][1], gameScores[3][1], gameScores[4][1], (team2.name.equals(winner) ? "WIN" : "") };
			}
			fw.append("─".repeat(65)).append("\n");
			for (int i = 0; i < printFormat.length; i++) {
				for (int j = 0; j < printFormat[i].length; j++) {
					String s = String.valueOf(printFormat[i][j]);
					String data = String.format("%5s\t│%s",s,(j == printFormat[i].length - 1 ? "\n" : ""));
					fw.append(data);
				}
				fw.append("─".repeat(65)).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("저장 실패");
		}
		
	}
	
	
	public void duecePointWinner(int p) {
		if (p == 1) {
			team1.pointsOfDuece += 1;
			team1.pointStr = pointFormat[team1.pointsOfDuece];
		} else if (p == 2) {
			team2.pointsOfDuece += 1;
			team2.pointStr = pointFormat[team2.pointsOfDuece];
		}

	}

	public void calcPoint() {
		// 포인트 계산
//		boolean GameIsEnd = false;
		if (team1.point == 3 && team2.point == 3) {
			this.dispScoreBoard(); // 포인트 4040 보여주기
			boolean pointDueceIsEnd = false;
			int p;

			while (!pointDueceIsEnd) {
				System.out.println("************************ Deuce ************************ ");
				team1.resetPointsOfDeuce();
				team2.resetPointsOfDeuce();
				this.dispScoreBoard(); // 포인트 초기화

				p = (int) (Math.random() * 2 + 1);
				this.duecePointWinner(p);
				this.dispScoreBoard(); // ad 표시

				p = (int) (Math.random() * 2 + 1);
				this.duecePointWinner(p);
				this.dispScoreBoard(); // ad 표시
				if (Math.abs(team1.pointsOfDuece - team2.pointsOfDuece) == 2) {
					if (team1.pointsOfDuece > team2.pointsOfDuece) {
						team1.numberOfWonGames++;
					} else {
						team2.numberOfWonGames++;
					}
					team1.resetPoints();
					team2.resetPoints();
					pointDueceIsEnd = true;
				}
			}
		} else if (team1.point == 4 || team2.point == 4) {
			if (team1.point == 4) {
				team1.numberOfWonGames++;
			} else if (team2.point == 4) {
				team2.numberOfWonGames++;
			}
			team1.resetPoints();
			team2.resetPoints();
		}

	}

	public void calcGame() {
		gameScores[currentSet][0] = team1.numberOfWonGames;
		gameScores[currentSet][1] = team2.numberOfWonGames;

		thisSetIsDuece = team1.numberOfWonGames >= 5 && team2.numberOfWonGames >= 5;
//		boolean isDuece = team1.numberOfWonGames >= 5 && team2.numberOfWonGames >= 5;
		if (thisSetIsDuece) {
//			this.dispScoreBoard(); // 게임스코어 보여주기

			int p;

//			System.out.println("************************ Deuce = Game 5:5 ************************ ");
			if (Math.abs(team1.numberOfWonGames - team2.numberOfWonGames) == 2
					&& (team1.numberOfWonGames >= 7 || team2.numberOfWonGames >= 7)) {
				if (team1.numberOfWonGames > team2.numberOfWonGames) {
					team1.numberOfWonSets++;
				} else {
					team2.numberOfWonSets++;
				}
				currentSet++;
				team1.resetGames();
				team2.resetGames();
				thisSetIsDuece = false;
			}

		} else if (team1.numberOfWonGames == 6 || team2.numberOfWonGames == 6) {
			if (team1.numberOfWonGames == 6) {
				team1.numberOfWonSets++;
			} else if (team2.numberOfWonGames == 6) {
				team2.numberOfWonSets++;
			}
			currentSet++;
			team1.resetGames();
			team2.resetGames();
		}
	}

	public void calcSet() {
		if (team1.numberOfWonSets == numberOfSet / 2 + 1) {
			// team1 winner
			winner = team1.name;
		} else if (team2.numberOfWonSets == numberOfSet / 2 + 1) {
			winner = team2.name;
		}

	}
}

class Team {

	String name;
	int point = 0;
	String pointStr = null;
	int numberOfWonGames;
	int numberOfWonSets;
	int pointsOfDuece = 5;
	int setsOfDuece;

	public Team(String name, int point, int numberOfWonGames, int numberOfWonSets) {
		this.name = name;
		this.point = point;
		this.pointStr = TennisCounter.pointFormat[point];
		this.numberOfWonGames = numberOfWonGames;
		this.numberOfWonSets = numberOfWonSets;
	}

	public void resetGames() {
		this.numberOfWonGames = 0;
	}

	public void resetPoints() {
		this.point = 0;
		this.pointStr = TennisCounter.pointFormat[point];
	}

	public void resetPointsOfDeuce() {
		this.pointsOfDuece = 5;
		this.pointStr = TennisCounter.pointFormat[pointsOfDuece];
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", point=" + point + ", pointStr=" + pointStr + ", numberOfWongames="
				+ numberOfWonGames + ", numberOfWonSets=" + numberOfWonSets + "]";
	}

}