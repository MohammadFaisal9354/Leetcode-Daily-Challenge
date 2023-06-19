class Solution {
  public int largestAltitude(int[] gain) {
    int  max = 0,altitude = 0;
    for (var g : gain) {
      altitude += g;
      max = Math.max(max, altitude);
    }
    return max;
  }
}
