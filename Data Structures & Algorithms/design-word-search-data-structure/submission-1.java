class TrieNode{
        Map<Character,TrieNode> child = new HashMap<>();
        boolean endWord = false;
    }
class WordDictionary {
    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.child.containsKey(c))
                curr.child.put(c,new TrieNode());
            curr = curr.child.get(c);
        }
        curr.endWord = true; 
    }

    public boolean search(String word) {
        return dfs(0,word,root);
    }

    boolean dfs(int idx , String word,TrieNode root){
        TrieNode curr = root;
        for(int i = idx; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                
                for(Character key : curr.child.keySet())
                    if(dfs(i+1,word,curr.child.get(key)))
                        return true;
                return false;
            }
            else{
                if(curr.child.containsKey(ch)){
                    curr = curr.child.get(ch);
                }else{
                    return false;
                }
            }    
        }
        return curr.endWord;
    }
}
