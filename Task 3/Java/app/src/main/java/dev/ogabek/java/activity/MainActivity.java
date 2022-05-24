package dev.ogabek.java.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.helper.Logger;
import dev.ogabek.java.model.Employee;
import dev.ogabek.java.model.EmployeeResult;
import dev.ogabek.java.network.RetrofitHttp;
import dev.ogabek.java.network.model.RespondListError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv_text;
    private final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        tv_text = findViewById(R.id.tv_text);
        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get();
            }
        });
        get();
    }

    private void get() {
        RetrofitHttp.employeeService.get().enqueue(new Callback<RespondListError<Employee>>() {
            @Override
            public void onResponse(Call<RespondListError<Employee>> call, Response<RespondListError<Employee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    tv_text.setText(response.body().getData().toString());
                }
            }

            @Override
            public void onFailure(Call<RespondListError<Employee>> call, Throwable t) {
                Logger.e(TAG, t.getLocalizedMessage());
                tv_text.setText(t.getLocalizedMessage());
            }
        });
    }

}