public class Solution {
    public String decodeAtIndex(String inputString, int k) {
        long decodedLength = 0; 
        for (char character : inputString.toCharArray()) {
            if (Character.isDigit(character)) 
                decodedLength *= (character - '0');
            else 
                decodedLength++;            
        }
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char currentChar = inputString.charAt(i);
            if (Character.isDigit(currentChar)) {
                decodedLength /= (currentChar - '0');
                k %= decodedLength;
            } else {
                if (k == 0 || decodedLength == k) 
                    return String.valueOf(currentChar);                 
                decodedLength--;
            }
        }
        return "";
    }
}
