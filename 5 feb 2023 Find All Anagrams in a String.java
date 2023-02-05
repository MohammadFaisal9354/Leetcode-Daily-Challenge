	class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int m = p.length();
			if(m>n){
                return ans;
            }
			int []arrs = new int[26];
			int []arrp = new int[26];
			for(int i=0;i<m;i++){
				arrs[s.charAt(i)-'a']++;
				arrp[p.charAt(i)-'a']++;
			}
			for(int i=0;i<=n-m;i++){
				boolean flag = true;
				for(int j=0;j<26;j++){
					if(arrs[j]!=arrp[j]){
						flag = false;
						break;
					}
				}
				if(flag==true){
                    ans.add(i);
                }
				arrs[s.charAt(i)-'a']--;
				if(i+m < n){
                    arrs[s.charAt(i+m)-'a']++;
                }
			}
			return ans;
		}
	}
