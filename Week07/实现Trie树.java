class Trie {
    private boolean isEnd;

    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null && word.length() == 0)
        {
            return;
        }
        char[] words = word.toCharArray();
        Trie cur = this;
        for(char c : words)
        {
            int index = c - 'a';
            Trie tmp = cur.next[index];
            if(tmp == null)
            {
                cur.next[index] = new Trie();
            }
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie target = innerSearch(word);
        return target != null && target.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         Trie target = innerSearch(prefix);
        return target != null;
    }

    private Trie innerSearch(String target)
    {
        char[] words = target.toCharArray();
        Trie cur = this;
        for(char c :words)
        {
            int index = c - 'a';
            cur = cur.next[index];
            if(cur == null)
            {
                return null;
            }
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */