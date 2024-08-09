package tree;

class TrieNode {
    // 단어 완성 여부
    boolean word;
    // 트라이의 자식 노드들
    TrieNode[] children;
    public TrieNode() {
        // 자식 노드는 알파벳 개수 26개까지 가능
        children = new TrieNode[26];
        word = false;
    }
}