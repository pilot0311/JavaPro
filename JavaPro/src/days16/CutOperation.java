package days16;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author pilot
 * @date 2023. 8. 3. - 오후 4:43:11
 * @subject	개발자가 고의로 예외 발생 시키기
 * @content	1.	new 예외클래스()
 * 					2.	throw 문 사용해 생성된 에외를 발생시킬 수 있다
 * 
 * 						예)	국어점수 입력받아서 수~가 등급 처리
 * 							0~100 점수 범위 벗어나면 강제 예외발생 -> 처리
 */
public class CutOperation {

	public static void main(String[] args) {
		
		try {
			int kor = getScore();
		System.out.println(kor);
		}catch (InputMismatchException e) {
			System.out.println(e);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//에외 발생 상관없이 처리할 코딩
			
		}
		System.out.println("end");
	} // main

	private static int getScore() throws InputMismatchException{	
		int score;
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 점수 입력: ");
		String input = scanner.next();
		String regex = "100||[1-9]?\\d";
		if (input.matches(regex)) {
			score = Integer.parseInt(input);
		} else {
			//개발자가 고의로 예외 발생
			throw new InputMismatchException(">점수가 범위(0~100)를 벗어남");
		} //else
		
		return score;
	}
}
