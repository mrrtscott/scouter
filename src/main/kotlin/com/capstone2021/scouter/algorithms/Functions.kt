package com.capstone2021.scouter.algorithms

import java.util.*


class Functions {

    var cosine = Cosine()
    var compareStrings = CompareStrings()

    fun getAge(dateOfBirth: Date?): Int {
        val today = Calendar.getInstance()
        val birthDate = Calendar.getInstance()
        birthDate.time = dateOfBirth
        require(!birthDate.after(today)) { "You don't exist yet" }
        val todayYear = today[Calendar.YEAR]
        val birthDateYear = birthDate[Calendar.YEAR]
        val todayDayOfYear = today[Calendar.DAY_OF_YEAR]
        val birthDateDayOfYear = birthDate[Calendar.DAY_OF_YEAR]
        val todayMonth = today[Calendar.MONTH]
        val birthDateMonth = birthDate[Calendar.MONTH]
        val todayDayOfMonth = today[Calendar.DAY_OF_MONTH]
        val birthDateDayOfMonth = birthDate[Calendar.DAY_OF_MONTH]
        var age = todayYear - birthDateYear

        // If birthdate is greater than today's date (after 2 days adjustment of leap year) then decrement age one year
        if (birthDateDayOfYear - todayDayOfYear > 3 || birthDateMonth > todayMonth) {
            age--

            // If birthdate and today's date are of same month and birthday of month is greater than today's day of month then decrement age
        } else if (birthDateMonth == todayMonth && birthDateDayOfMonth > todayDayOfMonth) {
            age--
        }
        return age
    }

    fun matcher(input1:String?, input2:String?): Boolean{
        var result1:Double = cosine.similarity(input1, input2)
        var result2: Int = compareStrings.calculate(input1.toString(), input2.toString())

        System.out.println(input1 + " " + input2)
        System.out.println(result1.toString() + " " + result1)

        return result1 >= 0.4 && result2 <= 60


    }


}