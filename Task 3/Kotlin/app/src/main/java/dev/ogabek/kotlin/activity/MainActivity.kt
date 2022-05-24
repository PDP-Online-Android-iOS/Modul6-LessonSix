package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.helper.Logger
import dev.ogabek.kotlin.model.Employee
import dev.ogabek.kotlin.model.RespondListData
import dev.ogabek.kotlin.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var tv_text: TextView

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        tv_text = findViewById(R.id.tv_text)

        get()
    }

    private fun get() {
        RetrofitHttp.employeeService.get().enqueue(object : Callback<RespondListData<Employee>> {
            override fun onResponse(
                call: Call<RespondListData<Employee>>,
                response: Response<RespondListData<Employee>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    tv_text.text = response.body()!!.data.toString()
                }
            }

            override fun onFailure(call: Call<RespondListData<Employee>>, t: Throwable) {
                Logger.e(TAG, t.localizedMessage)
                tv_text.text = t.localizedMessage
            }

        })
    }
}