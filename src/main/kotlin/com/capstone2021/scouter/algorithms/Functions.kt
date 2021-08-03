package com.capstone2021.scouter.algorithms

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.math.abs


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

        return result1 >= 0.31 && result2 <= 60


    }

    fun monthsBetween(d1: Date?, d2: Date?): Int {
        val today = LocalDateTime.now(ZoneId.of("America/Jamaica"))
        var date1 = d1
        var date2 = d2


        if (date2 == null) {
            date2 = java.sql.Timestamp.valueOf(today)
        }
        if(date1 == null){
            date1 = java.sql.Timestamp.valueOf(today)
        }


        val m_calendar = Calendar.getInstance()
        m_calendar.time = date1
        val nMonth1 = 12 * m_calendar[Calendar.YEAR] + m_calendar[Calendar.MONTH]
        m_calendar.time = date2
        val nMonth2 = 12 * m_calendar[Calendar.YEAR] + m_calendar[Calendar.MONTH]
        return abs(nMonth2 - nMonth1)
    }


}