package Figure;

import java.util.Comparator;

public abstract class Figure implements IFigure, IFigureAnother, Comparator<Figure> {
	 
	public Figure(String helloText) {
		System.out.println(helloText);
	}
	
	public static final void sayHello() {
		System.out.println("Hello there User");
	}
	
	abstract double getPerimeter ();
	
	abstract double getArea() ;
	
	public void printFigureAreaAndLength() {
		System.out.println("Perimeter: "+ getPerimeter () + " Area: " + getArea());
	}
	
	abstract public void printFigureData(); 
	
	abstract public void sayHelloToFigure() ;
	abstract public boolean validateFigure();

	abstract public int compare(Figure o1, Figure o2) ;
	
	
	
	
	
	
}