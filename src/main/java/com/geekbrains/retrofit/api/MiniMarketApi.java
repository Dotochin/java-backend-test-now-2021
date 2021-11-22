package com.geekbrains.retrofit.api;

import com.geekbrains.retrofit.model.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MiniMarketApi {

    @GET("api/v1/products")
    Call<List<Product>> getProducts();

    @GET("api/v1/products/{id}")
    Call<Product> getProduct(@Path("id") Long id);

    @POST("api/v1/products")
    Call<Product> createProduct(@Body Product product);

    @PUT("api/v1/products")
    Call<Product> modifyProduct(@Body Product product);

    @DELETE("api/v1/products/{id}")
    Call<Product> deleteProduct(@Path("id") Long id);

}