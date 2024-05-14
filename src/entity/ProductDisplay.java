package entity;

public class ProductDisplay {
    private String name;
    private String description;
    private String price;
    private String vendorName;
    private String categoryName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductDisplay(String name, String description, String price, String vendorName, String categoryName) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vendorName = vendorName;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDisplay{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
