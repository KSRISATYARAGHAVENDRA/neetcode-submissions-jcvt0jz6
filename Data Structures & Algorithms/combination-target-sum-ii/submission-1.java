class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(0 , target ,new ArrayList<>(), candidates);
        
        return res;
        
    }
    void backtrack(int idx ,int target ,List<Integer> cur ,int[] candidates){
        
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            
            if(i > idx && candidates[i-1] == candidates[i]){
                continue;
            }

            if(target - candidates[i] < 0){
                break;
            }
            cur.add(candidates[i]);
            backtrack(i + 1 ,target - candidates[i] ,cur ,candidates);
            cur.remove(cur.size() - 1);
        }
           
    }
}
