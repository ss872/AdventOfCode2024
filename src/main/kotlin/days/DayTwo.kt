package days

import util.FileUtil

class DayTwo {
    private val fileName: String = "SecondDay.txt"

    fun solveFirst(): Int {
        var ans = 0
        for (eachReport in getReports()) {
            if (eachReport.size < 2) {
                ++ans
                continue
            }
            if (isSafe(eachReport).first || isSafe(eachReport.reversed()).first) {
                ++ans
            }
        }
        return ans
    }

    fun solveSecond(): Int {
        var ans = 0
        for (eachReport in getReports()) {
            if (eachReport.size < 2) {
                ++ans
                continue
            }
            if (isSafeDampener(eachReport) || isSafeDampener(eachReport.reversed())) {
                ++ans
            }
        }
        return ans
    }

    private fun isSafeDampener(report: List<Int>) : Boolean {
        val isSafe = isSafe(report)
        if (isSafe.first) {
            return true
        }
        return isSafe(report.toMutableList().apply {removeAt(isSafe.second)}).first ||
                isSafe(report.toMutableList().apply {removeAt(isSafe.second + 1)}).first
    }



    private fun isSafe(report: List<Int>): Pair<Boolean, Int> {
        report.forEachIndexed{ index, value ->
            if (index < report.size - 1) {
                if (value >= report[index + 1] || report[index + 1] - value > 3) {
                    return Pair(false, index)
                }
            }
        }
        return Pair(true, 0)
    }
    private fun getReports(): List<List<Int>> {
        return FileUtil.getFile(fileName).map { line ->
            line.split(Regex("\\s+")).map ( Integer::valueOf )
        }
    }
}