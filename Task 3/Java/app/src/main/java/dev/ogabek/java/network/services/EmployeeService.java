package dev.ogabek.java.network.services;

import java.util.List;

import dev.ogabek.java.model.Employee;
import dev.ogabek.java.network.model.RespondListError;
import dev.ogabek.java.network.model.RespondObjectErrors;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeService {

    @Headers("Content-type:application/json; charset=UTF-8")

    @GET("employees")
    Call<RespondListError<Employee>> get();

    @GET("employees/{id}")
    Call<RespondObjectErrors<Employee>> single(@Path("id") int id);

    @POST("create")
    Call<RespondObjectErrors<Employee>> post(@Body Employee employee);

    @PUT("update/{id}")
    Call<RespondObjectErrors<Employee>> update(@Path("id") int id, @Body Employee employee);

    @DELETE("delete/{id}")
    Call<Employee> delete(@Path("id") int id);

}
