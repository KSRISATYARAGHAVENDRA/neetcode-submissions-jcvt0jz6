class Solution {
    public int evalRPN(String[] tokens) {
        List<String> tokenlist = new ArrayList<>(Arrays.asList(tokens));

        while(tokenlist.size() > 1){
            for(int i = 0; i < tokenlist.size(); i++){
                String s = tokenlist.get(i);
                
                if("+-*/".contains(s)){
                    int a = Integer.parseInt(tokenlist.get(i - 2));
                    int b = Integer.parseInt(tokenlist.get(i - 1));
                    int res = 0;
                    
                    if(s.equals("+")){
                        res = a + b;
                    }
                    else if(s.equals("-")){
                        res = a - b;
                    }
                    else if(s.equals("*")){
                        res = a * b;
                    }
                    else if(s.equals("/")){
                        res = a / b;
                    }
                    tokenlist.set(i - 2, String.valueOf(res));
                    tokenlist.remove(i);
                    tokenlist.remove(i - 1);
                    break;
                }
                else{
                    continue;
                }
            }
        }
        return Integer.parseInt(tokenlist.get(0));  
    }
}
