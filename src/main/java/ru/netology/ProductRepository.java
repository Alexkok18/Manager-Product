package ru.netology;


import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ProductRepository {

    protected Product[] items = new Product[0];

    public Product[] getItems() {
        return items;
    }

    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public void save(Product save) {
        if (findById(save.getId()) != null) {
            throw new AlreadyExistsException("Товар с id: " + save.getId() + " уже добавлен в корзину.");
        }
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
        if (findById(id) == null) {
            throw new NotFoundException("Товар с id: " + id + " не найден.");
        }
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
