package com.example.androidecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.androidecommerce.adapter.ProductAdapter;
import com.example.androidecommerce.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView productRecycler;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button button = (Button) findViewById(R.id.about);

        List<ProductDTO> productsList = new ArrayList<>();
        productsList.add(new ProductDTO(97, "python", 30, "test_image", "#FF018786"));
        productsList.add(new ProductDTO(98, "java", 50, "test_image","#FF018786"));
        productsList.add(new ProductDTO(99, "c#", 40, "test_image", "#FF018786"));

        setProductRecycler(productsList);
    }

    private void setProductRecycler(List<ProductDTO> productsList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        productRecycler = findViewById(R.id.productRecycler);
        productRecycler.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter(this, productsList);
        productRecycler.setAdapter(productAdapter);
    }
}