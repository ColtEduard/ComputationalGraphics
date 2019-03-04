package assignment1;

import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Utils {

	static DecimalFormat dFormat = new DecimalFormat("#.##");

	// Area of triangle


	// Area of quadrilateral
	static double getArea(Point pointA, Point pointB, Point pointC, Point pointD) {
		double area;
		double delta;
		
		delta = ((pointA.getX() * pointB.getY() - pointA.getY() * pointB.getX()) +
                (pointB.getX() * pointC.getY() - pointB.getY() * pointC.getX()) +
                (pointC.getX() * pointD.getY() - pointC.getY() * pointD.getX()) +
                (pointD.getX() * pointA.getY() - pointD.getY() * pointA.getX()
                ));
		
		area = Math.abs(delta) / 2;
		
		return area;
	}
	
	static double getArea(Point pointA, Point pointB, Point pointC) {
		double area;

		// Heron's formula
		// s - semiperimeter
		// a, b, c - sides
		// Area = sqrt( s(s-a)(s-b)(s-c) )

		double sideA = getSide(pointB, pointC);

		double sideB = getSide(pointA, pointC);

		double sideC = getSide(pointA, pointB);

		double semiPerimeter = getPerimeter(sideA, sideB, sideC) / 2;

		area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));

		return area;
	}
		
	static double getSide(Point pointA, Point pointB) {
		double side = Math
				.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2) 
					+ Math.pow(pointB.getY() - pointA.getY(), 2));

		return side;
	}
	
	static double getPerimeter(double sideA, double sideB, double sideC) {
		double perimeter = sideA + sideB + sideC;

		return perimeter;
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

	static String getType(Point pointA, Point pointB, Point pointC, Point pointD) {
		
		String type;
		
		boolean parallelogram = false;
		boolean trapezoid = false;
		boolean rectangle = false;
		boolean rhombus = false;
		boolean square = false;
		
		double sideAB = getSide(pointA, pointB);
		double sideAD = getSide(pointA, pointD);
		double sideBC = getSide(pointB, pointC);
		double sideCD = getSide(pointC, pointD);

		double diagAC = getSide(pointA, pointC);
		double diagBD = getSide(pointB, pointD);
		
		double slopeAB = getSlope(pointA, pointB);
		double slopeAD = getSlope(pointA, pointD);
		double slopeBC = getSlope(pointB, pointC);
		double slopeCD = getSlope(pointC, pointD);
		
		double slopeAC = getSlope(pointA, pointC);
		double slopeBD = getSlope(pointB, pointD);
		
		if (slopeAB == slopeCD && slopeAD == slopeBC) {
			parallelogram = true;
		} else if (slopeBC == slopeAD) {
			trapezoid = true;
			
		}
		if (parallelogram && diagAC == diagBD) {
			rectangle = true;
		}

		if (sideAB == sideAD && sideAB == sideCD && sideAB == sideBC && slopeAC != slopeBD) {
			rhombus = true;
		}

		if (rectangle && slopeAC == slopeBD) {
			square = true;
		}
		
		if (square) {
			type = "square";
		} else if (rhombus) {
			type = "rhombus";
		} else if (rectangle) {
			type = "rectangle";
		} else if (parallelogram) {
			type = "parallelogram";
		} else if(trapezoid) {
			type = "trapezoid";
		} else {
			type = "any type of quadrilateral";
		}
		
		return type;
		
	}
	
	static double getSlope(Point pointA, Point pointB) {

		double slope;

		slope = (pointB.getY() - pointA.getY()) / (pointB.getX() - pointA.getX());

		return slope;

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

			slope = getSlope(pointA, pointB);
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