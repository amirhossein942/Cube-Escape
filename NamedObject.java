
public interface NamedObject {

	default public String getName() {
		return this.getClass().getSimpleName();
	}
}
