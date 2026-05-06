
class Invoice implements Payable {

    String productName;
    int quantity;
    int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    public void display() {
        System.out.println("Produk\t\t: " + productName);
        System.out.println("Jumlah\t\t: " + quantity);
        System.out.println("Harga/item\t\t: " + pricePerItem);
        System.out.println("Total\t\t: " + getPayableAmount());
    }
}
