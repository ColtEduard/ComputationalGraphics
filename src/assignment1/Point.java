package assignment1;
import java.util.Scanner;

public class Point {

	double x;
	double y;

	public Point()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void input()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the coordinates (X, Y) ");
		this.x = scanner.nextDouble();
		this.y = scanner.nextDouble();
		
	}
	
}
