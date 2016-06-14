import java.text.DecimalFormat;
import java.util.LinkedHashMap;

/**
 * Design a Cash Register
 */
public class CashRegister {

    LinkedHashMap<Item,Integer> itemList = new LinkedHashMap<>();
    final double salesTax = 0.0775;

    private static class Item {
        String name;
        double price;

        protected Item(String n, double p, int c) {
            this.name = n;
            this.price = p;
        }
    }

    public void printItemList() {
        if(itemList.size() == 0) return;
        DecimalFormat df = new DecimalFormat("#.00");
        for(Item i : itemList.keySet()) {
            System.out.print(itemList.get(i) + " " + i.name + " $" + df.format(i.price));
        }
    }

    public double calcTotal() {
        double total = 0;
        for(Item i : itemList.keySet()) {
            total = i.price * itemList.get(i);
        }
        return total * salesTax;
    }

    public void addItem(Item i) {
        if(!itemList.containsKey(i))
            itemList.put(i,1);
        else {
            int val = itemList.get(i);
            itemList.put(i,++val);
        }
    }

    public boolean hasItem(Item i) {
        return itemList.containsKey(i);
    }

    public void removeItem(Item i) {
        itemList.remove(i);
    }

    public void modifyItemName(Item i, String newName) {
        if(!itemList.containsKey(i)) return;
        int count = itemList.get(i);
        itemList.remove(i);
        i.name = newName;
        itemList.put(i,count);
    }

    public void modifyItemCount(Item i, int newCount) {
        if(!itemList.containsKey(i)) return;
        itemList.put(i,newCount);
    }

    public int getItemCount(Item i) {
        if(!itemList.containsKey(i)) return -1;
        return itemList.get(i);
    }

}
