package raum.muchbeer.ktxcoroutines.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import raum.muchbeer.ktxcoroutines.model.User
import raum.muchbeer.ktxcoroutines.repository.UserRepository

class CorotineViewModel : ViewModel() {

   // private val myJob = Job()
 //   private val myScope = CoroutineScope(Dispatchers.IO + myJob)

    private var userRepository = UserRepository()
    var mutableResult : MutableLiveData<List<User>> = MutableLiveData()
    var userLive = liveData<List<User>>(Dispatchers.IO) {
        var resultLive = userRepository.getListofUsers()
        emit(resultLive)
    }

    fun getUserData() {

        viewModelScope.launch {
            //please note ? represent nullable and !! not null take note
            Log.d("CorotineViewModeScope", "Corotine timer started")
            var result : List<User>? = null
            withContext(Dispatchers.IO) {
                result = userRepository.getListofUsers()
            }
            mutableResult.value = result
        }
    /*    myScope.launch {
        }*/
    }

    //using the ktx extension we leverage ViewModelScope to automatically handle onCleared
    override fun onCleared() {
        super.onCleared()
     //   myJob.cancel()
    }
}