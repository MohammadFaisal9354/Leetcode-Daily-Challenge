class Solution {
public List<Integer> getRow(int rowIndex) {
    int[] prev = new int[rowIndex + 1];
    int[] res = new int[rowIndex + 1];
    prev[0] = 1; res[0] = 1;
    for(int i = 1, m; i <= rowIndex ; i++){
        m = i / 2 + 1;
        res[i] = 1;
        for(int j = 1; j < m; j++){
            res[j] = prev[j] + prev[j - 1];
            res[i - j] = res[j];
        }
        int[] temp = res;
        res = prev;
        prev = temp;
    }
    List<Integer> Res = new ArrayList<Integer>();
    for(int r : prev) Res.add(r);
    return Res;
}
}
