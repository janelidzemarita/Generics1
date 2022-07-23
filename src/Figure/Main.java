package Figure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		/*
		 * Input File Paths D:\\TBC_Academy\\Generics\\src\\InputFiles\\Circles_in.dat
		 * D:\\TBC_Academy\\Generics\\src\\InputFiles\\Rectangles_in.dat
		 * D:\\TBC_Academy\\Generics\\src\\InputFiles\\Triangles_in.dat
		 */
		readCircles(args[0]);
		readRectangles(args[1]);
		readTriangles(args[2]);
	}

	public static void readCircles(String args) throws FileNotFoundException, IOException {
		Pattern formatCircle = Pattern.compile("([0-9]+)");

		try (FileInputStream inStrm = new FileInputStream(args);
				BufferedInputStream bf = new BufferedInputStream(inStrm);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, "UTF-8"));
				FileOutputStream outStrm = new FileOutputStream(
						"D:\\TBC_Academy\\Generics\\src\\OutputFiles\\Circles_out_unique.dat");
				OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
				BufferedWriter bfw = new BufferedWriter(bfo);) {
			HashSet<Circle> setCircle = new HashSet<Circle>();
			while (read.ready()) {
				String str = read.readLine();
				Matcher match = formatCircle.matcher(str);
				if (match.matches()) {
					setCircle.add(new Circle("Circle", Double.parseDouble(str)));
				}
			}
			Iterator<Circle> circles = setCircle.iterator();
			while (circles.hasNext()) {
				bfw.write(Double.toString(circles.next().getRadius()) + "\n");
				// Here we coule write the Circles as weel but the assignment said as it was in
				// input file.
			}
		}
	}

	public static void readRectangles(String args) throws FileNotFoundException, IOException {
		Pattern formatRectangle = Pattern.compile("([0-9]+[-][0-9]+)");
		try (FileInputStream inStrm = new FileInputStream(args);
				BufferedInputStream bf = new BufferedInputStream(inStrm);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, "UTF-8"));
				FileOutputStream outStrm = new FileOutputStream(
						"D:\\TBC_Academy\\Generics\\src\\OutputFiles\\Rectangles_out.dat");
				OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
				BufferedWriter bfw = new BufferedWriter(bfo);) {
			TreeSet<Rectangle> setRectangle = new TreeSet<Rectangle>();
			while (read.ready()) {
				String str = read.readLine();
				Matcher match = formatRectangle.matcher(str);
				if (match.matches()) {
					String[] lst = str.split("-");
					setRectangle.add(new Rectangle(Double.parseDouble(lst[0]), Double.parseDouble(lst[1])));
					
				}
			}
			for(Rectangle rec : setRectangle){
				bfw.write(rec.getLength() + "-" + rec.getHigth() + "\n");
				System.out.println(rec.getPerimeter());
	        }			
		}

	}

	public static void readTriangles(String args) throws FileNotFoundException, IOException {
		Pattern formatTriangle = Pattern.compile("([0-9]+[-][0-9]+[-][0-9]+)");
		try (FileInputStream inStrm = new FileInputStream(args);
				BufferedInputStream bf = new BufferedInputStream(inStrm);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, "UTF-8"));
				FileOutputStream outStrm = new FileOutputStream(
						"D:\\TBC_Academy\\Generics\\src\\OutputFiles\\Triangles_out.dat.dat");
				OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
				BufferedWriter bfw = new BufferedWriter(bfo);) {
			TreeSet<Triangle> setTriangle = new TreeSet<Triangle>();

			while (read.ready()) {
				String str = read.readLine();
				Matcher match = formatTriangle.matcher(str);
				if (match.matches()) {
					String[] lst = str.split("-");
					setTriangle.add(new Triangle(Double.parseDouble(lst[0]), 
							Double.parseDouble(lst[1]), Double.parseDouble(lst[2])));
				}
			}
			
			for(Triangle triangle : setTriangle){
				bfw.write(triangle.getAB() + "-" + triangle.getBC() + "-" + triangle.getCA() + "\n");
	        }

		}
	}

}
