class TrieNode
{
    TrieNode[] childern = new TrieNode[26];
    boolean endOfWord = false;
}
class PrefixTree {

    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.childern[index] == null){
                curr.childern[index] = new TrieNode();
            }
            curr = curr.childern[index];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.childern[index] == null){
                return false;
            }
            curr = curr.childern[index];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.childern[index] == null){
                return false;
            }
            curr = curr.childern[index];
        }
        return true;
    }
}
