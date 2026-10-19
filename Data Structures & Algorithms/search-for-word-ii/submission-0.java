class TrieNode{
    HashMap<Character,TrieNode> childern= new HashMap<>();
    boolean isWord = false;

    public void addWord(String word){
        TrieNode curr = this;
        for(char c : word.toCharArray()){
            curr = curr.childern.computeIfAbsent(c,k->new TrieNode());
        }
        curr.isWord = true; 
    }
}

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String w : words)
            root.addWord(w);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board,root,i,j,"");
            }
        }
        return res;
    }

    public void dfs(char[][] board,TrieNode root,int r,int c,String word){
        if(r < 0 || c < 0 || r == board.length || c == board[0].length ||
            !root.childern.containsKey(board[r][c]) ||
            board[r][c] == '*')
            return;

        char temp = board[r][c];
        board[r][c] = '*'; 
        word += temp;
        TrieNode curr = root.childern.get(temp);
        if(curr.isWord){
            res.add(word);
            curr.isWord = false;
        }

        dfs(board,curr,r+1,c,word);
        dfs(board,curr,r-1,c,word);
        dfs(board,curr,r,c+1,word);
        dfs(board,curr,r,c-1,word);

        board[r][c] = temp;        

    }
}
