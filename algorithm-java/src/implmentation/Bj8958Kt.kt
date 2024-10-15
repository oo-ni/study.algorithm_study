package implmentation

class Bj8958Kt {
    fun main() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()

        val tc = br.readLine().toInt()

        for (i in 0 until tc) {
            var result = br.readLine()
            var score = 0
            var countO = 0

            for (char in result) {
                if (char == 'O') {
                    countO++
                    score += countO
                } else {
                    countO = 0
                }
            }
            bw.write("$score\n")
        }
        bw.flush()
        br.close()
        bw.close()
    }
}