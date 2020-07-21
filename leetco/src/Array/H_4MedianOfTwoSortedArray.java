package Array;

public class H_4MedianOfTwoSortedArray {
    //solution1 find the smaller element in k / 2 and delete the range before it
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        if(k % 2 == 1){
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, k/2 + 1);
        }else{
            int left = findKth(nums1, 0, m - 1, nums2, 0, n - 1, k/2);
            int right = findKth(nums1, 0, m - 1, nums2, 0, n - 1, k/2 + 1);
            return (left + right)/2.0;
        }
    }

    private int findKth(int[] a, int start1, int end1, int[] b, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if(len1 > len2){
            return findKth(b, start2, end2, a, start1, end1, k);
        }
        if(len1 == 0){
            return b[start2 + k - 1];
        }
        if(k == 1){
            return Math.min(a[start1], b[start2]);
        }
        int i = start1 + Math.min(k/2, len1) - 1;
        int j = start2 + Math.min(k/2, len2) - 1;
        if(a[i] > b[j]){
            return findKth(a, start1, end1, b, j + 1, end2, k - (j - start2 + 1));
        }else{
            return findKth(a, i + 1, end1, b, start2, end2, k - (i - start1 + 1));
        }
    }
}
