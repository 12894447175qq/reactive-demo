package com.hyl.reactivedemo.recall;

import java.util.*;

/**
 * <p> </p>
 *
 * @author hyl.c
 * @date {2023/4/3}
 */
class Solution {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();

        Solution solution = new Solution();
        solution.findSubsequences(new int[]{4,4,1,1});
    }

    private void backtrack(int[] nums, int start) {
        if (path.size() > 1) {
            ans.add(new ArrayList<>(path));
        }

        if (start >= nums.length) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            int num = nums[i];
            if (map.getOrDefault(num, 0) >= 1) {
                continue;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);

            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}