class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> seenA = new HashSet<>();
        HashSet<Integer> seenB = new HashSet<>();
        int C[] = new int[A.length];
        int cnt = 0;
        for(int i = 0 ; i < A.length ; i++) {
            seenA.add(A[i]);
            seenB.add(B[i]);
            if(A[i] == B[i])
                cnt++;
            else {
                if(seenB.contains(A[i]))
                    cnt++;
                if(seenA.contains(B[i]))
                    cnt++;
            }
            C[i] = cnt;
        }
        return C;
    }
}