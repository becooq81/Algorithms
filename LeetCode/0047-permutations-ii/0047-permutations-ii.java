class Solution {
    static List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        genPerm(0, nums.length, new boolean[nums.length], new ArrayList<Integer>(), nums);
        return result;
    }

    private void genPerm(int depth, int N, boolean[] visited, List<Integer> tmp, int[] nums) {
        if (depth == N) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            
            if (visited[i] || (i > 0 && nums[i]==nums[i-1] && !visited[i-1])) continue;

            visited[i] = true;
            tmp.add(nums[i]);
            genPerm(depth + 1, N, visited, tmp, nums);
            tmp.remove(tmp.size()-1);
            visited[i] = false;
        }
    } 
}