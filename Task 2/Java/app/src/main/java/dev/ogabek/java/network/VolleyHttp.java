package dev.ogabek.java.network;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import dev.ogabek.java.MyApplication;
import dev.ogabek.java.helper.Logger;
import dev.ogabek.java.model.Employee;

public class VolleyHttp {

    private static final String TAG = VolleyHttp.class.toString();
    public static final boolean IS_TESTER = true;
    private static final String SERVER_DEVELOPMENT = "http://dummy.restapiexample.com/api/v1/";
    private static final String SERVER_PRODUCTION = "http://dummy.restapiexample.com/api/v1/";

    static String server(String url) {
        if (IS_TESTER) {
            return SERVER_DEVELOPMENT + url;
        } else {
            return SERVER_PRODUCTION + url;
        }
    }

    static Map<String, String> header() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-type", "application/json; charset=UTF-8");
        return header;
    }

    // Request Methods

    public static void get(String api, HashMap<String, String> params, VolleyHandler volleyHandler) {
        StringRequest request = new StringRequest(
                Request.Method.GET, server(api),
                response -> {
                    Logger.d(TAG, response);
                    volleyHandler.onSuccess(response);
                },
                error -> {
                    Logger.d(TAG, error.toString());
                    volleyHandler.onError(error.getMessage());
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        MyApplication.instance.addToRequestQueue(request);
    }

    public static void post(String api, HashMap<String, String> body, VolleyHandler volleyHandler) {
        StringRequest request = new StringRequest(
                Request.Method.POST, server(api),
                response -> {
                    Logger.d(TAG, response);
                    volleyHandler.onSuccess(response);
                },
                error -> {
                    Logger.d(TAG, error.toString());
                    volleyHandler.onError(error.toString());
                }) {
            @Override
            public byte[] getBody() {
                return new JSONObject((Map<String, String>) body).toString().getBytes();
            }

            @Override
            public Map<String, String> getHeaders() {
                return header();
            }
        };
        MyApplication.instance.addToRequestQueue(request);
    }

    public static void  put(String api, HashMap<String, String> body, VolleyHandler volleyHandler) {
        StringRequest request = new StringRequest(
                Request.Method.PUT, server(api),
                response -> {
                    Logger.d(TAG, response);
                    volleyHandler.onSuccess(response);
                },
                error -> {
                    Logger.d(TAG, error.toString());
                    volleyHandler.onError(error.toString());
                }) {
            @Override
            public byte[] getBody() {
                return new JSONObject((Map<String, String>) body).toString().getBytes();
            }

            @Override
            public Map<String, String> getHeaders() {
                return header();
            }
        };
        MyApplication.instance.addToRequestQueue(request);
    }

    public static void delete(String api, VolleyHandler volleyHandler) {
        StringRequest request = new StringRequest(
                Request.Method.DELETE, server(api),
                response -> {
                    Logger.d(TAG, response);
                    volleyHandler.onSuccess(response);
                },
                error -> {
                    Logger.d(TAG, error.toString());
                    volleyHandler.onError(error.toString());
                }) {
        };
        MyApplication.instance.addToRequestQueue(request);
    }

    // Request API's

    public static final String API_LIST_EMPLOYEES = "employees";
    public static final String API_SINGLE_EMPLOYEE = "employee/"; //id
    public static final String API_CREATE_EMPLOYEE = "create";
    public static final String API_UPDATE_EMPLOYEE = "update/"; //id
    public static final String API_DELETE_EMPLOYEE = "delete/"; //id

    // Request Params

    public static HashMap<String, String> paramsEmpty() {
        return new HashMap<>();
    }

    public static HashMap<String, String> paramsCreate(Employee employee) {
        HashMap<String, String> params = new HashMap<>();
        params.put("employee_name", employee.getEmployee_name());
        params.put("employee_salary", employee.getEmployee_salary());
        params.put("employee_age", String.valueOf(employee.getEmployee_age()));
        params.put("profile_image", employee.getProfile_image());
        return params;
    }

    public static HashMap<String, String> paramsUpdate(Employee employee) {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(employee.getId()));
        params.put("employee_name", employee.getEmployee_name());
        params.put("employee_salary", employee.getEmployee_salary());
        params.put("employee_age", String.valueOf(employee.getEmployee_age()));
        params.put("profile_image", employee.getProfile_image());
        return params;
    }

    // Respond Parsing

}
