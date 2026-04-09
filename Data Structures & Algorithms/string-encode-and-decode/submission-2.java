class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(String.format("%4d",str.length())).append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int len = Integer.parseInt(str.substring(i , i + 4).trim());;
            result.add(str.substring(i + 4 , i + 4 + len));
            i = i + 4 + len;
        }
        return result;
    }
    /*private int getInt(String s ,int idx){
        return Integer.parseInt(s.substring(idx , idx + 4).trim());
    }*/
}
