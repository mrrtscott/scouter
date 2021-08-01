package com.capstone2021.scouter.algorithms

import com.capstone2021.scouter.algorithms.ShingleBased
import org.hibernate.annotations.Immutable
import java.lang.IllegalArgumentException
import java.util.*
import java.util.regex.Pattern

@Immutable
abstract class ShingleBased(k: Int) {
    /**
     * Return k, the length of k-shingles (aka n-grams).
     *
     * @return The length of k-shingles.
     */
    val k: Int

    /**
     *
     */
    internal constructor() : this(DEFAULT_K) {}

    /**
     * Compute and return the profile of s, as defined by Ukkonen "Approximate
     * string-matching with q-grams and maximal matches".
     * https://www.cs.helsinki.fi/u/ukkonen/TCS92.pdf The profile is the number
     * of occurrences of k-shingles, and is used to compute q-gram similarity,
     * Jaccard index, etc. Pay attention: the memory requirement of the profile
     * can be up to k * size of the string
     *
     * @param string
     * @return the profile of this string, as an unmodifiable Map
     */
    fun getProfile(string: String?): Map<String, Int> {
        val shingles = HashMap<String, Int>()
        val string_no_space = SPACE_REG.matcher(string).replaceAll(" ")
        for (i in 0 until string_no_space.length - k + 1) {
            val shingle = string_no_space.substring(i, i + k)
            val old = shingles[shingle]
            if (old != null) {
                shingles[shingle] = old + 1
            } else {
                shingles[shingle] = 1
            }
        }
        return Collections.unmodifiableMap(shingles)
    }

    companion object {
        private const val DEFAULT_K = 3

        /**
         * Pattern for finding multiple following spaces.
         */
        private val SPACE_REG = Pattern.compile("\\s+")
    }

    /**
     *
     * @param k
     * @throws IllegalArgumentException if k is &lt;= 0
     */
    init {
        require(k > 0) { "k should be positive!" }
        this.k = k
    }
}