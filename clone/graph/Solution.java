package clone.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;


//Definition for undirected graph.
 class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { 
    	 label = x; 
    	 neighbors = new ArrayList<UndirectedGraphNode>(); 
    	 } 
}
 public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        q.add(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> labels = new HashMap<Integer, UndirectedGraphNode>();
        labels.put(copy.label, copy);
        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode copycur = labels.get(cur.label);
            Iterator<UndirectedGraphNode> iter = cur.neighbors.iterator();
            while(iter.hasNext()){
                UndirectedGraphNode tmp = iter.next();
                if(!labels.containsKey(tmp.label)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(tmp.label);
                    copycur.neighbors.add(newNode);
                    labels.put(tmp.label, newNode);
                    q.add(tmp);
                }
                else{
                    copycur.neighbors.add(labels.get(tmp.label));
                }
            }

        }
        return copy;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
