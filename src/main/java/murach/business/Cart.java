package murach.business;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<LineItem> items;
    public Cart() {
        items = new ArrayList<>();
    }
    public ArrayList<LineItem> getItems() {
        return items;
    }
    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (LineItem lineItem : items) {
            if (lineItem.getProduct().getCode().equals(code)){
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    public void updateQuantity(String code, int quantity) {
        for (LineItem lineItem : items) {
            if (lineItem.getProduct().getCode().equals(code)) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
    }
    public void removeItem(String code) {
        items.removeIf(lineItem -> lineItem.getProduct().getCode().equals(code));
    }
}
