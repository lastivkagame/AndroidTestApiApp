package com.example.androidecommerce.network;

import com.example.androidecommerce.dto.ProductDTO;
import com.example.androidecommerce.dto.ProductImageDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductApi {
    @GET("/api/products/all")
    public Call<List<ProductDTO>> all();

    @GET("/api/products/images")
    public Call<List<String>> allImages();

    @GET("/api/Products/get/{id}")
    public Call<List<ProductImageDTO>> getPostWithID(@Path("id") int id);
}
