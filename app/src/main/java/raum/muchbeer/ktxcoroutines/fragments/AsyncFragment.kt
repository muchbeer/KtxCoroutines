package raum.muchbeer.ktxcoroutines.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.*
import raum.muchbeer.ktxcoroutines.R


class AsyncFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_async, container, false)


        CoroutineScope(Dispatchers.IO).launch {
            Log.d("AsyncFragment", "Asnyctask begin..")
            val thread1 = async { getThread1() }
            val thread2 = async { getThread2() }
            val total = thread1.await() + thread2.await()
            Log.d("AsyncFragment", "total value is $total")
        }
        return view
    }

    private suspend fun getThread1() : Int{
        delay(10000)
        Log.d("AsyncFragment","tHREAD 1 executed")
        return 5000
    }

    private suspend fun getThread2() : Int{
        delay(4000)
        Log.d("AsyncFragment","tHREAD 2 executed")
        return 4000
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AsyncFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}