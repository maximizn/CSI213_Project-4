import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests{

    @Test
    public void testInsertExists() {
        Trie trie = new Trie(5);
        System.out.println("Inserting 'hello' into trie: " + trie.insert("hello"));
        System.out.println("Inserting 'world' into trie: " + trie.insert("world"));
        System.out.println("Inserting 'hello' into trie again: " + trie.insert("hello"));
        System.out.println("Inserting 'world' into trie again: " + trie.insert("world"));
        System.out.println("Checking if 'hello' exists in trie: " + trie.exists("hello"));
        System.out.println("Checking if 'world' exists in trie: " + trie.exists("world"));
        assertTrue(trie.exists("hello"));
        assertTrue(trie.exists("world"));
    }
@SuppressWarnings("unused")
    @Test
     public void testInsertMaxLength() {
        Trie trie = new Trie(3);
        System.out.println("Inserting 'Michael' into trie: " + trie.insert("Michael"));
        System.out.println("Inserting 'car' into trie: " + trie.insert("car"));
        assertTrue(trie.insert("bar"));
        assertTrue(trie.exists("car"));
        assertTrue(trie.exists("bar"));
    }

    @Test
    public void testInsertNull() {
        Trie trie = new Trie(0);
        assertFalse(trie.insert(null));
    }

    @Test
    public void testInsertEmpty() {
        Trie trie = new Trie(10);
        System.out.println("Inserting quotation marks into trie: " + trie.insert(""));
        assertFalse(trie.insert(""));
    }

    @Test
    public void testExistsNull() {
        Trie trie = new Trie(5);
        assertFalse(trie.exists(null));
    }

    @Test
    public void testExistsEmpty() {
        Trie trie = new Trie(10);
        System.out.println("Checking if quotation marks exist in trie: " + trie.exists(""));
        assertFalse(trie.exists(""));
    }
}

