package Fractals;

import java.util.Scanner;

public class CantorNumbers {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		checkCantorSet();
		System.out.println(" Thank you! ");

	}

	static boolean checkCantorNumber(int num) {

		int remainder = 0;

		while (num > 0) {
			remainder = num % 3;
			num /= 3;
			if (remainder == 0) {
				return false;
			}
		}

		return true;

	}

	static boolean checkCantorNumberBase3(int[] num) {

		for (int i = 0; i < num.length;) {
			if (num[i] == 0) {
				return false;
			} else if (num[i] == 1 || num[i] == 2) {
				i++;
			} else {
				System.err.println("This number is not in base 3");
				return false;
			}
		}

		return true;
	}

	static void checkCantorSet() {
		System.out.println("Base 10 or 3? ");
		int base = scanner.nextInt();
		int number;
		int[] num;
		int length;

		do {

			if (base == 10) {
				System.out.println("Enter your number");
				number = scanner.nextInt();
				
				if(checkCantorNumber(number))
				{
					System.out.println("Number is in the cantor set");
				} else {
					System.out.println("Number not in cantor set");
				}
				
				return;
			} else if (base == 3) {
				System.out.println("How long is your number? ");
				length = scanner.nextInt();
				num = new int[length];

				System.out.println("Enter your number");
				for (int i = 0; i < length; i++) {
					num[i] = scanner.nextInt();
				}
				if(checkCantorNumberBase3(num))
				{
					System.out.println("Number is in the cantor set");
				} else {
					System.out.println("Number not in cantor set");
				}

				return;
			} else {
				System.out.println("Base 10 or 3? ");
				base = scanner.nextInt();
			}
		} while (base != 10 | base != 3);

	}

}
