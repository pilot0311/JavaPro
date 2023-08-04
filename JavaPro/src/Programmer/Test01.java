package Programmer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("막대기 수 입력: ");
		ArrayList<Integer> m = new ArrayList<Integer>();
		int n = scanner.nextInt();
		System.out.print("막대기 길이 입력: ");
		for (int i = 0; i < n; i++) {
			m.add(scanner.nextInt());
		}

		// System.out.println(m);
		CutOperation(m);

	} // main

	private static void CutOperation(ArrayList<Integer> m) {
		Collections.sort(m);
		do {
			System.out.println("남은 막대기 수:" + m.size());
			int min = m.get(0);
			for (int i = m.size() - 1; i >= 0; i--) {
				if (m.get(i) - min == 0) {
					m.remove(i);
				} else {
					m.set(i, m.get(i) - min);
				}
			} // for

		} while (m.size() != 0);

	}
}

/*
 * 취업문제) 막대기 자르기
 * 
 * 각각 0이상의 정수를 길이로 하는 N개의 막대기가 있다.
 * 
 * 이 막대기들 중 가장 짧은 막대기의 길이로 모든 막대기를 자르는 것을 [cut operation]이라고 하자.
 * 
 * 예를 들어 6개의 막대기가 있고 그 길이가 다음과 같다면
 * 
 * 5 4 4 2 2 8
 * 
 * 이 경우 [Cut Operation]을 한번 수행하면 다음과 같다.
 * 
 * 3 2 2 6
 * 
 * (가장 짧은 길이인 2로 6개의 막대기를 잘라내고 길이가 0이 되버린 2개의 막대기는 버려진다.)
 * 
 * N개의 막대기와 그 각각의 길이가 주어졌을 때 [Cut Operation]을 모든 막대기가 버려질 때(길이가 0이 될때)까지 반복하고 수행
 * 시 마다 남은 막대기의 수를 출력하는 프로그램을 작성하라.
 * 
 * 입력 첫줄에 막대기의 수 N을, 다음 줄에 각각의 막대기의 길이를 공백으로 구분해서 입력한다.
 * 
 * 출력 매 줄마다 [Cut Operation]이 수행 되 때 마다 남은 막대기의 수를 출력
 * 
 * 제한 1 <= N <= 1000 1 <= 막대기의 길이 <= 1000
 * 
 * 입력 예제 #1 6 5 4 4 2 2 8
 * 
 * 출력 예제 #1 6 4 2 1
 * 
 * 입력 예제 #2 8 1 2 3 4 3 3 2 1
 * 
 * 출력 예제 #2 8 6 4 1
 */