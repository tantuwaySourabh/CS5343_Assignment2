import java.util.*;

public class q3 {

	static ArrayList<Integer> graphSets(HashMap<Integer, ArrayList<Integer>> graph) {
		if (graph.size() == 0) {
			return new ArrayList<>();
		}

		if (graph.size() == 1) {
			return new ArrayList<Integer>(graph.keySet());
		}
		int vCurrent = (new ArrayList<Integer>(graph.keySet()))
				.get(0);

		HashMap<Integer, ArrayList<Integer>> graph2 = new HashMap<>(graph);

		graph2.remove(vCurrent);

		ArrayList<Integer> res1 = graphSets(graph2);

		for (Integer v : graph.get(vCurrent)) {

			if (graph2.containsKey(v)) {
				graph2.remove(v);
			}
		}

		ArrayList<Integer> res2 = new ArrayList<>();
		res2.add(vCurrent);
		res2.addAll(graphSets(graph2));

		if (res1.size() > res2.size())
			return res1;
		return res2;
	}

	public static void main(String[] args) {
		int V = 8;

		int[][] E = { { 1, 2 }, { 1, 3 }, { 2, 4 },
				{ 5, 6 }, { 6, 7 }, { 4, 8 } };

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

		for (int[] e : E) {
			int v1 = e[0];
			int v2 = e[1];
			if (!graph.containsKey(v1)) {
				graph.put(v1, new ArrayList<>());
			}
			if (!graph.containsKey(v2)) {
				graph.put(v2, new ArrayList<>());
			}
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		ArrayList<Integer> maximalIndependentSet = graphSets(graph);

		for (Integer i : maximalIndependentSet)
			System.out.print(i + " ");
	}
}
