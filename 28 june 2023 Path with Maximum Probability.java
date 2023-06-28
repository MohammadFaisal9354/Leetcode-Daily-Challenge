import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Edge>> graph = buildGraph(n, edges, succProb);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 1.0));

        double[] probabilities = new double[n];
        probabilities[start] = 1.0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentVertex = currentNode.vertex;
            double currentProbability = currentNode.probability;

            for (Edge edge : graph.get(currentVertex)) {
                int nextVertex = edge.destination;
                double nextProbability = currentProbability * edge.probability;

                if (nextProbability > probabilities[nextVertex]) {
                    probabilities[nextVertex] = nextProbability;
                    queue.offer(new Node(nextVertex, nextProbability));
                }
            }
        }

        return probabilities[end];
    }

    private Map<Integer, List<Edge>> buildGraph(int n, int[][] edges, double[] succProb) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int source = edge[0];
            int destination = edge[1];
            double probability = succProb[i];

            graph.get(source).add(new Edge(destination, probability));
            graph.get(destination).add(new Edge(source, probability));
        }

        return graph;
    }

    class Edge {
        int destination;
        double probability;

        public Edge(int destination, double probability) {
            this.destination = destination;
            this.probability = probability;
        }
    }

    class Node {
        int vertex;
        double probability;

        public Node(int vertex, double probability) {
            this.vertex = vertex;
            this.probability = probability;
        }
    }
}
