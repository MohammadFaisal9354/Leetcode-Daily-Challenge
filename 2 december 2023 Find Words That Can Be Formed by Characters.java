class Solution {
  public int countCharacters(String[] words, String chars) {
    var map = new int[26];
    var sum = 0;
    for (var c : chars.toCharArray()) map[c - 'a']++;

    for (var word : words) {
      var map2 = map.clone();
      var valid = true;

      for (var c : word.toCharArray()) {
        if (--map2[c - 'a'] < 0) {
          valid = false;
          break;
        }
      }
      if (valid) sum += word.length();
    }
    return sum;
  }
}
