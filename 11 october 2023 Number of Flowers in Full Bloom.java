class Solution {
    public static int[] fullBloomFlowers(int[][] F, int[] P) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int[] T : F) {
            tm.put(T[0], tm.getOrDefault(T[0], 0) + 1);
            tm.put(T[1]+1, tm.getOrDefault(T[1]+1, 0) - 1);
        }
        int sum = 0;
        for(int t : tm.keySet()) {
            sum += tm.get(t);
            tm.put(t, sum);
        }        
        int[] res = new int[P.length];
        for(int i=0; i<P.length; i++) {
            Integer val = tm.floorKey(P[i]);
            if(val != null)
                res[i] = tm.get(val);
        }    
        return res;
    }
}
