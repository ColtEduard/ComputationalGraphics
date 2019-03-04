package Fractals;

import java.util.ArrayList;
import java.util.Random;

import assignment1.Point;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;



public class SierpinskiTriangle extends Application{
static Random random = new Random();
	public static void main(String[] args) {
	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final int WIDTH = 800;
		final int HEIGHT = 600;
		final int chartHeight = 250;
		final int chartWidth = 250;
		final NumberAxis xAxis = new NumberAxis(-chartWidth, chartHeight, 1);
		final NumberAxis yAxis = new NumberAxis(-chartWidth, chartHeight, 1);
		final ScatterChart<Number, Number> scatterChart = new ScatterChart<Number,Number>(xAxis,yAxis);
		scatterChart.setTitle("Sierpinski Triangle");
		
		XYChart.Series points = new XYChart.Series();

		Point2D point1 = new Point2D(0, chartHeight - 5);
		Point2D point2 = new Point2D(chartWidth - 5, -(chartHeight - 5));
		Point2D point3 = new Point2D(-(chartWidth - 5), -(chartHeight - 5));
		points.getData().add(new XYChart.Data(point1.getX(), point1.getY()));
		points.getData().add(new XYChart.Data(point2.getX(), point2.getY()));
		points.getData().add(new XYChart.Data(point3.getX(), point3.getY()));
		
		ArrayList<Point2D> list = new ArrayList<>();
		list.add(point1);
		list.add(point2);
		list.add(point3);
		
		for(int i = 0; i < 1000; i++) {
			int index1 = random.nextInt(i + 2);
			System.out.println("i1: " + index1);
			int index2 = random.nextInt(i + 2);
			System.out.println("i2: " + index2);
			
			Point2D randPoint = list.get(index1);
			System.out.println("Point: " + randPoint.toString());
			double rX = randPoint.getX() + list.get(index2).getX()/2;
			double rY = (randPoint.getY() + list.get(index2).getY())/2;
			list.add( new Point2D((randPoint.getX() + list.get(index2).getX())/2, (randPoint.getY() + list.get(index2).getY())/2));
			points.getData().add(new XYChart.Data(rX, rY));
			}
		
		System.out.println("Points: " + list.toString());
		
		primaryStage.setWidth(WIDTH);
		primaryStage.setHeight(HEIGHT);
		
//		}
//		
		
		scatterChart.getData().addAll(points);
		
		Scene scene = new Scene(scatterChart, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sierpinski Triangle");
		primaryStage.show();
	}
	
	
	
}
