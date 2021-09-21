package com.example.androidecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.androidecommerce.dto.ProductDTO;
import com.example.androidecommerce.network.services.ProductService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class product_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Button button = (Button) findViewById(R.id.button_load);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
                progressBar.setVisibility(ProgressBar.VISIBLE);
                ListView listView = findViewById(R.id.ProductListView);

                final String[] catNames = new String[]{};
                /*{
                "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
                "Китти", "Масяня", "Симба"
        };*/

                ProductService.getInstance()
                        .getProductsApi()
                        .all()
                        .enqueue(new Callback<List<ProductDTO>>() {
                            @Override
                            public void onResponse(Call<List<ProductDTO>> call, Response<List<ProductDTO>> response) {
                                List<ProductDTO> list = response.body();
                                String str="";
                                int k =0;
                                for (ProductDTO item : list) {
                                    catNames[k++] = (item.getName()+"(price: "+item.getPrice()+")");
                                }
                                /*ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                        android.R.layout.simple_list_item_1, catNames);

                                listView.setAdapter(adapter);*/
                                //txtinfo.setText(str);
                            }

                            @Override
                            public void onFailure(Call<List<ProductDTO>> call, Throwable t) {
                                int k =0;
                                catNames[k++] = ("something went wrong");

                            }
                        });

                /* // используем адаптер данных
                 */
            }
        });
    }
}