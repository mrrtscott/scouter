package com.capstone2021.scouter.algorithms

import java.util.*

class CompareStrings {


    /**
     * helper function to return the cost of the substitution of two characters in a string
     * @param a,
     * @param b
     * @return The cost a substitution 0 or 1
     */
    private fun costOfSubstitution(a: Char, b: Char): Int {
        return if (a == b) 0 else 1
    }

    /**
     * @param numbers
     * @return The smallest or largest value in the stream
     */
    private fun min(vararg numbers: Int): Int {
        return Arrays.stream(numbers)
            .min().orElse(Int.MAX_VALUE)
    }


    /**
     * Levenshtein Algorithm to compare Strings
     * @param x
     * @param y
     * @return The distance between y and x as an int
     */
    fun calculate(x: String, y: String): Int {
        val dp = Array(x.length + 1) { IntArray(y.length + 1) }
        for (i in 0..x.length) {
            for (j in 0..y.length) {
                if (i == 0) {
                    dp[i][j] = j
                } else if (j == 0) {
                    dp[i][j] = i
                } else {
                    dp[i][j] = min(
                        dp[i - 1][j - 1]
                                + costOfSubstitution(x[i - 1], y[j - 1]),
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1
                    )
                }
            }
        }
        return dp[x.length][y.length]
    }


}