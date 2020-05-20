package com.example.pagingproductsearch.pojo;

import com.example.pagingproductsearch.model.Products;

import java.util.List;

public class ProductListResponse {

    private boolean has_more_pages;
    private int number_of_products_per_page;
    private int total_number_of_products;
    private int last_page_number;
    private String next_page_url;
    private List<Products> products;

    public ProductListResponse(boolean has_more_pages, int number_of_products_per_page, int total_number_of_products,
                               int last_page_number, String next_page_url, List<Products> products) {
        this.has_more_pages = has_more_pages;
        this.number_of_products_per_page = number_of_products_per_page;
        this.total_number_of_products = total_number_of_products;
        this.last_page_number = last_page_number;
        this.next_page_url = next_page_url;
        this.products = products;
    }

    public boolean isHas_more_pages() {
        return has_more_pages;
    }

    public void setHas_more_pages(boolean has_more_pages) {
        this.has_more_pages = has_more_pages;
    }

    public int getNumber_of_products_per_page() {
        return number_of_products_per_page;
    }

    public void setNumber_of_products_per_page(int number_of_products_per_page) {
        this.number_of_products_per_page = number_of_products_per_page;
    }

    public int getTotal_number_of_products() {
        return total_number_of_products;
    }

    public void setTotal_number_of_products(int total_number_of_products) {
        this.total_number_of_products = total_number_of_products;
    }

    public int getLast_page_number() {
        return last_page_number;
    }

    public void setLast_page_number(int last_page_number) {
        this.last_page_number = last_page_number;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
