package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.network.VolleyHandler
import dev.ogabek.kotlin.network.VolleyHttp

class MainActivity : AppCompatActivity() {

    private lateinit var tv_text: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        tv_text = findViewById(R.id.tv_text)
        get()
    }

    fun get() {
        VolleyHttp.get(VolleyHttp.API_GET_EMPLOYEES, VolleyHttp.paramsEmpty(), object : VolleyHandler{
            override fun onSuccess(response: String) {
                tv_text.text = response
            }

            override fun onError(error: String) {
                tv_text.text = error
            }

        })
    }

}