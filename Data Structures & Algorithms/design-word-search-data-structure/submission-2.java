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
                
                for(Map.Entry<Character,TrieNode> entry : curr.child.entrySet())
                    if(dfs(i+1,word,entry.getValue()))
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
