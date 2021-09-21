package com.example.androidecommerce.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.androidecommerce.R;
import com.example.androidecommerce.constants.Urls;
import com.example.androidecommerce.dto.ProductDTO;
import com.example.androidecommerce.network.ImageRequester;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<ProductDTO> products;
    private ImageRequester imageRequester;
    private NetworkImageView myImage;

    public ProductAdapter(Context context, List<ProductDTO> products) {
        this.context = context;
        this.products = products;
    }

    //There we write/choose design for wathing every element
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItem = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);

        return new ProductAdapter.ProductViewHolder(productItem);
    }

    //there what data we use in design
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productBg.setCardBackgroundColor(Color.parseColor(products.get(position).getColor()));
        holder.productTitle.setText(products.get(position).getName());
        holder.productPrice.setText(String.valueOf(products.get(position).getPrice()));

        //holder.productImage.setImageURI(Uri.parse(products.get(position).getPath()));

        //ASK IT!!!
        int imageId = context.getResources().getIdentifier("ic_" + products.get(position).getPath(), "drawable", context.getPackageName());
        holder.productImage.setImageResource(imageId);

        //String url = Urls.BASE + products.get(position).getPath();
        //imageRequester = ImageRequester.getInstance();
        //imageRequester.setImageFromUrl(holder.productImage, url);
        //holder.productImage.setImageResource(imageRequester.);

        //myImage = findViewById(R.id.myimg);
        //imageRequester.setImageFromUrl(myImage, url);

        //holder.productTitle.setBackgroundColor(products.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    //there we decided which elems we will work
    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        CardView productBg;
        ImageView productImage;
        TextView productTitle, productPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productBg = itemView.findViewById(R.id.productBg);
            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}
