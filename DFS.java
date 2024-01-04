import java.util.Arrays;
import java.util.Scanner;

public class DFS {

	
	public static String dfs(Node[] graph, String str) {
		for (Node node : graph) {
			//System.out.println(node);
			if (node == null || node.visited) {
				continue;
			}
			node.visited = true;
			str += node.name + " ";
			str = dfs(node.edges, str);
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int instances = scnr.nextInt();
		Node graphs[][] = new Node[instances][];
		
		for (int i = 0; i < instances; i++) {
			int nodes = scnr.nextInt();
			Node nodeList[] = new Node[nodes];
			String adjacencyList[] = new String[nodes];
			
			for (int j = 0; j < nodes; j++) {
				String name = scnr.next();
				adjacencyList[j] = scnr.nextLine();
				nodeList[j] = new Node(name);
				
			}
			//System.out.println(Arrays.toString(nodeList));
			for (int j = 0; j < nodes; j++) {
				String edges[] = adjacencyList[j].trim().split(" ");
				//System.out.println(Arrays.toString(edges));
				Node edgeList[] = new Node[edges.length];
				//int x = 0;
				//Node currNode = nodeList[x];
				
				for (int z = 0; z < edges.length; z++) {
					/*
					while (!currNode.name.equals(edges[z]) && x + 1 < nodes) {
						currNode = nodeList[++x];
					}
					edgeList[z] = currNode;
					*/
					
					for (int y = 0; y < nodes; y++) {
						if (nodeList[y].name.equals(edges[z].trim())) {
							edgeList[z] = nodeList[y];
							break;
						}
					}
					
					//System.out.println("this: " + currNode);
				}
				nodeList[j].edges = edgeList;
			}
			graphs[i] = nodeList;
		}
		scnr.close();
		/*
		for (int i = 0; i < graphs.length; i++) {
			System.out.println(Arrays.toString(graphs[i]));
		}
		System.out.println(Arrays.toString(graphs[1][0].edges));
		System.out.println(Arrays.toString(graphs[1][1].edges));
		System.out.println(Arrays.toString(graphs[1][2].edges));
		System.out.println(Arrays.toString(graphs[1][3].edges));
		*/
		for (int i = 0; i < instances; i++) {
			String ans = dfs(graphs[i], "");
			System.out.println(ans.substring(0, ans.length() - 1));
			/*
			if (i + 1 < instances) {
			System.out.println();
			}
			*/
		}
	}

}
