package string

class Bj10798Kt {
    fun main() {
        val br = System.`in`.bufferedReader()

        val words = Array(5) { br.readLine() }
        val result = StringBuilder()

        for (i in 0 until 15) {
            for (word in words) {
                // 현재 단어에서 i번째 글자가 있으면 추가
                if (i < word.length) {
                    result.append(word[i])
                }
            }
        }

        println(result.toString())
        br.close()
    }
}