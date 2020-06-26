package binarySearch;

public class E_350IntersectionsOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<Integer>();
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2] && (res.size() == 0 || res.get(res.size() - 1) != nums1[index1])){
                res.add(nums1[index1]);
                index1 ++;
                index2 ++;
            }else if(nums1[index1] == nums2[index2]){
                res.add(nums1[index1]);
                index1 ++;
                index2 ++;

            }else if(nums1[index1] < nums2[index2]){
                index1 ++;
            }else if(nums1[index1] > nums2[index2]){
                index2 ++;
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i ++){
            result[i] = res.get(i);
        }
        return result;

    }
}
