class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1; 
        int r = m + n - 1;
        while(l >= 0) {
            nums1[r--] = nums1[l--];
        }
        int i = n;
        int j = 0;
        int k = 0;
        while(i < n + m && j < n) {
            if(nums1[i] > nums2[j]) {
                nums1[k++] = nums2[j++];
            } else {
                nums1[k++] = nums1[i++];
            }
        }
        while(i < n + m) {
            nums1[k++] = nums1[i++];
        }

        while(j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}
