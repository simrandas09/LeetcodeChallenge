class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public void subsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<>(current));//add current subset
        for(int i=index;i<nums.length;i++){
            //skip duplicates
            if(i>index && nums[i] == nums[i-1]) continue;

            current.add(nums[i]);
            subsets(nums,i+1,current,result);
            current.remove(current.size()-1); //backtrack
        }

    }
}