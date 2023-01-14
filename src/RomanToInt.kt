object RomanToInt {
    private val mapRomanToInt = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    private val subtractCases = setOf(
        "IV", "IX", "XL", "XC", "CD", "CM"
    )

    @JvmStatic
    fun main(args: Array<String>) {
//        println(romanToInt("ROMAN_NUM"))
    }

    private fun romanToInt(s: String): Int {
        /*
        Symbol       Value
           I           1
           V           5
           X           10
           L           50
           C           100
           D           500
           M           1000
         */

        val length = s.length

        if (length == 1) {
            return mapRomanToInt[s.single()]!!
        }

        var sum = 0
        var i = 0

        do {
            //last character in the string
            if ((s.length - i) == 1) {
                sum += mapRomanToInt[s.elementAt(i)]!!
                break
            }
            if (subtractCases.contains(s.substring(i, i + 2))) {
                sum += mapRomanToInt[s.elementAt(i + 1)]!!.minus(mapRomanToInt[s.elementAt(i)]!!)
                i += 2
            } else {
                sum += mapRomanToInt[s.elementAt(i)]!!
                i++
            }
        } while (i < s.length)

        return sum
    }
}