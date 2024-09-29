package test

import main.groupAnagrams
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class AnagramsGrouperTest {
    @Test
    fun threeGroupsAllLowerCase() {
        val anagrams = groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat",
            "bat"))
        assertEquals(3, anagrams.size)
        assertTrue(anagrams.containsValue(listOf("eat", "tea", "ate")))
        assertTrue(anagrams.containsValue(listOf("tan", "nat")))
        assertTrue(anagrams.containsValue(listOf("bat")))
    }
    @Test
    fun threeGroupsSomeUpperCase() {
        val anagrams = groupAnagrams(listOf("eat", "tEa", "Tan", "atE", "NAT", "bat"))
        assertEquals(3, anagrams.size)
        assertTrue(anagrams.containsValue(listOf("eat", "tea", "ate")))
        assertTrue(anagrams.containsValue(listOf("tan", "nat")))
        assertTrue(anagrams.containsValue(listOf("bat")))
    }
    @Test
    fun validOneGroup() {
        val anagrams = groupAnagrams(listOf("eat"))
        assertEquals(1, anagrams.size)
        assertTrue(anagrams.containsValue(listOf("eat")))
    }
    @Test
    fun noGroup() {
        val anagrams = groupAnagrams(emptyList<String>())
        assertEquals(0, anagrams.size)
    }
}
