package assignment1;

import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Utils {

	static DecimalFormat dFormat = new DecimalFormat("#.##");

	static double getArea(Point pointA, Point pointB, Point pointC) {
		double area;
		
		double delta = 
				(pointA.getX() * (pointB.getY() - pointC.getY())
				+ pointB.getX() * (pointC.getY() - pointA.getY()) 
				+ pointC.getX() * (pointA.getY() - pointB.getY()));
		area = Math.abs(delta) / 2;

		return area;
	}
	
	static double getArea(Point pointA, Point pointB, Point pointC, Point pointD) {
		double area;
		
		area = getArea(pointA, pointB, pointC) + getArea(pointA, pointD, pointC);
		
		return area;	
	}

	static Point getCenterInCircle(Point pointA, Point pointB, Point pointC) {
		Point center = new Point();

		double sideA = getSide(pointB, pointC);

		double sideB = getSide(pointA, pointC);

		double sideC = getSide(pointA, pointB);

		center.setX((sideA * pointA.getX() + sideB * pointB.getX() + sideC * pointC.getX()) / (sideA + sideB + sideC));

		center.setY((sideA * pointA.getY() + sideB * pointB.getY() + sideC * pointC.getY()) / (sideA + sideB + sideC));

		return center;
	}

	static double getSide(Point pointA, Point pointB)	{
		double side = Math
				.sqrt(Math.pow((pointB.getX() - pointA.getX()), 2) + Math.pow(pointB.getY() - pointA.getY(), 2));
		
		return side;
	}
	
	static double getPerimeter(double sideA, double sideB, double sideC) {
		double perimeter = sideA + sideB + sideC;

		return perimeter;
	}

	static double getRadiusInCircle(Point pointA, Point pointB, Point pointC) {
		double radius;

		double sideA = getSide(pointB, pointC);

		double sideB = getSide(pointA, pointC);

		double sideC = getSide(pointA, pointB);

		double semiPerimeter = getPerimeter(sideA, sideB, sideC) / 2;

		double area = getArea(pointA, pointB, pointC);

		radius = area / semiPerimeter;

		return radius;

	}

	static void equationOfTheSide(Point pointA, Point pointB, String sideName) {
		// Equation: y = mx + b
		// m - slope
		// b - remainingElement

		double slope = 0;
		double remainingElement = 0;
		System.out.print("(" + sideName + ")" + " : ");
		
		if (pointA.getX() == pointB.getX()) {
			System.out.println("Can't divide by zero");
		} else if (pointA.getY() == pointB.getY()) {
			System.out.println("Can't divide zero");
		} else {

			slope = (pointB.getY() - pointA.getY()) / (pointB.getX() - pointA.getX());
			remainingElement = pointA.getY() - pointA.getX() * slope;

			dFormat.setRoundingMode(RoundingMode.HALF_UP);

			if (slope != 0) {
				System.out.print(dFormat.format(slope) + "x" + " - " + "y");
			} else {
				System.out.println("- y");
			}

			if (remainingElement == 0) {

			} else if (remainingElement < 0) {
				System.out.print(" - " + dFormat.format(Math.abs(remainingElement)));
			} else {
				System.out.print(" + " + dFormat.format(remainingElement));
			}

			System.out.print(" = 0 " + '\n');

		}
	}
}