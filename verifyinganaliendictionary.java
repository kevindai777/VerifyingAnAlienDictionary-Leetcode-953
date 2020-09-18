//Java Solution

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            
            if (map.get(word1.charAt(0)) > map.get(word2.charAt(0))) {
                return false;
            } else if (word1.charAt(0) == word2.charAt(0)) {
                int p1 = 1;
                
                while (p1 < word1.length() && p1 < word2.length() && word1.charAt(p1) == word2.charAt(p1)) {
                    p1++;
                }
                
                if (p1 == word2.length()) {
                    return false;
                }
                
                if (p1 < word1.length() && p1 < word2.length() && map.get(word1.charAt(p1)) > map.get(word2.charAt(p1))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}