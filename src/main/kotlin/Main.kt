import days.DayOne
import days.DayTwo

fun main() {
    println("*".repeat(10))
    println("Day One: First")
    println(DayOne().solveFirst())
    println("*".repeat(10))

    println()
    println("*".repeat(10))
    println("Day One: Second")
    println(DayOne().solveSecond())
    println("*".repeat(10))

    println()
    println("*".repeat(10))
    println("Day Two: First")
    println(DayTwo().solveFirst())
    println("*".repeat(10))

    println()
    println("*".repeat(10))
    println("Day Two: Second")
    println(DayTwo().solveSecond())
    println("*".repeat(10))
}