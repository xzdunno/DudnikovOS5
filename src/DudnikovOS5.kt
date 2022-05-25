import java.util.*
import kotlin.system.measureTimeMillis

fun main(){
val r = Random()
val n = 3
val a = arrayOfNulls<Producer>(n)
for (i in 0 until n) {
    a[i] = Producer()
    a[i]!!.x = r.nextInt(300)
    a[i]!!.number = i + 1
    a[i]!!.beg=r.nextInt(30)
    a[i]!!.end=a[i]!!.beg+r.nextInt(50)+10
}
    a.sortBy { it!!.x }
  var isDone=false
    var i=1
    while (!isDone){
        var count=0
        for (x in a) if(x!=null) count++
        if(count!=0){
            val rec=Producer()
            rec.beg=a[n-i]!!.beg
            rec.end=a[n-i]!!.end
    rec.start()
            var num=0
            val time= measureTimeMillis { for(i in 0 until 10000) {
                num++
                print("")
            } }
    println("Время!!!= $time")
            rec.interrupt()
            a[n-i]!!.beg=rec.beg
            a[n-i]!!.end=rec.end
        if(a[n-i]!!.beg-1==a[n-i]!!.end){
            print("Поток ${a[n-i]!!.number} завершил выполнение")
            a[n-i]=null
            i++
        }
            else{
                val temp=a[n-i]
            a[n-i]=a[0]
            a[0]=temp
        }
        }
        else break
    }
}
internal class Producer : Thread() {
    var x = 0
    var number = 0
    var beg=0
    var end=0
    override fun run() {
        super.run()
        while(beg<=end){
            println(beg++)
            if (interrupted()){
                return
            }
        }
    }
    fun count(){
        while(beg<=end){
            println(beg++)
        }
    }
}
