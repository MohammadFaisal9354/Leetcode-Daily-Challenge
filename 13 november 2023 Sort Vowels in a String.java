class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> vowels=new ArrayList<>();
        ArrayList<Integer> position=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
            {
                vowels.add(ch);
                position.add(i);
            }
        }
        Collections.sort(vowels);
        char result[]=s.toCharArray();
        for(int i=0;i<position.size();i++)        
            result[position.get(i)]=vowels.get(i);
        return new String(result);
    }
}
