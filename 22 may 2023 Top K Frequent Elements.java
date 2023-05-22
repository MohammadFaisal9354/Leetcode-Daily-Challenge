class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCounter = new HashMap<>();
        int maxFrequency = 0;
        for(int n : nums) {
            int frequency = freqCounter.getOrDefault(n, 0) + 1;
            freqCounter.put(n, frequency);
            maxFrequency = Math.max(frequency, maxFrequency);
        }
        List<Integer>[] test = new ArrayList[maxFrequency + 1];
        for(int n : freqCounter.keySet()) {
            int index = freqCounter.get(n);
            if(test[index] == null) {
                test[index] = new ArrayList<>();
            }
            test[index].add(n);
        }        
        int[] result = new int[k];
        int counter = 0;
        for(int i = test.length - 1; i >= 0; i--) {
            if(test[i] != null) {
                for(int n : test[i]) {
                    result[counter] = n;
                    counter++;
                    if(counter == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
