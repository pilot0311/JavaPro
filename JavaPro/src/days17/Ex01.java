package days17;

import java.util.Arrays;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] sticks = new int[n];
		for (int i = 0; i < sticks.length; i++) {
			sticks[i] = scanner.nextInt();
		} // for
		Arrays.sort(sticks);
		System.out.println(Arrays.toString(sticks));

		int index = 0;
		int sticksLength = sticks.length;
		int sticksCount = sticksLength - index;
		System.out.println(sticksCount);

		for (int i = 0; i < sticksLength; i++) {
			if (sticks[index] != sticks[i]) {
				index = i;
				sticksCount = sticksLength - index;
				System.out.println(sticksCount);
				
			}
		} // for
	} // main
}
