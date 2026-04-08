class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> anagramlist = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < 26; i++){
                key.append(count[i]).append('#');
            }
            String keyStr = key.toString();
            List<String> list = anagramlist.get(keyStr);
            if (list == null) {
                list = new ArrayList<>();
                anagramlist.put(keyStr, list);
            }
            list.add(str);
        }
        return new ArrayList(anagramlist.values());
    }
}
