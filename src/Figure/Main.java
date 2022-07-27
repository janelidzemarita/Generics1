package Figure;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main{

	public static void main(String[] args) throws FileNotFoundException, IOException {

		/*
		 * Input File Paths 
		 * D:\\TBC_Academy\\Generics\\src\\InputFiles\\Circles_in.dat
		 * D:\\TBC_Academy\\Generics\\src\\InputFiles\\Rectangles_in.dat
		 * D:\\TBC_Academy\\Generics\\src\\InputFiles\\Triangles_in.dat
		 */
		
		
		TreeSet<Circle> circleTreeset = CreateTreesets.circlesTreeSet(args[0]);
		TreeSet<Rectangle> rectangleTreeset = CreateTreesets.rectanglesTreeSet(args[1]);
		TreeSet<Triangle> triangleleTreeset = CreateTreesets.trianglesTreeSet(args[2]);
		
		
		ArrayList<Circle> circleArrayList = new ArrayList<>(CreateArrayList.circlesArrayList(args[0]));
		ArrayList<Rectangle> rectangleArrayList = new ArrayList<>(CreateArrayList.rectanglesArrayList(args[1]));
		ArrayList<Triangle> triangleleArrayList = new ArrayList<>(CreateArrayList.trianglesArrayList(args[2]));
		
		
		getMinMax(circleTreeset, rectangleTreeset,triangleleTreeset );
		
		/*
		
		TreeSet<Figure> treeSets = new TreeSet<>();
		treeSets.addAll(CreateTreesets.circlesTreeSet(args[0]));
		treeSets.addAll(CreateTreesets.rectanglesTreeSet(args[1]));
		treeSets.addAll(CreateTreesets.trianglesTreeSet(args[2]));
		
		ArrayList<Figure> arrayLists = new ArrayList<>();
		arrayLists.addAll(CreateArrayList.circlesArrayList(args[0]));
		arrayLists.addAll(CreateArrayList.rectanglesArrayList(args[1]));
		arrayLists.addAll(CreateArrayList.trianglesArrayList(args[2]));
		*/
		
	}

	public static void getMinMax(TreeSet<Circle> circleTreeset, TreeSet<Rectangle> rectangleTreeset,
			TreeSet<Triangle> triangleleTreeset) {
		System.out.println("Max Circle: " + circleTreeset.last() + " Max Rectangle: " + rectangleTreeset.last()
				+ " Max Triangle: " + triangleleTreeset.last());

	}
}


class CreateTreesets {

	public static TreeSet<Circle> circlesTreeSet(String args) throws FileNotFoundException, IOException {
		Pattern formatCircle = Pattern.compile("([0-9]+)");

		try (FileInputStream inStrm = new FileInputStream(args);
				BufferedInputStream bf = new BufferedInputStream(inStrm);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, "UTF-8"));
				FileOutputStream outStrm = new FileOutputStream(
						"D:\\TBC_Academy\\Generics\\src\\OutputFiles\\Circles_out_unique.dat");
				OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
				BufferedWriter bfw = new BufferedWriter(bfo);) {
			TreeSet<Circle> setCircle = new TreeSet<>();
			while (read.ready()) {
				String str = read.readLine();
				Matcher match = formatCircle.matcher(str);
				if (match.matches()) {
					setCircle.add(new Circle("Circle", Double.parseDouble(str)));
				}
			}
			/*
			Iterator<Circle> circles = setCircle.iterator();
			while (circles.hasNext()) {
				bfw.write(Double.toString(circles.next().getRadius()) + "\n");
				
			}*/
			return setCircle;
		}
	}

	public static TreeSet<Rectangle> rectanglesTreeSet(String args) throws FileNotFoundException, IOException {
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
			/*
			 * for(Rectangle rec : setRectangle){ bfw.write(rec.getLength() + "-" +
			 * rec.getHigth() + "\n"); System.out.println(rec.getPerimeter()); }
			 */
			return setRectangle;
		}

	}

	public static TreeSet<Triangle> trianglesTreeSet(String args) throws FileNotFoundException, IOException {
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
					setTriangle.add(new Triangle(Double.parseDouble(lst[0]), Double.parseDouble(lst[1]),
							Double.parseDouble(lst[2])));
				}
			}
			/*
			 * for(Triangle triangle : setTriangle){ bfw.write(triangle.getAB() + "-" +
			 * triangle.getBC() + "-" + triangle.getCA() + "\n"); }
			 */
			return setTriangle;
		}
	}

}
class CreateArrayList{

	public static ArrayList<Circle> circlesArrayList(String args) throws FileNotFoundException, IOException {
		Pattern formatCircle = Pattern.compile("([0-9]+)");

		try (FileInputStream inStrm = new FileInputStream(args);
				BufferedInputStream bf = new BufferedInputStream(inStrm);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, "UTF-8"));
				FileOutputStream outStrm = new FileOutputStream(
						"D:\\TBC_Academy\\Generics\\src\\OutputFiles\\Circles_out_unique.dat");
				OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
				BufferedWriter bfw = new BufferedWriter(bfo);) {
			ArrayList<Circle> setCircle = new ArrayList<>();
			while (read.ready()) {
				String str = read.readLine();
				Matcher match = formatCircle.matcher(str);
				if (match.matches()) {
					setCircle.add(new Circle("Circle", Double.parseDouble(str)));
				}
			}
			/*
			Iterator<Circle> circles = setCircle.iterator();
			while (circles.hasNext()) {
				bfw.write(Double.toString(circles.next().getRadius()) + "\n");
				
			}*/
			return setCircle;
		}
	}

	public static ArrayList<Rectangle> rectanglesArrayList(String args) throws FileNotFoundException, IOException {
		Pattern formatRectangle = Pattern.compile("([0-9]+[-][0-9]+)");
		try (FileInputStream inStrm = new FileInputStream(args);
				BufferedInputStream bf = new BufferedInputStream(inStrm);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, "UTF-8"));
				FileOutputStream outStrm = new FileOutputStream(
						"D:\\TBC_Academy\\Generics\\src\\OutputFiles\\Rectangles_out.dat");
				OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
				BufferedWriter bfw = new BufferedWriter(bfo);) {
			ArrayList<Rectangle> setRectangle = new ArrayList<Rectangle>();
			while (read.ready()) {
				String str = read.readLine();
				Matcher match = formatRectangle.matcher(str);
				if (match.matches()) {
					String[] lst = str.split("-");
					setRectangle.add(new Rectangle(Double.parseDouble(lst[0]), Double.parseDouble(lst[1])));

				}
			}
			/*
			 * for(Rectangle rec : setRectangle){ bfw.write(rec.getLength() + "-" +
			 * rec.getHigth() + "\n"); System.out.println(rec.getPerimeter()); }
			 */
			return setRectangle;
		}

	}

	public static ArrayList<Triangle> trianglesArrayList(String args) throws FileNotFoundException, IOException {
		Pattern formatTriangle = Pattern.compile("([0-9]+[-][0-9]+[-][0-9]+)");
		try (FileInputStream inStrm = new FileInputStream(args);
				BufferedInputStream bf = new BufferedInputStream(inStrm);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, "UTF-8"));
				FileOutputStream outStrm = new FileOutputStream(
						"D:\\TBC_Academy\\Generics\\src\\OutputFiles\\Triangles_out.dat.dat");
				OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
				BufferedWriter bfw = new BufferedWriter(bfo);) {
			ArrayList<Triangle> setTriangle = new ArrayList<Triangle>();

			while (read.ready()) {
				String str = read.readLine();
				Matcher match = formatTriangle.matcher(str);
				if (match.matches()) {
					String[] lst = str.split("-");
					setTriangle.add(new Triangle(Double.parseDouble(lst[0]), Double.parseDouble(lst[1]),
							Double.parseDouble(lst[2])));
				}
			}
			/*
			 * for(Triangle triangle : setTriangle){ bfw.write(triangle.getAB() + "-" +
			 * triangle.getBC() + "-" + triangle.getCA() + "\n"); }
			 */
			return setTriangle;
		}
	}

	
}

