package raum.muchbeer.ktxcoroutines

import kotlinx.coroutines.*

class UserDataConcurrency {

    var count =0
    lateinit var deffered : Deferred<Int>
    suspend fun getThreadsConcurrency() : Int {

        coroutineScope{
            launch(Dispatchers.IO) {
                delay(5000)
                count = 49
            }

            deffered = async(Dispatchers.IO) {
                delay(3000)
                return@async 70
            }
        }
        return count+deffered.await()
    }
}