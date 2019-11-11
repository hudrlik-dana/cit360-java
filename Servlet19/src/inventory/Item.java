package inventory;

public class Item {

    private String itemName;
    private int quantity;
    private String url;

    public Item(String itemName, String url, int quantity) {
        super();
        this.itemName = itemName;
        this.quantity = quantity;
        this.url = url;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
