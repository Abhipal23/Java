package org.abhishek.java.springmvcw2.advices;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ApiResponse<T> {


    // ApiResponse either can be data filed or error filed

    private T data;
    // if we are not getting data we can return error

    private  ApiError apiError;

    private LocalDate  timestamp;


    // constructor for data
    public ApiResponse(T data) {
        this();
        this.data = data;
    }
   // constructor for apiError
   public ApiResponse(ApiError apiError) {
        this();
       this.apiError = apiError;
   }
   // default constructor for timestamp
   public ApiResponse() {
      this.timestamp=LocalDate.now();
   }
}
