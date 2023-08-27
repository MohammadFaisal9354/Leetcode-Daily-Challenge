class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0;i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }        
        map.get(0).add(1);        
        for (int i = 0; i < stones.length; i++) {
            int currentStone = stones[i];
            HashSet<Integer> jumps = map.get(currentStone);       
            
            for (int jump : jumps) {
                int pos = currentStone + jump;
                if (pos == stones[stones.length - 1]) return true;
                if (map.containsKey(pos)) {
                    map.get(pos).add(jump);
                    map.get(pos).add(jump+1);
                    if (jump-1 > 0) {
                        map.get(pos).add(jump-1);
                    }
                }
            } 
        }        
        return false;
    }
}
