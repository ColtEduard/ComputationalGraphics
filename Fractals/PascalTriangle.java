package Fractals;

import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
	static int previous[];
	static int current[];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of pascal triangle: ");
		int size = scanner.nextInt();
		previous = new int[size];
		current = new int[size];
		current[0] = 1;
		pascalTriangle(1, size);

	}

	static void pascalTriangle(int iteration, int size) {

		//System.out.println("It: " + iteration + Arrays.toString(previous));
		
		// The spaces so it represents a triangle
		for (int i = 0; i < size - iteration; i++) {
			System.out.print(" ");
		}
		
		
		if (iteration > 2) {
			
			System.out.print("1 ");
			for(int i = 1; i < iteration; i++)
			{
				current[i] = previous[i] + previous[i - 1];
				System.out.print(current[i] + " ");
			}
			System.out.println();
			
		} else if (iteration == 2) {
			System.out.println("1 1");

			for (int i = 0; i < iteration; i++) {
				current[i] = 1;
			}

		} else {
			System.out.println("1");
		}

		if(iteration < size)
		{
			previous = Arrays.copyOf(current, size);
			pascalTriangle(iteration + 1, size);
		} else {
			return;
		}
		
	}

}
