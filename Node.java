
public class Node {
	Node edges[];
	String name;
	boolean visited = false;
	
	public Node(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
