class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ngr = new int[T.length];
        Arrays.fill(ngr, 0);

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < T.length; i++) {
            int val = T[i];
            while (st.size() > 0 && T[st.peek()] < val) {
                int idx = st.pop();
                ngr[idx] = i - idx;
            }

            st.push(i);
        }

        return ngr;
    }
}