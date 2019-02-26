package assignment1;

import java.lang.Math;


public class Utils {

	static double calculateArea(Point pointA, Point pointB, Point pointC) {
		double area;
		double delta = (pointB.getX() - pointA.getX()) * (pointC.getY() - pointA.getY())
				- (pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY());

		area = 0.5 * Math.abs(delta);

		return area;
	}

	
	static Point centerOfCircle(Point pointA, Point pointB, Point pointC) {
		Point center = new Point();
		
		double sideA = Math.sqrt(Math.pow((pointC.getX() - pointB.getX()), 2) 
					+ Math.pow(pointC.getY() - pointB.getY(), 2));
			
		double sideB = Math.sqrt(Math.pow((pointC.getX() - pointA.getX()), 2) 
					+ Math.pow(pointC.getY() - pointA.getY(), 2));
			
		double sideC = Math.sqrt(Math.pow((pointB.getX() - pointA.getX()), 2) 
					+ Math.pow(pointB.getY() - pointA.getY(), 2));
		
		
		center.setX((sideA * pointA.getX() + sideB * pointB.getX() + sideC * pointC.getX())
				/ (sideA+sideB+sideC));
		
		center.setY((sideA * pointA.getY() + sideB * pointB.getY() + sideC * pointC.getY())
		           / (sideA+sideB+sideC));
		
		return center;
	}
	
	static double perimeter(double sideA, double sideB, double sideC)
	{
		double perimeter = sideA + sideB + sideC;
		
		return perimeter;
	}
	
	static double radiusOfCircle(Point pointA, Point pointB, Point pointC)
	{
		double radius;
		
		double sideA = Math.sqrt(Math.pow((pointC.getX() - pointB.getX()), 2) 
				+ Math.pow(pointC.getY() - pointB.getY(), 2));
		
		double sideB = Math.sqrt(Math.pow((pointC.getX() - pointA.getX()), 2) 
				+ Math.pow(pointC.getY() - pointA.getY(), 2));
		
		double sideC = Math.sqrt(Math.pow((pointB.getX() - pointA.getX()), 2) 
				+ Math.pow(pointB.getY() - pointA.getY(), 2));
		
		double semiPerimeter = perimeter(sideA, sideB, sideC) / 2;
		
		double area = calculateArea(pointA, pointB, pointC);

		radius = area/semiPerimeter;

		return radius;
		
	}
	
	static void formulaOfTheSide(Point pointA, Point pointB, String nameOfSide)
	{
		
	}
}
