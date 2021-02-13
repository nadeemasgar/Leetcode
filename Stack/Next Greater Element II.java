class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ngr = new int[nums.length];
        Arrays.fill(ngr, -1);

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < nums.length; i++) {

            int val = nums[i];
            while (st.size() > 0  && nums[st.peek()] < val) {
                int idx = st.pop();
                ngr[idx] = nums[i];
            }

            st.push(i);
        }

        int maxElement = Integer.MIN_VALUE ;

        for (int i = 0; i < nums.length && st.size() > 0; i++) {

            maxElement = Math.max(maxElement, nums[i]);

            while (st.size() > 0 && nums[st.peek()] < maxElement) {
                int idx = st.pop();
                ngr[idx] = maxElement;
            }
        }

        return ngr;

    }
}