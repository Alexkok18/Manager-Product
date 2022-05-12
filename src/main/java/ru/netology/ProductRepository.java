package ru.netology;


import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ProductRepository {

    protected Product[] items = new Product[0];

    public Product[] getItems() {
        return items;
    }


    public void save(Product save) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = save;
        items = tmp;

    }

    public Product[] findAll() {

        return getItems();
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index++] = item;
            }


        }
        items = tmp;

    }


}
