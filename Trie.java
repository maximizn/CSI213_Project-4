import java.util.LinkedList;

public class Trie {
    // Maximum number of children for each node
    private final int children_Max = 26;
    // Root node of the trie
    public TrieNode root;
    // Maximum length of strings to be inserted into the trie
    private int depth;

    /**
     * Constructor for the Trie class
     * @param depth Maximum length of strings being inserted into the trie
     */
    public Trie(int depth) {
        root = new TrieNode();
        this.depth = depth;
    }
    /**
     * This method inserts a string into the trie
     * if string is null or empty, or if string is longer than the maximum length, return false
     * @param val String being inserted
     * @return true if insertion is successful, false otherwise
     */
    public boolean insert(String val) {
        if (val == null || val.isEmpty() || val.length() > depth) {
            return false;
        }
        return root.insert(val);
    }

    /**
     * This method checks if a string exists in the trie
     * if string is null or empty, or if string is longer than the maximum length, return false
     * @param val String being checked
     * @return true if the string exists in the trie, false otherwise
     */
    public boolean exists(String val) {
        if (val == null || val.isEmpty() || val.length() > depth) {
            return false;
        }
        return root.exists(val);
    }
    /**
     * Inner class representing a node in the trie
     */
    public class TrieNode{
        // Array of children nodes
        public TrieNode[] children;
        // True if this node represents the end of a word
        public boolean isWord;


        /**
         * Constructor for the TrieNode class
         */
        public TrieNode() {
            children = new TrieNode[children_Max];
            isWord = false;
        }

        /**
         * This method inserts a string into the trie starting from this node
         * @param val String being inserted
         * @return true if insertion is successful, false otherwise
         */
            public boolean insert(String val){
                // If the string is empty or longer than the maximum allowed depth, return false
                if (val.isEmpty() || val.length() > depth) {
                    // If this node represents a complete word already, return false
                    if (isWord) {
                        return false;
                    }
                    // Otherwise, set isWord to true and return true
                    else {
                        isWord = true;
                        return true;
                    }
                }
                // If the string is not empty and is shorter than or equal to the maximum allowed depth
                else {
                    // Get the first character of the string
                    char c = val.charAt(0);
                    // Get the index of the character in the alphabet
                    int index = c - 'a';
                    // If the children array is null, create a new array
                    if (children == null) {
                        children = new TrieNode[children_Max];
                    }
                    // If the child node at the index is null, create a new node
                    if (children[index] == null) {
                        children[index] = new TrieNode();
                    }
                    // If the string is longer than the maximum depth, create a new LeafNode to store the remaining characters
                    if (val.length() > depth) {
                        // Create a new LeafNode to store the remaining characters
                        LeafNode leafNode = new LeafNode();
                        leafNode.insert(val.substring(depth));
                        // Set the child node at the index to the new LeafNode
                        children[index] = leafNode;
                        // Mark the node as a complete word
                        children[index].isWord = true;
                        return true;
                    }
                    // Recursively inserts the rest of the string into the trie starting from the child node
                    return children[index].insert(val.substring(1));
                }
            }





                /**
                 * This method checks if a string exists in the trie starting from this node
                 * @param val String to be checked
                 * @return true if the string exists in the trie, false otherwise
                 */
        public boolean exists(String val) {
            // If the string is empty
            if (val.isEmpty()) {
                // Return true if this node represents a complete word
                return isWord;
            } else {
                // Get the first character of the string
                char c = val.charAt(0);
                int index = c - 'a';
                // If the children array is null or the child node at the index is null, return false
                if (children == null || children[index] == null) {
                    return false;
                } else {
                    // Recursively check if the rest of the string exists in the trie starting from the child node
                    return children[index].exists(val.substring(1));
                }
            }
        }
    }


    /**
     * Inner class representing a leaf node in the trie
     */
    public class LeafNode extends TrieNode {
        // LinkedList initialized to store words
        LinkedList<String> words;

        /**
         * Constructor for the LeafNode class
         */
        public LeafNode() {
            words = new LinkedList<>();
        }

        /**
         * This method is overrided from TrieNode class that inserts a word to the LinkedList
         * @param val String being inserted
         * @return true if insertion is successful, false otherwise
         */

        public boolean insert(String val) {
            words.add(val);
            return true;
        }

        /**
         * This method is overrided from TrieNode class that checks if a word exists in the LinkedList
         * @param val String being checked
         * @return true if the string exists in the LinkedList, false otherwise
         */
        @Override
        public boolean exists(String val) {
            return words.contains(val);
        }
    }
}
