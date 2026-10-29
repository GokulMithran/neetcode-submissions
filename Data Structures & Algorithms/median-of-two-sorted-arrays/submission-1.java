class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int m = n1 + n2;
        int[] merged = new int[m];
        System.arraycopy(nums1, 0, merged, 0, n1);
        System.arraycopy(nums2, 0, merged, n1, n2);

        Arrays.sort(merged);

        if (m % 2 != 0){
            return merged[m/2];
        }

        return (merged[(m-1)/2] + merged[m/2]) / 2.0;
    }
}
