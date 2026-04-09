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

        for(int i = 0; i < str.length(); i += 4 + getInt(str ,i)){
            int len = getInt(str ,i);
            result.add(str.substring(i + 4 , i + 4 + len));
        }
        return result;
    }
    private int getInt(String s ,int idx){
        return Integer.parseInt(s.substring(idx , idx + 4).trim());
    }
}
