import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {

	private Map<Integer, Node> nodeLookup = new HashMap<>();

	public static class Node {
		private int id;
		List<Node> adjNode = new LinkedList<>();

		public Node(int id) {
			this.setId(id);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

	private Node getNode(int id) {
		return nodeLookup.get(id);
	}

	public void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		s.adjNode.add(d);
	}

	public boolean hasPathDFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		Set<Integer> visited = new HashSet<>();
		return hasPathDFS(s, d, visited);
	}

	private boolean hasPathDFS(Node source, Node destination,
			Set<Integer> visited) {
		if (source == destination)
			return true;
		if (visited.contains(source.id))
			return false;
		visited.add(source.id);
		for (Node child : source.adjNode) {
			if (hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPathBFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		Set<Integer> visited = new HashSet<>();
		return hasPathBFS(s, d, visited);
	}

	private boolean hasPathBFS(Node source, Node destination,
			Set<Integer> visited) {
		Queue<Node> nextToVisit = new LinkedList<>();
		nextToVisit.add(source);
		while (!nextToVisit.isEmpty()) {
			Node currNode = nextToVisit.remove();
			if (currNode == destination)
				return true;
			if (visited.contains(currNode.id)) {
				continue;
			}
			visited.add(currNode.id);
			for (Node child : currNode.adjNode) {
				nextToVisit.add(child);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GraphTraversal gt = new GraphTraversal();
		Node n1 = new Node(1);		
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		gt.nodeLookup.put(1, n1);
		gt.nodeLookup.put(2, n2);
		gt.nodeLookup.put(3, n3);
		gt.nodeLookup.put(4, n4);
		gt.nodeLookup.put(5, n5);
		gt.nodeLookup.put(6, n6);
		gt.nodeLookup.put(7, n7);
		gt.nodeLookup.put(8, n8);
		gt.addEdge(n1.id, n2.id);
		gt.addEdge(n1.id, n3.id);
		gt.addEdge(n1.id, n4.id);
		gt.addEdge(n1.id, n6.id);
		gt.addEdge(n2.id, n3.id);
		gt.addEdge(n3.id, n6.id);
		gt.addEdge(n4.id, n6.id);
		gt.addEdge(n6.id, n5.id);
		gt.addEdge(n6.id, n8.id);
		gt.addEdge(n8.id, n7.id);
		System.out.println(gt.hasPathBFS(1, 7));
		System.out.println(gt.hasPathDFS(1, 1));
	}

}
