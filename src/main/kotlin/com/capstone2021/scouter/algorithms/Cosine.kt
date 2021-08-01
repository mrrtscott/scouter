package com.capstone2021.scouter.algorithms

import org.hibernate.annotations.Immutable

@Immutable
class Cosine : ShingleBased, NormalizedStringDistance, NormalizedStringSimilarity {
    /**
     * Implements Cosine Similarity between strings. The strings are first
     * transformed in vectors of occurrences of k-shingles (sequences of k
     * characters). In this n-dimensional space, the similarity between the two
     * strings is the cosine of their respective vectors.
     *
     * @param k
     */
    constructor(k: Int) : super(k) {}

    /**
     * Implements Cosine Similarity between strings. The strings are first
     * transformed in vectors of occurrences of k-shingles (sequences of k
     * characters). In this n-dimensional space, the similarity between the two
     * strings is the cosine of their respective vectors. Default k is 3.
     */
    constructor() : super() {}

    /**
     * Compute the cosine similarity between strings.
     *
     * @param s1 The first string to compare.
     * @param s2 The second string to compare.
     * @return The cosine similarity in the range [0, 1]
     * @throws NullPointerException if s1 or s2 is null.
     */
    override fun similarity(s1: String?, s2: String?): Double {
        if (s1 == null) {
            throw NullPointerException("s1 must not be null")
        }
        if (s2 == null) {
            throw NullPointerException("s2 must not be null")
        }
        if (s1 == s2) {
            return 1.0
        }
        if (s1.length < k || s2.length < k) {
            return 0.0
        }
        val profile1 = getProfile(s1)
        val profile2 = getProfile(s2)
        return (dotProduct(profile1, profile2)
                / (norm(profile1) * norm(profile2)))
    }

    /**
     * Return 1.0 - similarity.
     *
     * @param s1 The first string to compare.
     * @param s2 The second string to compare.
     * @return 1.0 - the cosine similarity in the range [0, 1]
     * @throws NullPointerException if s1 or s2 is null.
     */
    override fun distance(s1: String?, s2: String?): Double {
        return 1.0 - similarity(s1, s2)
    }

    /**
     * Compute similarity between precomputed profiles.
     *
     * @param profile1
     * @param profile2
     * @return
     */
    fun similarity(
        profile1: Map<String, Int>,
        profile2: Map<String, Int>
    ): Double {
        return (dotProduct(profile1, profile2)
                / (norm(profile1) * norm(profile2)))
    }

    companion object {
        /**
         * Compute the norm L2 : sqrt(Sum_i( v_i²)).
         *
         * @param profile
         * @return L2 norm
         */
        private fun norm(profile: Map<String, Int>): Double {
            var agg = 0.0
            for ((_, value) in profile) {
                agg += 1.0 * value * value
            }
            return Math.sqrt(agg)
        }

        private fun dotProduct(
            profile1: Map<String, Int>,
            profile2: Map<String, Int>
        ): Double {

            // Loop over the smallest map
            var small_profile = profile2
            var large_profile = profile1
            if (profile1.size < profile2.size) {
                small_profile = profile1
                large_profile = profile2
            }
            var agg = 0.0
            for ((key, value) in small_profile) {
                val i = large_profile[key] ?: continue
                agg += 1.0 * value * i
            }
            return agg
        }
    }
}