package 다형성실습;

import java.util.Random;

abstract class Shape {
	String name;
	String color;
	double size;

	Shape(String name, String color, double size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}

	Shape(String name, String color) {
		this.name = name;
		this.color = color;
	}

	void setSize(double size) {
		this.size = size;
	}

	abstract void draw();

	@Override
	public String toString() {
		return String.format("%s %s (%.2f)", color, name, size);
	}

}

class Line extends Shape {

	Line(String name, String color, double size) {
		super(name, color, size);
	}

	@Override
	void draw() {
		System.out.println("선을 그린다");
	}

}

class Point extends Shape {

	Point(String name, String color, double size) {
		super(name, color, size);
	}

	@Override
	void draw() {
		System.out.println("점을 그린다");
	}

}

class Rect extends Shape {

	int height;
	int width;

	Rect(String name, String color, int height, int width) {
		super(name, color);
		this.height = height;
		this.width = width;
		setSize();
	}

	private void setSize() {
		super.setSize((double) height * width);
	}

	@Override
	void draw() {
		System.out.println("사각형을 그린다");
	}

}

class Triangle extends Shape {

	int height;
	int width;

	Triangle(String name, String color, int height, int width) {
		super(name, color);
		this.height = height;
		this.width = width;
		setSize();
	}

	private void setSize() {
		super.setSize((double) height * width / 2);
	}

	@Override
	void draw() {
		System.out.println("삼각형을 그린다");
	}

}

class Circle extends Shape {

	int radius;

	Circle(String name, String color, int radius) {
		super(name, color);
		this.radius = radius;
		setSize();
	}

	private void setSize() {
		super.setSize((double) radius * radius * 3.141592653589793238);
	}

	@Override
	void draw() {
		System.out.println("원을 그린다");
	}

}

public class _01도형 {
	public static void main(String[] args) {
		// 모양, 색, 사이즈 랜덤 도형 10개 출력
		// 점, 선 기존 size 출력
		// 원, 네모, 세모 => size 넓이 계산해서 출력

		String[] colors = { "파란색", "빨간색", "보라색", "분홍색", "노란색" };
		String[] shapes = { "선", "점", "사각형", "삼각형", "원" };
		final int MAX_SIZE = 10;
		
		Shape[] list = new Shape[10];
		Random rd = new Random();
		for (int i = 0; i < list.length; i++) {
			String color = colors[rd.nextInt(colors.length)];
			int shapeNum = rd.nextInt(shapes.length);
			String name = shapes[shapeNum];
			int size = rd.nextInt(MAX_SIZE) + 1;
			int height = rd.nextInt(MAX_SIZE) + 1;
			int width = rd.nextInt(MAX_SIZE) + 1;
			if (shapeNum == 0) {
				list[i] = new Line(name, color, size);
			} else if (shapeNum == 1) {
				list[i] = new Point(name, color, size);
			} else if (shapeNum == 2) {
				list[i] = new Rect(name, color, height, width);
			} else if (shapeNum == 3) {
				list[i] = new Triangle(name, color, height, width);
			} else if (shapeNum == 4) {
				list[i] = new Circle(name, color, size);
			}
			list[i].draw();
			System.out.println(list[i] + "\n");
		}

		System.out.println("원만 출력");
		for(Shape s : list)
			if(s instanceof Circle)
				System.out.println(s);
	}
}
