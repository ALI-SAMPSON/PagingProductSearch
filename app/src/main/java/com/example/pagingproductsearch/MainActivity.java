package com.example.pagingproductsearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.pagingproductsearch.model.Products;
import com.example.pagingproductsearch.viewmodel.ProductViewModel;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    ProductViewModel mProductViewModel;

    MaterialSearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.mRecyclerView);
        // setting up recycler view
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProductViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        final ProductListAdapter mAdapter = new ProductListAdapter(this);
        mProductViewModel.productPagedList.observe(this, new Observer<PagedList<Products>>() {
            @Override
            public void onChanged(PagedList<Products> product) {
                Log.e("Paging ", "PageAll" + product.size());
                //refresh current list
                mAdapter.submitList(product);
            }
        });
        // setting recycler adapter to recycler view
        mRecyclerView.setAdapter(mAdapter);

    }

    private void setUpData(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu_filter,menu);
        // find menu item
        MenuItem mItem = menu.findItem(R.id.menu_search);

        // Preparing search view
        mSearchView = findViewById(R.id.mSearchView);
        mSearchView.setMenuItem(mItem);
        mSearchView.setEllipsize(true);
        mSearchView.setSubmitOnClick(true);

        // Query listener to help in searching
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //just set the current value to search.
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_filter:{
                // open dialog to filter product by category or status
                //openFilterDialog();

            }
        }

        return super.onOptionsItemSelected(item);
    }
}
