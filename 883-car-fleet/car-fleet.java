class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int cars[][] = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Stack<Double> st = new Stack<>();
        st.push((target - cars[0][0]) / (double)cars[0][1]);
        for(int i = 1 ; i < n ; i++) {
            double time = (target - cars[i][0]) / (double)cars[i][1];
            if(time > st.peek())
                st.push(time);
        }

        return st.size();
    }
}