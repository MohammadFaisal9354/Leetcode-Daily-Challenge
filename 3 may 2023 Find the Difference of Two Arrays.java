class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<nums1.length;i++){
            s1.add(nums1[i]);
        }
        for(int i =0;i<nums2.length;i++){
            s2.add(nums2[i]);
        }
        Set<Integer> ans1 = new HashSet<>();
        Set<Integer> ans2 = new HashSet<>();

        for(int i =0;i<nums2.length;i++){
            if(!s1.contains(nums2[i])) ans1.add(nums2[i]);
        } 
        for(int i =0;i<nums1.length;i++){
            if(!s2.contains(nums1[i])) ans2.add(nums1[i]);
        }
        List<Integer> list1 = new ArrayList<>(ans2);
        List<Integer> list2 = new ArrayList<>(ans1);
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
