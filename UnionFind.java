/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * 
 * Eg.
 * 
 * n = 5
 * Edges= [0,1], [1,2], [3,4]
 * return 2
 * 
 *  0-----1    3
 *        |    |
 *        |    |
 *        2    4
 */
class UnionFind {
    private static int findConnectedComponents(int n, int[][] edges) {
        if (n<=1 || edges.length == 0)
            return n;

        int[] parent = new int[n];

        for(int i=0; i<n; i++)
            parent[i] = i;

        int components = n;
        int numEdges = edges.length;

        for(int i=0; i<numEdges; i++) {
            int startNode = edges[i][0];
            int endNode = edges[i][1];

            int rootOfStart = getRoot(startNode, parent);
            int rootOfEnd = getRoot(endNode, parent);

            if (rootOfStart != rootOfEnd ) {
                parent[rootOfStart] = rootOfEnd;
                components--;
            }
        }

        return components;
    }

    private static int getRoot(int node, int[] parent) {
        int parentNode = parent[node];

        if (parentNode == node)
            return node;

        parent[node] = getRoot(parentNode, parent);
        return parent[node];
    }

    public static void main(String args[]) {
        System.out.println(findConnectedComponents(5, new int[][]{ {0,1}, {1,2}, {3,4} } ) );
        System.out.println(findConnectedComponents(5, new int[][]{ {0,1}, {1,2}, {3,4}, {0,3} } ) );
        System.out.println(findConnectedComponents(5, new int[][]{ {1,2}, {2,0}, {4,3}} ) );
        System.out.println(findConnectedComponents(5, new int[][]{ {1,2}, {2,0}, {4,3}, {2,4}} ) );
        System.out.println(findConnectedComponents(8, new int[][]{ {4,0}, {3,2}, {4,7}, {6,4}, {1,5}} ) );
        System.out.println(findConnectedComponents(8, new int[][]{ {4,1}, {5,4}} ) );
        System.out.println(findConnectedComponents(8, new int[][]{ } ) );
        System.out.println(findConnectedComponents(8, new int[][]{ {1,2}, {5,4}, {3,6}, {7,0}, {2,4}, {0,3}} ) );
    }
}