package `in`.minbox.alphatrie

import `in`.minbox.Trie
import java.util.Optional

class CaseInsensitiveAlphaTrie: Trie {
    val root: TrieNode = TrieNode('*')

    override fun add(s: String) {
        var pointer = root
        for(i in s.indices) {
            if (pointer.getNode(s[i]) == null) {
                pointer.addNode(s[i])
            }
            pointer = pointer.getNode(s[i])!!
        }
        pointer.isWord = true
    }

    override fun remove(s: String) {
        TODO("Not yet implemented")
    }

    override fun findAllPrefixes(s: String): List<String> {
        TODO("Not yet implemented")
    }

    override fun findShortestPrefix(s: String): Optional<String> {
        var idx = 0
        var pointer = root
        for(ch in s) {
            val node = pointer.getNode(ch) ?: return Optional.empty()
            if (node.isWord) return Optional.of(s.substring(0, idx + 1))

            idx++
            pointer = node

        }
        return Optional.empty()
    }

    override fun findAllStrings(): List<String> {
        val result: MutableList<String> = ArrayList()

        fun getAllStrings(items: MutableList<String>, node: TrieNode, sb: StringBuilder) {
            if (node != root)
                sb.append(node.char)

            if (node.isWord) {
                items.add(sb.toString())
            }
            val length = sb.length
            for (n in node.getChildren()) {
                getAllStrings(items, n, sb)
                sb.setLength(length)
            }
        }

        getAllStrings(result, root, StringBuilder())
        return result
    }
}