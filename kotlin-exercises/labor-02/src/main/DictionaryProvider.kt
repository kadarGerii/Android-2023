package main

class DictionaryProvider {
    companion object {
        private var listDictionaryInstance: ListDictionary? = null
        private var hashSetDictionaryInstance: HashSetDictionary? = null
        private var treeSetDictionaryInstance: TreeSetDictionary? = null

        fun createDictionary(dictionaryType: DictionaryType): IDictionary? {
            return when (dictionaryType) {
                DictionaryType.ARRAY_LIST -> {
                    if (listDictionaryInstance == null) {
                        listDictionaryInstance = ListDictionary()
                    }
                    listDictionaryInstance
                }

                DictionaryType.HASH_SET -> {
                    if (hashSetDictionaryInstance == null) {
                        hashSetDictionaryInstance = HashSetDictionary()
                    }
                    hashSetDictionaryInstance
                }

                DictionaryType.TREE_SET -> {
                    if (treeSetDictionaryInstance == null) {
                        treeSetDictionaryInstance = TreeSetDictionary()
                    }
                    treeSetDictionaryInstance
                }
            }
        }
    }
}