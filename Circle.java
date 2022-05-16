
public class Circle extends PrintableObjects implements Shape {

	private double radius;
	
	public Circle() {
		super();
		radius=0.0;
	}
	
	public Circle (double radius) {
		super();
		this.radius = radius;
	}
	
	public void setRadius(double radius) {
		this.radius =radius;
	}
	public double getRadius() {
		return this.radius;
	}
	
	public static Circle parse(String string) {
		String[] arr_rad = string.split(",");
		return new Circle(Double.parseDouble(arr_rad[1]));
		
	}
	
	

	@Override
	public double getPerimeter() {
		
		return 2* Math.PI *radius;
	}

	@Override
	public double getArea() {
		
		return Math.PI * (radius)*(radius);
	}
	
	public String getName() {
		return (this.getClass().getSimpleName().toUpperCase());
	}
	
	@Override
	public String toString() {
		return this.getName() + " Radius: " + radius;
	}
	
	
	
}
