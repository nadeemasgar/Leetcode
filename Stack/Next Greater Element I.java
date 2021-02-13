class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        int[] ngr = new int[nums2.length];
        Arrays.fill(ngr, -1);

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < nums2.length; i++) {

            int val = nums2[i];
            while (st.size() > 0 && nums2[st.peek()] < val) {
                int idx = st.pop();
                ngr[idx] = nums2[i];
            }

            st.push(i);
        }

        int j = 0;

        for (int i = 0; i < nums1.length; i++) {

            for (j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j])
                    break;
            }

            ans[i] = ngr[j];
        }

        return ans;
    }
}