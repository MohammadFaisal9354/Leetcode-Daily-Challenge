class ParkingSystem {
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;
    public ParkingSystem(int big, int medium, int small) {
        bigSlots = big;
        mediumSlots = medium;
        smallSlots = small;  
    }
    
    public boolean addCar(int carType) {
         if (carType == 1 && bigSlots > 0) {
            bigSlots--;
            return true;
        } else if (carType == 2 && mediumSlots > 0) {
            mediumSlots--;
            return true;
        } else if (carType == 3 && smallSlots > 0) {
            smallSlots--;
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
