/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<>();
        return cloneHelper(node, m);
    }
    
    private UndirectedGraphNode cloneHelper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> m) {
        if (node == null)
            return null;
        
        if (m.containsKey(node))
            return m.get(node);
        
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        m.put(node, cloneNode);
        
        for(UndirectedGraphNode n : node.neighbors) {
            cloneNode.neighbors.add(cloneHelper(n, m));
        }
        
        return cloneNode;
    }
}