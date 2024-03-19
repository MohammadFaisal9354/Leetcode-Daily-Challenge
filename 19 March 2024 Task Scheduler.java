class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] count = new int[26];
    for (final char task : tasks)
        ++count[task - 'A'];
    final int maxFreq = Arrays.stream(count).max().getAsInt();
    final int maxFreqTaskOccupy = (maxFreq - 1) * (n + 1);
    final int nMaxFreq = (int) Arrays.stream(count).filter(c -> c == maxFreq).count();
    return Math.max(maxFreqTaskOccupy + nMaxFreq, tasks.length);
  }
}
