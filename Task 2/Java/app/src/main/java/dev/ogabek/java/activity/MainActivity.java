package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import dev.ogabek.java.R;
import dev.ogabek.java.model.Employee;
import dev.ogabek.java.network.VolleyHandler;
import dev.ogabek.java.network.VolleyHttp;

public class MainActivity extends AppCompatActivity {

    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        tv_text = findViewById(R.id.tv_text);
        get();
    }

    private void get() {
        VolleyHttp.get(VolleyHttp.API_LIST_EMPLOYEES, VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                tv_text.setText(response);
            }

            @Override
            public void onError(String error) {
                tv_text.setText(error);
            }
        });
    }

    private void single() {
        VolleyHttp.get(VolleyHttp.API_SINGLE_EMPLOYEE + 1, VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                tv_text.setText(response);
            }

            @Override
            public void onError(String error) {
                tv_text.setText(error);
            }
        });
    }

    private void post() {
        Employee employee = new Employee(1, "OgabekDev", "18000", 18, "null");
        VolleyHttp.post(VolleyHttp.API_CREATE_EMPLOYEE, VolleyHttp.paramsCreate(employee), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                tv_text.setText(response);
            }

            @Override
            public void onError(String error) {
                tv_text.setText(error);
            }
        });
    }

    private void put() {
        Employee employee = new Employee(1, "OgabekDev", "18000", 18, "null");
        VolleyHttp.get(VolleyHttp.API_UPDATE_EMPLOYEE + employee.getId(), VolleyHttp.paramsUpdate(employee), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                tv_text.setText(response);
            }

            @Override
            public void onError(String error) {
                tv_text.setText(error);
            }
        });
    }

    private void delete() {
        Employee employee = new Employee(1, "OgabekDev", "18000", 18, "null");
        VolleyHttp.delete(VolleyHttp.API_DELETE_EMPLOYEE + employee.getId(), new VolleyHandler() {
            @Override
            public void onSuccess(String response) {
                tv_text.setText(response);
            }

            @Override
            public void onError(String error) {
                tv_text.setText(error);
            }
        });
    }

}