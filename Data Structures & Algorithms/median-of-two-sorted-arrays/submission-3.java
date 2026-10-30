class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int m = n1 + n2;

        int counter = 0;

        int i = 0;
        int j = 0;

        int prev = 0;
        int curr = 0;

        int mid = m / 2;

        for (int count = 0; count <= mid; count++) {
            prev = curr;

            if (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    curr = nums1[i];
                    i++;
                } else {
                    curr = nums2[j];
                    j++;
                }
            } else if (i < n1) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
        }

        if (m % 2 != 0) {
            return curr;
        }
        return ((double) prev + curr) / 2;
    }
}
