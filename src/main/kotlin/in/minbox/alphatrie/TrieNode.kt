package `in`.minbox.alphatrie

class TrieNode(char: Char) {
    val char: Char = char
    var isWord: Boolean = false

    private var children: Array<TrieNode?> = Array(26, { x -> null })

    fun addNode(char: Char) {
        children[char - 'a'] = TrieNode(char)
    }

    fun getNode(char: Char): TrieNode? {
        return children[char - 'a']
    }

    fun getChildren(): List<TrieNode> {
        return children.filterNotNull().toList()
    }

}