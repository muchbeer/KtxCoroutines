package raum.muchbeer.ktxcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import raum.muchbeer.ktxcoroutines.viewmodel.CorotineViewModel

class MainActivity : AppCompatActivity() {

  //  private lateinit var viewModelScope : CorotineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   /*     if(savedInstanceState ==null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
*/

        /* viewModelScope = ViewModelProvider(this).get(CorotineViewModel::class.java)
         viewModelScope.getUserData()
         viewModelScope.mutableResult.observe(this, Observer {myResult->
         myResult.forEach {
             Log.d("ViewModelScopeFragment", "Familia ya Machibya ni ${it.userName}")
         }

         })*/

      lifecycleScope.launch {
          /*
           delay(5000)
           progressbar.visibility = View.VISIBLE
           delay(10000)
           progressbar.visibility = View.GONE
           */

        }

        lifecycleScope.launchWhenCreated {
            //this is executed when the activity is launched for the first time

        }
    }
}