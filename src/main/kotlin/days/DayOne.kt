package days

import util.FileUtil
import kotlin.math.abs

class DayOne {
    private val fileName: String = "FirstDay.txt"

    fun solveFirst() : Long {
        var ans = 0L
        val (left, right) = getList()
        left.sorted().zip(right.sorted()).forEach{
            ans += abs(it.first - it.second)
        }
        return ans
    }

    fun solveSecond() : Long {
        var ans = 0L
        val (left, right) = getList()
        val freqMap: Map<Int, Int> = right.groupingBy { it }.eachCount()

        left.forEach {
            ans += it * freqMap.getOrDefault(it, 0)
        }
        return ans
    }

    private fun getList() : Pair<List<Int>, List<Int>> {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        FileUtil.getFile(fileName).forEach{ line ->
            val temp = line.split(Regex("\\s+"))
            left.add(Integer.valueOf(temp[0]))
            right.add(Integer.valueOf(temp[1]))
        }
        return Pair(left, right)
    }
}