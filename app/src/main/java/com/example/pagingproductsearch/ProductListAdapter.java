package com.example.pagingproductsearch;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pagingproductsearch.model.Products;


public class ProductListAdapter extends PagedListAdapter<Products, ProductListAdapter.ProductViewHolder> {

    private static final String TAG = "ProductListAdapter";

    // Class member variables for adapter
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    private View mParentView;

    public ProductListAdapter(Context context) {
        super(DIFF_CALLBACK);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mParentView = ((Activity)mContext).getWindow().getDecorView().getRootView();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.product_item, parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {

        final Products mProduct = getItem(position);

        if(mProduct != null){
            // setting data from db to views
            holder.mBatchNumber.setText("#" + mProduct.getBatch_number());
            holder.mProductName.setText(mProduct.getProduct_name());
            holder.mProductPrice.setText("Price: " + mProduct.getUnit_selling_price());
            holder.mProductQty.setText("Quantity: " + mProduct.getQuantity_available() +"/"+ mProduct.getReference_quantity());
            holder.mProductStatus.setText(mProduct.getProduct_availability().toLowerCase());
            holder.mCategory.setText(mProduct.getCategory());


        }

        holder.mMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open menu with
            }
        });

        //*** item View click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open menu with two options
            }
        });

    }

    private static DiffUtil.ItemCallback<Products> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Products>() {
                @Override
                public boolean areItemsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
                    return oldItem.getProduct_id() == newItem.getProduct_id();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
                    return oldItem.equals(newItem);
                }
            };


    public class ProductViewHolder extends RecyclerView.ViewHolder{

        // Objects of views in product item layout resource file
        private AppCompatTextView mBatchNumber,mProductName,mProductQty,mProductPrice,mProductStatus,
                mCategory;

        private ImageButton mMenuButton;

        private ProgressBar mProgressBar;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            // getting reference to views
            mBatchNumber = itemView.findViewById(R.id.mBatchNumber);
            mProductName = itemView.findViewById(R.id.mProductName);
            mProductPrice = itemView.findViewById(R.id.mProductPrice);
            mProductQty = itemView.findViewById(R.id.mProductQty);
            mProductStatus = itemView.findViewById(R.id.mProductStatus);
            mCategory = itemView.findViewById(R.id.mCategory);
            mMenuButton = itemView.findViewById(R.id.mMenuButton);
            mProgressBar = itemView.findViewById(R.id.mProgressBar);
        }
    }
}
