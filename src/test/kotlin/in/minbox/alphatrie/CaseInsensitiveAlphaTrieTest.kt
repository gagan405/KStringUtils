package `in`.minbox.alphatrie

import `in`.minbox.Trie
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CaseInsensitiveAlphaTrieTest {

    @Test
    fun add() {
        val trie: Trie = CaseInsensitiveAlphaTrie()
        trie.add("cat")
        trie.add("dog")
        trie.add("catch")

        val actualRetrieved = trie.findAllStrings()
        assertEquals(3, actualRetrieved.size)
    }
}