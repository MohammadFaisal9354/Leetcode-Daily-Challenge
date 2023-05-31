class UndergroundSystem {
    private final Map<Integer, Pair<String, Integer>> customers;
    private final Map<String, int[]> stationsDistance;

    public UndergroundSystem() {
        this.customers = new HashMap<>();
        this.stationsDistance = new HashMap<>();
    }
    
    public void checkIn(final int id, final String stationName, final int t) {
        this.customers.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(final int id, final String stationName, final int t) {
        final Pair<String, Integer> customer = this.customers.get(id);

        this.stationsDistance.putIfAbsent(customer.getKey() + "-" + stationName, new int[2]);

        final int[] sum = this.stationsDistance.get(customer.getKey() + "-" + stationName);

        sum[0] += t - customer.getValue();
        sum[1]++;

        this.customers.remove(id);
    }
    
    public double getAverageTime(final String startStation, final String endStation) {
        final int[] sum = this.stationsDistance.get(startStation + "-" + endStation);

        return (double) sum[0] / sum[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
