package assignment1;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		
		DecimalFormat dFormat = new DecimalFormat("#.##");
		dFormat.setRoundingMode(RoundingMode.HALF_UP);

		Point pointA = new Point();
		Point pointB = new Point();
		Point pointC = new Point();
		Point pointD = new Point();

		System.out.println("Point A: ");
		pointA.input();
		System.out.println("Point B: ");
		pointB.input();
		System.out.println("Point C: ");
		pointC.input();
		System.out.println("Point D: ");
		pointC.input();
		
		
		// a) Area of a the triangle created by the three points
		double area = Utils.getArea(pointA, pointB, pointC);
		System.out.println("-----Triangle ABC-----");
		System.out.println('\n' + "Area: " + dFormat.format(area));

//		// b) coordinates of the center of the inscribed circle in this triangle
//		Point centerOfCircle = Utils.getCenterInCircle(pointA, pointB, pointC);
//		System.out.print('\n' + "Coordinates of circle are: ");
//		System.out.print("("  + dFormat.format(centerOfCircle.getX()) + ", ");
//		System.out.println(dFormat.format(centerOfCircle.getY()) + ")");
//
//		//c) radius of the circle inscribed in the triangle
//		double radius = Utils.getRadiusInCircle(pointA, pointB, pointC);
//		System.out.println('\n' + "Radius of circle is: " + dFormat.format(radius));
//
//		// d) formula of the sides of a triangle
//		System.out.println('\n' + "Equation of the sides: ");
//		Utils.equationOfTheSide(pointA, pointB, "AB");
//		Utils.equationOfTheSide(pointA, pointC, "AC");
//		Utils.equationOfTheSide(pointB, pointC, "BC");
//		
//		
		System.out.println('\n'  + "-----Quadrilateral ABCD-----");
		area = Utils.getArea(pointA, pointB, pointC, pointD);
		System.out.println('\n' + "Area: " + dFormat.format(area));
	}
	
	

}
