class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> line = new ArrayList<>();
        int ctr = 0;
        int width = 0;
        while(ctr<words.length)
        {
            String word = words[ctr];
            if(word.length()+width<=maxWidth)
            {
                line.add(word);
                width+=word.length()+1;
                ctr++;
            }
            else
            {
                int spaces = maxWidth-width+line.size();
                int j = 0;
                int k = 0;
                while(k < spaces)
                {
                    if(j>=line.size()-1)
                    {
                        j = 0;
                    }
                    line.set(j,line.get(j)+" ");
                    k++;
                    j++;
                }
                String temp = "";
                for(String str: line)
                {
                    temp+=str;
                }
                result.add(temp);
                line.clear();
                width = 0;
            }
        }
        for(int i = 0;i<line.size()-1;i++)
        {
            line.set(i,line.get(i)+" ");
        }
        for(int x = 0;x<maxWidth-width+1;x++)
        {
            line.set(line.size()-1,line.get(line.size()-1)+" ");
        }
        String temp = "";
        for(String str: line)
        {
            temp+=str;
        }
        result.add(temp);
        return result;
    }
}
