package dev.ogabek.java.network.model;

import java.util.List;

public class RespondListError<T> {

    String status;
    List<T> data;
    String message;


    public RespondListError(String status, List<T> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public List<T> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
