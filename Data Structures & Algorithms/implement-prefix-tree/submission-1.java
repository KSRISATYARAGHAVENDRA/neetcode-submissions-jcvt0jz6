class TrieNode
{
    Map<Character,TrieNode> childern = new HashMap<>();
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
            curr.childern.putIfAbsent(word.charAt(i),new TrieNode());
            curr = curr.childern.get(word.charAt(i));
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(curr.childern.get(word.charAt(i)) == null){
                return false;
            }
            curr = curr.childern.get(word.charAt(i));
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curr.childern.get(prefix.charAt(i)) == null){
                return false;
            }
            curr = curr.childern.get(prefix.charAt(i));
        }
        return true;
    }
}
