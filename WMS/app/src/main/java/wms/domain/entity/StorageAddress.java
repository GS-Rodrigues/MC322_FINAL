package wms.domain.entity;

public class StorageAddress {
    private String shelf;
    private int quantity; // <- adicione isso se você quiser controlar por prateleira

    public StorageAddress(String shelf, int quantity) {
        this.shelf = shelf;
        this.quantity = quantity;
    }

    public String getShelf() { return shelf; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isEmpty() { return quantity == 0; }
}

