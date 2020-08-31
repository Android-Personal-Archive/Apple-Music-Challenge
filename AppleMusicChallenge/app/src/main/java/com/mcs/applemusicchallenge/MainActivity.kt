package com.mcs.applemusicchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcs.applemusicchallenge.adapters.ResultsAdapter
import com.mcs.applemusicchallenge.fragments.ClassicFragment
import com.mcs.applemusicchallenge.fragments.PopFragment
import com.mcs.applemusicchallenge.fragments.RockFragment
import com.mcs.applemusicchallenge.injectables.RetrofitClientSingleton
import com.mcs.applemusicchallenge.interfaces.IGetResultsService
import com.mcs.applemusicchallenge.pokos.ResultsPOKO
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClientSingleton.retrofitInstance?.create(IGetResultsService::class.java)
        val rockCall = service?.getMeResults(termParam = "rock", mediaParam = "music", entityParam = "song", limitParam = 50)

        lateinit var fragment: Fragment

        bn_fragment_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.mi_rock -> {
                    fragment = RockFragment()
                    callApi(rockCall)
                }
                R.id.mi_classic -> {
                    fragment = ClassicFragment()
                    val classicCall = service?.getMeResults(termParam = "classick", mediaParam = "music", entityParam = "song", limitParam = 50)
                    callApi(classicCall)
                }
                R.id.mi_pop -> {
                    fragment = PopFragment()
                    val popCall = service?.getMeResults(termParam = "pop", mediaParam = "music", entityParam = "song", limitParam = 50)
                    callApi(popCall)
                }
            }

            supportFragmentManager.beginTransaction().replace(R.id.fl_fragment_container, fragment).commit()
            true
        }

        callApi(rockCall)
        supportFragmentManager.beginTransaction().replace(R.id.fl_fragment_container, RockFragment()).commit()
    }

    private fun callApi(call: Call<ResultsPOKO>?){
        call?.enqueue(object: Callback<ResultsPOKO>{
            override fun onFailure(call: Call<ResultsPOKO>, t: Throwable) {
                Log.e(localClassName, "Error reading JSON")
            }

            override fun onResponse(call: Call<ResultsPOKO>, response: Response<ResultsPOKO>) {
                val results = response.body()
                if(results == null){
                    Log.w(localClassName, "Response returned null")
                }
                else
                {
                    val adapter = ResultsAdapter(this@MainActivity, results)
                    rv_music.adapter = adapter
                    rv_music.layoutManager = LinearLayoutManager(this@MainActivity)
                    rv_music.setHasFixedSize(true)
                }
            }
        })
    }
}