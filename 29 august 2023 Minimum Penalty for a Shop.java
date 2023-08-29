class Solution {
    public int bestClosingTime(String customers) {
        int[][] penalty = new int[customers.length()+1][2];
        int no = 0;
        for (int i = 0; i < customers.length(); i++) {
            penalty[i][0] = no;
            if(customers.charAt(i) == 'N') no++;
        }
        int yes = 0;
        for (int i = customers.length()-1; i >= 0; i--) {
            if(customers.charAt(i) == 'Y') yes++;
            penalty[i][1] = yes;
        }
        penalty[customers.length()][0] = no;
        penalty[customers.length()][1] = 0;
        int mn = customers.length()+1;
        int ii = -1;
        for (int i = 0; i <= customers.length(); i++) {
            System.out.println(penalty[i][0] + " " + penalty[i][1]);
            if(mn > penalty[i][0] + penalty[i][1]){
                mn = penalty[i][0] + penalty[i][1];
                ii = i;
            }
        }
        return ii;
    }
}
