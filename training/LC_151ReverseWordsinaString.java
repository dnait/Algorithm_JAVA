151. Reverse Words in a String
For example,
Given s = "the sky is blue",
return "blue is sky the".

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.length() < 1) return s;
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >=0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i] + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
        
    }
}

//
public class Solution {
  public String reverseWords(String input) {
    assert input != null;
    char[] array = input.toCharArray();
    // reverse the whole char array first
    reverse(array, 0, array.length - 1);
    int start = 0;
    // reverse each of the words
    for (int i = 0; i < array.length; i++) {
      // the start index of a word
      if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
        start = i;
      }
      // the end index of a word
      if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
        reverse(array, start, i);
      }
    }
    return new String(array);
  }
