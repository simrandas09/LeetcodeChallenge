class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[graph.length];

        // initialize
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        // Reversed the edges
        for(int i=0;i<graph.length;i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                // find out the indegree of the node 
                indegree[i]++;
            }
        }
        // Initialize a Queue and add the nodes with indegree 0
        Queue<Integer> qs = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) qs.offer(i);
        }

        boolean[] safe = new boolean[graph.length];
        while(!qs.isEmpty()){
            int node = qs.poll();
            // Mark the node as safe because node in the queue should always be safe
            safe[node] = true;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) qs.offer(it);
            }
        }

        for(int i=0;i<safe.length;i++){
            if(safe[i]==true) result.add(i);
        }
        return result;
       
    }
}