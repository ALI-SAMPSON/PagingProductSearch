package com.example.pagingproductsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;

public class Products implements Parcelable {

    // Member variables
    private int product_id;

    private String created_by;

    private String category;

    private String product_name;

    private String batch_number;

    private String unit_selling_price;

    private String unit_cost_price;

    private String unit_wholesale_price;

    private double unit_margin_value;

    private String unit_margin_percentage;

    private String quantity_available;

    private String low_level_quantity;

    private String reference_quantity;

    private String packname;

    private String discount_status;

    private String discount_value;

    private String discount_type;

    private String product_availability;

    private String date_created;

    private String last_updated;

    private String date_of_expiry;

    private String manufacturer;

    private String product_slug;

    public Products() {}

    public Products(int product_id, String created_by, String category, String product_name, String batch_number,
                    String unit_selling_price, String unit_cost_price, String unit_wholesale_price, int unit_margin_value,
                    String unit_margin_percentage, String quantity_available, String low_level_quantity,
                    String reference_quantity, String packname, String discount_status, String discount_value,
                    String discount_type, String product_availability,
                    String date_created, String last_updated, String date_of_expiry) {
        this.product_id = product_id;
        this.created_by = created_by;
        this.category = category;
        this.product_name = product_name;
        this.batch_number = batch_number;
        this.unit_selling_price = unit_selling_price;
        this.unit_cost_price = unit_cost_price;
        this.unit_wholesale_price = unit_wholesale_price;
        this.unit_margin_value = unit_margin_value;
        this.unit_margin_percentage = unit_margin_percentage;
        this.quantity_available = quantity_available;
        this.low_level_quantity = low_level_quantity;
        this.reference_quantity = reference_quantity;
        this.packname = packname;
        this.discount_status = discount_status;
        this.discount_value = discount_value;
        this.discount_type = discount_type;
        this.product_availability = product_availability;
        this.date_created = date_created;
        this.last_updated = last_updated;
        this.date_of_expiry = date_of_expiry;
    }

    protected Products(Parcel in) {
        product_id = in.readInt();
        created_by = in.readString();
        category = in.readString();
        product_name = in.readString();
        batch_number = in.readString();
        unit_selling_price = in.readString();
        unit_cost_price = in.readString();
        unit_wholesale_price = in.readString();
        unit_margin_value = in.readDouble();
        unit_margin_percentage = in.readString();
        quantity_available = in.readString();
        low_level_quantity = in.readString();
        reference_quantity = in.readString();
        packname = in.readString();
        discount_status = in.readString();
        discount_value = in.readString();
        discount_type = in.readString();
        product_availability = in.readString();
        date_created = in.readString();
        last_updated = in.readString();
        date_of_expiry = in.readString();
        manufacturer = in.readString();
        product_slug = in.readString();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public String getUnit_selling_price() {
        return unit_selling_price;
    }

    public void setUnit_selling_price(String unit_selling_price) {
        this.unit_selling_price = unit_selling_price;
    }

    public String getUnit_cost_price() {
        return unit_cost_price;
    }

    public void setUnit_cost_price(String unit_cost_price) {
        this.unit_cost_price = unit_cost_price;
    }

    public String getUnit_wholesale_price() {
        return unit_wholesale_price;
    }

    public void setUnit_wholesale_price(String unit_wholesale_price) {
        this.unit_wholesale_price = unit_wholesale_price;
    }

    public double getUnit_margin_value() {
        return unit_margin_value;
    }

    public void setUnit_margin_value(double unit_margin_value) {
        this.unit_margin_value = unit_margin_value;
    }

    public String getUnit_margin_percentage() {
        return unit_margin_percentage;
    }

    public void setUnit_margin_percentage(String unit_margin_percentage) {
        this.unit_margin_percentage = unit_margin_percentage;
    }

    public String getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(String quantity_available) {
        this.quantity_available = quantity_available;
    }

    public String getLow_level_quantity() {
        return low_level_quantity;
    }

    public void setLow_level_quantity(String low_level_quantity) {
        this.low_level_quantity = low_level_quantity;
    }

    public String getReference_quantity() {
        return reference_quantity;
    }

    public void setReference_quantity(String reference_quantity) {
        this.reference_quantity = reference_quantity;
    }

    public String getPackname() {
        return packname;
    }

    public void setPackname(String packname) {
        this.packname = packname;
    }

    public String getDiscount_status() {
        return discount_status;
    }

    public void setDiscount_status(String discount_status) {
        this.discount_status = discount_status;
    }

    public String getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(String discount_value) {
        this.discount_value = discount_value;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public String getProduct_availability() {
        return product_availability;
    }

    public void setProduct_availability(String product_availability) {
        this.product_availability = product_availability;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getDate_of_expiry() {
        return date_of_expiry;
    }

    public void setDate_of_expiry(String date_of_expiry) {
        this.date_of_expiry = date_of_expiry;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduct_slug() {
        return product_slug;
    }

    public void setProduct_slug(String product_slug) {
        this.product_slug = product_slug;
    }

    public String getProductByName(String name){
        return product_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Products)) {
            return false;
        }
        Products p = (Products)o;
        return product_name.equals(p.getProduct_name());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(product_id);
        dest.writeString(created_by);
        dest.writeString(category);
        dest.writeString(product_name);
        dest.writeString(batch_number);
        dest.writeString(unit_selling_price);
        dest.writeString(unit_cost_price);
        dest.writeString(unit_wholesale_price);
        dest.writeDouble(unit_margin_value);
        dest.writeString(unit_margin_percentage);
        dest.writeString(quantity_available);
        dest.writeString(low_level_quantity);
        dest.writeString(reference_quantity);
        dest.writeString(packname);
        dest.writeString(discount_status);
        dest.writeString(discount_value);
        dest.writeString(discount_type);
        dest.writeString(product_availability);
        dest.writeString(date_created);
        dest.writeString(last_updated);
        dest.writeString(date_of_expiry);
        dest.writeString(manufacturer);
        dest.writeString(product_slug);
    }
}
