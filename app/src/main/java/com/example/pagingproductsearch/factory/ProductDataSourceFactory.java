package com.example.pagingproductsearch.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.pagingproductsearch.datasource.ProductDataSource;

public class ProductDataSourceFactory extends DataSource.Factory {

    //private MutableLiveData<PageKeyedDataSource<Integer, Products>> mProductLiveDataSource = new MutableLiveData<>();
    private MutableLiveData<ProductDataSource> mProductLiveDataSource = new MutableLiveData<>();

    private Context mContext;

    ProductDataSource mProductDataSource;

    public ProductDataSourceFactory() {}

    @NonNull
    @Override
    public DataSource create() {
        mProductDataSource = new ProductDataSource();
        mProductLiveDataSource.postValue(mProductDataSource);
        return mProductDataSource;
    }

    public MutableLiveData<ProductDataSource> getProductLiveDataSource() {
        return mProductLiveDataSource;
    }
}
