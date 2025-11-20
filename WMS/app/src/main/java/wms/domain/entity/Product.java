package wms.domain.entity;

import java.util.List;

public class Product {
    private String code;
    private String name;
    private String supplier;
    private String supplierphone;
    private List<StorageAddress> address;
    private int currentquantity;
    private int minquantity;
    private int maxquantity;

    public Product(String code, String name, String supplier, String supplierphone,
            int currentquantity, int minquantity, int maxquantity) {

        this.code = code;
        this.name = name;
        this.supplier = supplier;
        this.supplierphone = supplierphone;
        this.currentquantity = currentquantity;
        this.minquantity = minquantity;
        this.maxquantity = maxquantity;
    }

    protected String getCode() {
        return this.code;
    }

    protected String getName() {
        return this.name;
    }

    protected String getSupplier() {
        return this.supplier;
    }

    protected String getSupplierPhone() {
        return this.supplierphone;
    }

    protected List<StorageAddress> getAddress() {
        return this.address;
    }

    protected int getCurrentQuantity() {
        return this.currentquantity;
    }

    protected int getMinQuantity() {
        return this.minquantity;
    }

    protected int getMaxQuantity() {
        return this.maxquantity;
    }

    protected void add(int quantity, StorageAddress address) {
        this.currentquantity = this.currentquantity + quantity;
        address.quantity = quantity;
        this.address.add(address);
    }

    protected void remove(int quantity) {
        this.currentquantity = this.currentquantity - quantity;
        while (quantity > 0) {
            if (address.get(0).quantity <= quantity) {
                quantity = quantity - address.get(0).quantity;
                this.address.remove(0);
            }
            else{
                this.address(0) = this.address(0) - quantity;
                quantity = 0;
            }
        }
    }

}
