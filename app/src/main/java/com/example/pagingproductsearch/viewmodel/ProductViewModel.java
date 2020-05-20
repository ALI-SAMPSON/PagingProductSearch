package com.example.pagingproductsearch.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.pagingproductsearch.datasource.ProductDataSource;
import com.example.pagingproductsearch.model.Products;
import com.example.pagingproductsearch.factory.ProductDataSourceFactory;

public class ProductViewModel extends ViewModel{

    public LiveData<PagedList<Products>> productPagedList;
    //LiveData<PageKeyedDataSource<Integer, Products>> liveDataSource;
    LiveData<ProductDataSource> liveDataSource;
    public static final int PAGE_SIZE = 20;
    private ProductDataSourceFactory mProductDataSourceFactory;


    public MutableLiveData<String> filterTextAll = new MutableLiveData<>();

    public ProductViewModel() {
        mProductDataSourceFactory = new ProductDataSourceFactory();
        liveDataSource = mProductDataSourceFactory.getProductLiveDataSource();
        PagedList.Config mConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPrefetchDistance(5)
                        .setPageSize(ProductDataSource.PAGE_SIZE)
                        .build();
        productPagedList = (new LivePagedListBuilder(mProductDataSourceFactory, mConfig))
                .build();
    }

    public void initData(){
//        mProductDataSourceFactory = new ProductDataSourceFactory();
//        liveDataSource = mProductDataSourceFactory.getProductLiveDataSource();
//        PagedList.Config mConfig =
//                (new PagedList.Config.Builder())
//                        .setEnablePlaceholders(false)
//                        .setPrefetchDistance(5)
//                        .setPageSize(ProductDataSource.PAGE_SIZE)
//                        .build();
//        productPagedList = (new LivePagedListBuilder(mProductDataSourceFactory, mConfig))
//                            .build();
    }


    public void retry() {
        //mProductDataSourceFactory.getProductLiveDataSource().getValue().re();
    }

    public void refresh() {
        mProductDataSourceFactory.getProductLiveDataSource().getValue().invalidate();
    }

}
