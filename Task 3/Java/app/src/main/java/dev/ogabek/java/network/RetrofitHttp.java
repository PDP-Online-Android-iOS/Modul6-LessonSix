package dev.ogabek.java.network;

import dev.ogabek.java.model.Employee;
import dev.ogabek.java.network.services.EmployeeService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHttp {

    public static final boolean IS_TESTER = true;
    private static final String SERVER_DEVELOPMENT = "http://dummy.restapiexample.com/api/v1/";
    private static final String SERVER_PRODUCTION = "http://dummy.restapiexample.com/api/v1/";

    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create()).build();

    private static String server() {
        if (IS_TESTER) {
            return SERVER_DEVELOPMENT;
        } else {
            return SERVER_PRODUCTION;
        }
    }

    public static EmployeeService employeeService = retrofit.create(EmployeeService.class);

}
