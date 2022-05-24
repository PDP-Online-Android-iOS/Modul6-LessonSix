package dev.ogabek.java.network.model;

import java.util.List;

public class RespondObjectErrors<T> {

    String status;
    T data;
    String message;

    public RespondObjectErrors(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
