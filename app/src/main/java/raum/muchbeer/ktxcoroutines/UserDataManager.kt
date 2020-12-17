package raum.muchbeer.ktxcoroutines

import kotlinx.coroutines.*

class UserDataManager {

    //Unstructured Concurrency
    var count =0
    suspend fun getUserDelay1() : Int {

        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            count = 49
        }
        val deffered =
            CoroutineScope(Dispatchers.IO).async {
                delay(3000)
                return@async 70
            }

        return count + deffered.await()
    }

}