class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0, l = 0, r = people.length -1;
        Arrays.sort(people);
        while( l<=r ){
            if( people[l]+people[r] <= limit){
                ans++;
                l++;
            }else if( people[r] <= limit || (l == r && people[l] <= limit) ){
                ans++;
            }
            r--;
        }
        return ans ;
    }
}
