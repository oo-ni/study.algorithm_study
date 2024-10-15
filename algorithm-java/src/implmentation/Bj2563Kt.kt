package implmentation

import java.io.BufferedReader

class Bj2563Kt {
    fun main() {
        val br = System.`in`.bufferedReader()

        val paper = Array(100) { BooleanArray(100) }
        val n = br.readLine().toInt()

        // 입력 위치에 색종이 붙이기
        for (i in 0 until n) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            for (i in x until x + 10) {
                for (j in y until y + 10) {
                    paper[i][j] = true
                }
            }
        }

        // 색종이가 붙은 영역의 넓이 계산
        var area = 0
        for (i in 0 until 100) {
            for (j in 0 until 100) {
                if (paper[i][j]) area++
            }
        }

        println(area)
        br.close()
    }
}