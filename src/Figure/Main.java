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
		
		
		TreeSet<Circle> circleTreeset = new TreeSet<>(CreateTreesets.circlesTreeSet(args[0]));
		TreeSet<Rectangle> rectangleTreeset = new TreeSet<>(CreateTreesets.rectanglesTreeSet(args[1]));
		TreeSet<Triangle> triangleleTreeset = new TreeSet<>(CreateTreesets.trianglesTreeSet(args[2]));
		
	}


}



