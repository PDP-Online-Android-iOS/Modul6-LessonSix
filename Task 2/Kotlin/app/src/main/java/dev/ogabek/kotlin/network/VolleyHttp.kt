package dev.ogabek.kotlin.network

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import dev.ogabek.kotlin.MyApplication
import dev.ogabek.kotlin.helper.Logger
import dev.ogabek.kotlin.model.Employee
import org.json.JSONObject

class VolleyHttp {

    companion object {

        private val TAG = VolleyHttp::class.java.simpleName

        const val IS_TESTER = true
        private const val SERVER_DEVELOPMENT = "http://dummy.restapiexample.com/api/v1/"
        private const val SERVER_PRODUCTION = "http://dummy.restapiexample.com/api/v1/"

        fun server(url: String): String {
            return if (IS_TESTER) {
                SERVER_DEVELOPMENT + url
            } else {
                SERVER_PRODUCTION + url
            }
        }

        fun headers(): HashMap<String, String> {
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json; charset=UTF-8"
            return header
        }

        const val API_GET_EMPLOYEES = "employees"
        const val API_GET_ONE_EMPLOYEE = "employee/"        //id
        const val API_POST_EMPLOYEES = "create"
        const val API_PUT_EMPLOYEES = "update/"        // id

        fun paramsEmpty(): HashMap<String, String> {
            return HashMap()
        }

        fun paramsPost(employee: Employee): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params["employee_name"] = employee.employee_name
            params["employee_salary"] = employee.employee_salary
            params["employee_age"] = employee.employee_age
            params["profile_image"] = employee.profile_image
            return params
        }

        fun paramsPut(employee: Employee): HashMap<String, Any> {
            val params = HashMap<String, Any>()
            params["id"] = employee.id
            params["employee_name"] = employee.employee_name
            params["employee_salary"] = employee.employee_salary
            params["employee_age"] = employee.employee_age
            params["profile_image"] = employee.profile_image
            return params
        }

        fun get(api: String, params: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val request = object: StringRequest(
                Method.GET, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.message.toString())
                    volleyHandler.onSuccess(error.message.toString())
                }) {
                override fun getParams(): MutableMap<String, String> {
                    return params
                }
            }
            MyApplication.instance!!.addToRequestQueue(request)
        }

        fun post(api: String, body: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val request = object: StringRequest(
                Method.POST, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.message.toString())
                    volleyHandler.onSuccess(error.message.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }
                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance!!.addToRequestQueue(request)
        }

        fun put(api: String, body: HashMap<String, String>, volleyHandler: VolleyHandler) {
            val request = object: StringRequest(
                Method.PUT, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.message.toString())
                    volleyHandler.onSuccess(error.message.toString())
                }) {
                override fun getHeaders(): MutableMap<String, String> {
                    return headers()
                }
                override fun getBody(): ByteArray {
                    return JSONObject(body as Map<*, *>).toString().toByteArray()
                }
            }
            MyApplication.instance!!.addToRequestQueue(request)
        }

        fun delete(api: String, volleyHandler: VolleyHandler) {
            val request = object: StringRequest(
                Method.DELETE, server(api),
                Response.Listener { response ->
                    Logger.d(TAG, response)
                    volleyHandler.onSuccess(response)
                },
                Response.ErrorListener { error ->
                    Logger.e(TAG, error.message.toString())
                    volleyHandler.onSuccess(error.message.toString())
                }) {

            }
            MyApplication.instance!!.addToRequestQueue(request)
        }

    }

}