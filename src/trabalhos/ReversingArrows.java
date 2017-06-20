package trabalhos;

import java.util.*;
import java.io.*;

/**
 * @author vitorh.brangioni
 *
 */
public class ReversingArrows {

	private static int bibika;
	private static int bibi;

	public static void main(String[] args) throws IOException {
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
		String read = null;
		read = bfReader.readLine();
		while (read != null && !read.equals("")) {
			int nodes = Integer.parseInt(read.split(" ")[0]);
			int setas = Integer.parseInt(read.split(" ")[1]);
			int A = Integer.parseInt(read.split(" ")[2]);
			int B = Integer.parseInt(read.split(" ")[3]);

			Graphic graph = new ReversingArrows().new Graphic();

			for (int i = 1; i <= nodes; i++) {
				graph.addNewNode(new ReversingArrows().new Nodo(i));
			}
			for (int i = 1; i <= setas; i++) {
				read = bfReader.readLine();
				graph.getListNodes().get(Integer.parseInt(read.split(" ")[0]) - 1)
						.addDest(Integer.parseInt(read.split(" ")[1]), false);
				graph.getListNodes().get(Integer.parseInt(read.split(" ")[1]) - 1)
						.addDest(Integer.parseInt(read.split(" ")[0]), true);
			}

			ReversingArrows.bibika = shortcutReversedBibika(graph, A, B);
			ReversingArrows.bibi = shortcutReversedBibi(graph, A, B);

			if (ReversingArrows.bibi > ReversingArrows.bibika) {
				System.out.println("Bibika: " + bibika);
			} else if (ReversingArrows.bibika > ReversingArrows.bibi) {
				System.out.println("Bibi: " + bibi);
			} else {
				System.out.println("Bibibibika");
			}
			read = bfReader.readLine();
		}
		bfReader.close();
	}

	/**
	 * Graphic class
	 *
	 */
	class Graphic {

		private List<Nodo> listNodes = new ArrayList<>();

		public List<Nodo> getListNodes() {
			return listNodes;
		}

		public void setListNodes(List<Nodo> nodes) {
			this.listNodes = nodes;
		}

		public void addNewNode(Nodo node) {
			listNodes.add(node);
		}
	}

	/**
	 * Node class
	 */
	class Nodo {
		private int key;
		private Map<Integer, Boolean> mapAdjacentNodes = new HashMap<>();

		public Nodo(Nodo node) {
			this.key = node.getKey();
			this.mapAdjacentNodes = node.getAdjacentNodes();
		}

		public Nodo(int key) {
			this.key = key;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public void setAdjNodes(Map<Integer, Boolean> adjNodes) {
			this.mapAdjacentNodes = adjNodes;
		}

		public Map<Integer, Boolean> getAdjacentNodes() {
			return mapAdjacentNodes;
		}

		public void addDest(int dest, Boolean reversed) {
			mapAdjacentNodes.put(dest, reversed);
		}
	}

	public static int shortcutReversedBibika(Graphic graph, int x, int y) {
		Nodo begin = graph.getListNodes().get(y - 1);
		Nodo end = graph.getListNodes().get(x - 1);
		int reversed = 0;
		while (end.getKey() != begin.getKey()) {
			for (int i = x; i <= begin.getKey(); i++) {
				if (begin.getAdjacentNodes().containsKey(i)) {
					if (begin.getAdjacentNodes().get(i)) {
						reversed++;
					}
					begin = graph.getListNodes().get(i - 1);
				}
				if (begin.getKey() == end.getKey()) {
					break;
				}
			}
		}
		return reversed;
	}

	public static int shortcutReversedBibi(Graphic graph, int x, int y) {
		Nodo start = graph.getListNodes().get(x - 1);
		Nodo end = graph.getListNodes().get(y - 1);
		int reversed = 0;
		while (start.getKey() != end.getKey()) {
			for (int i = y; i >= start.getKey(); i--) {
				if (start.getAdjacentNodes().containsKey(i)) {
					if (start.getAdjacentNodes().get(i)) {
						reversed++;
					}
					start = graph.getListNodes().get(i - 1);
				}
				if (start.getKey() == end.getKey())
					break;
			}
		}

		return reversed;
	}

}
