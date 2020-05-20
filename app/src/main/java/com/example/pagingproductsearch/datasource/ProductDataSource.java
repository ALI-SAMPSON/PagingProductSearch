package com.example.pagingproductsearch.datasource;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.pagingproductsearch.model.Products;
import com.example.pagingproductsearch.pojo.ProductListResponse;

public class ProductDataSource extends PageKeyedDataSource<Integer, Products> {

    private static final String TAG = ProductDataSource.class.getSimpleName();

    private Context mContext;
    private static final int FIRST_PAGE = 1;
    public static int PAGE_SIZE = 20;

    public ProductDataSource() {
    }

    @Override
    public void loadInitial(@NonNull final LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Products> callback) {

        // making http call
        RetrofitClient.getInstance()
                .getApi()
                .getPaginatedProductsList(header, branchId, FIRST_PAGE)
                .enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                if(response.body() != null){
                    // load next page
                    callback.onResult(response.body().getProducts(),null,FIRST_PAGE + 1);
                    Log.d(TAG, "LoadInitial Key: " + FIRST_PAGE);
                }
            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable t) {
                Log.d(TAG, "Error: "+ t.getMessage());
            }
        });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Products> callback) {


        // making http call
        RetrofitClient.getInstance()
                .getApi()
                .getPaginatedProductsList(header, branchId, params.key)
                .enqueue(new Callback<ProductListResponse>() {
                    @Override
                    public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                        if(response.body() != null){
                            // get previous page key
                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            // load previous page
                            callback.onResult(response.body().getProducts(), key);
                            Log.d(TAG, "LoadBefore Key: " + key);
                        }
                    }

                    @Override
                    public void onFailure(Call<ProductListResponse> call, Throwable t) {
                        Log.d(TAG, "Error: "+ t.getMessage());
                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Products> callback) {

        // making http call
        RetrofitClient.getInstance()
                .getApi()
                .getPaginatedProductsList(header, branchId, params.key)
                .enqueue(new Callback<ProductListResponse>() {
                    @Override
                    public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                        if(response.body() != null){
                            // if has_more_page is true then increment the key else null
                            Integer key = response.body().isHas_more_pages() ? params.key + 1 : null;
                            // load next page if there are any
                            callback.onResult(response.body().getProducts(), key);
                            Log.d(TAG, "LoadAfter Key: " + key);
                        }
                    }

                    @Override
                    public void onFailure(Call<ProductListResponse> call, Throwable t) {
                        Log.d(TAG, "Error: "+ t.getMessage());
                    }
                });
    }
}
