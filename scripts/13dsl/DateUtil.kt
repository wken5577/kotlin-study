package datedsl

import java.util.Calendar

infix fun Int.days(timing : DateUtil.Tense) = DateUtil(this, timing)

class DateUtil(val number : Int, val tense : Tense) {
    enum class Tense {
        ago, from_now
    }
    override fun toString(): String {
        val today = Calendar.getInstance()
        when (tense) {
            Tense.ago -> today.add(Calendar.DAY_OF_MONTH, -number)
            Tense.from_now -> today.add(Calendar.DAY_OF_MONTH, number)
        }
        return today.time.toString()
    }
}
