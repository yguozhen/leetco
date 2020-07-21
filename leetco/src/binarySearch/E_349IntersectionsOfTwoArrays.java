package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class E_349IntersectionsOfTwoArrays {
    //solution1 sort two array O(mlogm + nlogn)
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, index = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                if(index == 0 || temp[index - 1] != nums1[i]){
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] result = new int[index];
        for(int k = 0; k < index; k++){
            result[k] = temp[k];
        }
        return result;
    }
    //solution2 hashset
    //O(m + n)
    public int[] intersection2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return null;
        }
        HashSet<Integer> temp = new HashSet<>();
        for(int i = 0; i < nums1.length; i ++){
            if(!temp.contains(nums1[i])){
                temp.add(nums1[i]);
            }
        }
        HashSet<Integer> res = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(!res.contains(nums2[i]) && temp.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];
        int index = 0;
        for(int num : res){
            result[index++] = num;
        }
        return result;
    }

    //solution3 sort and binary search
    //O(nlogm)
    public int[] intersection3(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null ){
            return null;
        }
        Arrays.sort(nums1);
        HashSet<Integer> temp = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(temp.contains(nums2[i])){
                continue;
            }
            if(binarySearch(nums2[i], nums1)){
                temp.add(nums2[i]);
            }
        }
        int index = 0;
        int[] res = new int[temp.size()];
        for(int num : temp){
            res[index++] = num;
        }
        return res;
    }
    private boolean binarySearch(int target, int[] temp){
        if(temp == null || temp.length == 0){
            return false;
        }
        int left = 0;
        int right = temp.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(temp[mid] == target){
                return true;
            }
            if(temp[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(temp[left] == target){
            return true;
        }
        if(temp[right] == target){
            return true;
        }
        return false;
    }
}
