class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = Arrays.stream(candies).max().getAsInt();        
        for (int candy : candies) 
            result.add(candy + extraCandies >= maxCandies);        
        return result;
    }
}
