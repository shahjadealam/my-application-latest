package com.myapp.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseContainer<T>{
    private String errorCode;
    private String errorMessage;
    private T response;

    public ResponseContainer(T response) {
        this.response = response;
    }

    public static <T> ResponseContainer<T> of(final T response) {
        return new ResponseContainer<>(response);
    }
}
