import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
	
	
	Scanner kb = new Scanner(System.in);
    Scanner sc=null;
	ArrayList<String> arrl = new ArrayList<String>();
	
	try {
		System.out.println("PLease enter file name: ");
		String file = kb.next();
		sc = new Scanner(new FileInputStream(file));
	}
	catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
		System.exit(0);
	}
	
	while(sc.hasNextLine()) {
		String token = sc.nextLine();
		arrl.add(token);
	}
	
	
	arrl.trimToSize();
	String[] arr = arrl.toArray(new String[0]);	
	
	Arrays.sort(arr);
	
	Shape[] shapes = new Shape[arr.length];
	
	for(int c=0; c<arr.length; c++) {
		if(arr[c].contains("Rectangle")){
			shapes[c] = Rectangle.parse(arr[c]);
		}
		else if(arr[c].contains("Circle")) {
			shapes[c] = Circle.parse(arr[c]);
		}
		else {
			System.out.println("Error");
		}
	}
	
	

	
	Arrays.sort(shapes, new Comparator<Shape>( ) {
		@Override
		public int compare(Shape o1, Shape o2) {
			int compareName = o1.getName().compareTo(o2.getName());
			
			int compareArea = Double.compare(o1.getArea(), o2.getArea());
			
			if(compareName==0) {
				return compareArea;
			}
			else {
				return compareName;
			}
			
			
			
		}	
	}
			);
	

	
	
	Printable.print(java.util.Arrays.copyOf(shapes, shapes.length, Printable[].class));
	
    sc.close();
    kb.close();
	}

	
   
	

	

	

}
