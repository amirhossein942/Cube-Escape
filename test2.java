// -----------------------------------------------------
// Assignment 1
// Question 2
// Written by:  Amirhossein Tavakkoly 40203604, Cristian Gasparesc 40209205, Sarah Amaniss 40213883
// -----------------------------------------------------

//Import Packages
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
		Scanner sc = null;
		ArrayList<String> arrl = new ArrayList<String>();

		// Open files and handle excpetion if needed
		try {
			System.out.println("Enter file name: ");
			String file = kb.next();
			sc = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		// Read each shape and store in array list
		while (sc.hasNextLine()) {
			String token = sc.nextLine();
			arrl.add(token);
		}

		// Trim array list and convert to array
		arrl.trimToSize();
		String[] arr = arrl.toArray(new String[0]);

		// Sort in alphabetical order
		Arrays.sort(arr);

		Shape[] shapes = new Shape[arr.length];

		// Go through the array
		for (int c = 0; c < arr.length; c++) {
			// Create Rectangle object and store into Shape Array
			if (arr[c].contains("Rectangle")) {
				shapes[c] = Rectangle.parse(arr[c]);
			}
			// Create Circle object and store into Shape Array
			else if (arr[c].contains("Circle")) {
				shapes[c] = Circle.parse(arr[c]);
			}
			// Display error message if no shape is given
			else {
				System.out.println("Error");
			}
		}

		// Anonymous Class
		Arrays.sort(shapes, new Comparator<Shape>() {
			@Override

			// Method that compares name and area of 2 shapes
			public int compare(Shape o1, Shape o2) {

				// Will return 0 if string are the same
				int compareName = o1.getName().compareTo(o2.getName());

				// Will return if 0 if areas are the same
				int compareArea = Double.compare(o1.getArea(), o2.getArea());

				// Return comparison
				if (compareName == 0) {
					return compareArea;
				} else {
					return compareName;
				}

			}
		});

		// Print the sorted elements
		Printable.print(java.util.Arrays.copyOf(shapes, shapes.length, Printable[].class));

		// Close Scanner
		sc.close();
		kb.close();
	}

}
