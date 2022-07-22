package Figure;

public class Circle extends Figure{
	
	private double radius;
	
	public Circle(String helloText, double radius) {
		super(helloText);
		this.setRadius(radius);
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	/*
	 Task 1 06.07.2022
	 
	 Circle does not have getLength method, but has getPerimeter
	 
	 */

	@Override
	public int compare(Figure o1, Figure o2) {
		return -Double.compare(o1.getPerimeter(), o2.getPerimeter());
	}

	@Override
	double getPerimeter() {
	
		return (2 * Math.PI * this.radius);
	}

	@Override
	double getArea() {
		
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public void printFigureData() {
		System.out.println("Perimeter: " + this.getPerimeter() + " Area: " + this.getArea());
		
	}

	@Override
	public void sayHelloToFigure() {
		System.out.println("Hello from Circle");
		
	}

	@Override
	public boolean validateFigure() {
		if(this.radius > 0) {
			return true;
		}
		return false;
	}

}
