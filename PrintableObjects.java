
public abstract class PrintableObjects implements NamedObject, Printable{

	
	
	public String toString() {
		return "Name of Object: " + this.getName();
	}
	
	public void print() {
		System.out.println(this.toString());
	}

}
