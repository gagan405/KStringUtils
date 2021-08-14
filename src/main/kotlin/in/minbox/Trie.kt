package `in`.minbox

import java.util.Optional

interface Trie {
    fun add(s: String)

    fun remove(s: String)

    fun findAllPrefixes(s: String): List<String>

    fun findShortestPrefix(s: String): Optional<String>

    fun findAllStrings(): List<String>
}