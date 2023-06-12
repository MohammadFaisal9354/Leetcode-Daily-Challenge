class Solution {
  public List<String> summaryRanges(int[] nums) {
    int start, end, n = nums.length, i = 0;
    var ans = new ArrayList<String>();
    while (i<n) {
      for (start = end = nums[i]; i<n && end == nums[i]; i++, end++);
      ans.add(
        end == start + 1
          ? "" + start
          : String.format("%d->%d", start, end-1));
    }
    return ans;
  }
}
