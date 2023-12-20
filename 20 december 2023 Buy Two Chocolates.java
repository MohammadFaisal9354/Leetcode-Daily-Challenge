public class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int price = prices[0] + prices[1];
        if (price <= money) 
            return money - price;
        return money;
    }
}
