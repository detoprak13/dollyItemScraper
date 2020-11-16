package Entity;

public class DollyWord {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DollyWord{" +
				"name='" + name + '\'' +
				'}';
	}
}
