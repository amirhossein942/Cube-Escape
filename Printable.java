
public interface Printable {

	public void print();
	
	
	static void print(Printable... arr) {
		for(Printable x:arr) {
			x.print();
		}
	}
}
