class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;

        Set<String> set = new HashSet<>(wordList);
        int res = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()) {
            int level = q.size();
            for(int k = 0 ; k < level ; k++) {
                String curr = q.poll();
                char chars[] = curr.toCharArray();
                for(int i = 0 ; i < chars.length ; i++) {
                    char og = chars[i];
                    for(char c = 'a' ; c <= 'z' ; c++) {
                        if(c == og)
                            continue;
                        chars[i] = c;
                        String word = new String(chars);
                        if(set.contains(word)) {
                            if(word.equals(endWord))
                                return res + 1;
                            q.offer(word);
                            set.remove(word);
                        }
                    }
                    chars[i] = og;
                }
            }
            res++;
        }

        return 0;
    }
}