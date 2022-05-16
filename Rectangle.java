
public class Rectangle extends PrintableObjects implements Shape {

	private double side1, side2;
	
	public Rectangle() {
		super();
		side1=0;
		side2=0;
	}
	
	public Rectangle(double side1, double side2) {
		super();
		this.side1 =side1;
		this.side2 = side2;
	}
	
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	 public void setSide2(double side2) {
		 this.side2 = side2;
	 }
	 public double getSide1() {
		 return side1;
	 }
	 public double getSide2() {
		 return side2;
	 }
	
	 public static Rectangle parse(String string) {
		 String[] side_str = string.split(",");
		 return new Rectangle(Double.parseDouble(side_str[1]), Double.parseDouble(side_str[2]));
	 }
	 
	@Override
	public double getPerimeter() {
		double perimeter = 2*(this.side1) + 2*(this.side2);
		return perimeter;
	}

	@Override
	public double getArea() {
		 double area = this.side1 * this.side2;
		return area;
	}


	@Override
	public String toString() {
		 
		return super.toString() + " side 1: " + side1 + " side 2: " + side2;
	}

	 
	

}
