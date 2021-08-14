package `in`.minbox.alphatrie

import `in`.minbox.Trie
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

internal class CaseInsensitiveAlphaTrieTest {

    @Test
    fun add() {
        val trie: Trie = CaseInsensitiveAlphaTrie()
        trie.add("cat")
        trie.add("dog")
        trie.add("catch")

        val actualRetrieved = trie.findAllStrings()
        assertEquals(3, actualRetrieved.size)
        assertContentEquals(arrayListOf("cat", "catch", "dog"), actualRetrieved)
    }


    @Test
    fun findShortestPrefix() {
        val trie: Trie = CaseInsensitiveAlphaTrie()
        trie.add("cat")
        trie.add("dog")
        trie.add("catch")

        assertTrue(trie.findShortestPrefix("c").isEmpty)

        val actual = trie.findShortestPrefix("caterpillar")
        assertFalse(actual.isEmpty)
        assertEquals("cat", actual.get())

        val actual2 = trie.findShortestPrefix("doggie")
        assertFalse(actual2.isEmpty)
        assertEquals("dog", actual2.get())
    }
}