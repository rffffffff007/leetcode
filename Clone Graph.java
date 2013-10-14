/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneGraph(node, map);
    }
    
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if(node == null)
            return null;
        if(map.containsKey(node)){
            return map.get(node);
        } else {
            UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
            map.put(node, cloneNode);
            for(UndirectedGraphNode nei : node.neighbors){
                cloneNode.neighbors.add(cloneGraph(nei, map));
            }
            return cloneNode;
        }
    }
}