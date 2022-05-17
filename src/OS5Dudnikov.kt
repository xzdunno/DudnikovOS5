import java.util.*
import kotlin.math.max


    fun main() {
        val r = Random()
        println("Введите число потоков:")
        val y = Scanner(System.`in`)
        val n = y.nextInt()
        val a = arrayOfNulls<Producer>(n)
        for (i in 0 until n) {
            a[i] = Producer()
            a[i]!!.x = r.nextInt(300)
            //print("${a[i]!!.x} ")
            a[i]!!.number = i + 1
        }
        while (true) {
            var max:Int
            a.sortBy { it!!.x }
            max=a[n-1]!!.number
           // print("max=$max")
            a[n - 1]!!.st()
            println("Поток №" + max + " запущен ")
            for (i in 0 until n) {
                //print("${a[i]!!.x} ")
                a[i] = Producer()
                a[i]!!.x = r.nextInt(300)
                a[i]!!.number = i + 1
            }
            println("Поток №$max завершил свою работу ")
            Producer.slip()
        }
    }
    internal class Producer : Thread() {
        var x = 0
        var number = 0
        fun st() {
            val f = Thread()
            f.start()
        }
        companion object {
            fun slip() {
                try {
                    Thread.sleep(500)
                } catch (z: InterruptedException) {
                }
            }
        }
    }

