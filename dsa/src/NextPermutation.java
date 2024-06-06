import java.util.ArrayList;
import java.util.List;


class NextPermutation {
    public void nextPermutationRecursion1(int[] nums, List<Integer> ds,List<List<Integer>> ans,boolean[] freq){
    if(ds.size()==nums.length) {
        ans.add(new ArrayList<>(ds));
        return;
    }
    for(int i = 0 ; i < nums.length; i++) {
        if (!freq[i]){
            freq[i]=true;
            ds.add(nums[i]);
            nextPermutationRecursion1(nums, ds, ans, freq);
            ds.remove(ds.size()-1);
            freq[i] = false;
        }


    }

    }
    public void nextPermutation(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        //nextPermutationRecursion1(nums,ds,ans,freq);
        nextPermutationRecursion2(0,nums,ans);
        System.out.println(ans);
    }

    private void nextPermutationRecursion2(int index, int[] nums, List<List<Integer>> ans) {
        if(index == nums.length ){
        List<Integer> ds = new ArrayList<>();
        for(int i = 0 ; i < nums.length;i++){
            ds.add(nums[i]);
        }
        ans.add(ds);
        return;
        }

        for(int i = index ; i < nums.length; i++){
            swap(i,index,nums);
            nextPermutationRecursion2(index+1,nums,ans);
            swap(i,index,nums);
        }
    }

    private void swap(int i, int index, int[] nums) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;

    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
       NextPermutation s = new NextPermutation();
       s.nextPermutation(nums);
    }
}