package ru.netology;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ManagerProductTest {

    ManagerProduct manager = new ManagerProduct();
    ManagerProduct oneProduct = new ManagerProduct();
    ManagerProduct allProduct = new ManagerProduct();

    Product bookOne = new Book("Гарри Поттер и философский камень", 1, "Роулинг Джоан Кэтлин");
    Product bookTwo = new Book("Гарри Поттер и Тайная комната", 2,"Роулинг Джоан Кэтлин" );
    Product bookThree = new Book("Гарри Поттер и узник Азкабана", 3,"Роулинг Джоан Кэтлин" );
    Product bookFour = new Book("Гарри Поттер и Кубок Огня", 4,"Роулинг Джоан Кэтлин" );
    Product bookFive = new Book("Гарри Поттер и Орден Феникса", 5,"Роулинг Джоан Кэтлин" );
    Product bookSix = new Book("Гарри Поттер и Принц-полукровка", 6,"Роулинг Джоан Кэтлин" );
    Product smartphoneOne = new Smartphone("Apple 10", 7, "Китай");
    Product smartphoneTwo = new Smartphone("Apple 11", 8, "Китай");
    Product smartphoneThree = new Smartphone("Apple 12", 9, "Китай");
    Product smartphoneFour = new Smartphone("Apple 13", 10, "Китай");


    @BeforeEach
    void setUp() {
        oneProduct.save(bookOne);
        allProduct.save(bookOne);
        allProduct.save(bookTwo);
        allProduct.save(bookThree);
        allProduct.save(bookFour);
        allProduct.save(bookFive);
        allProduct.save(bookSix);
        allProduct.save(smartphoneOne);
        allProduct.save(smartphoneTwo);
        allProduct.save(smartphoneThree);
        allProduct.save(smartphoneFour);


    }


    @Test
    public void saveProduct() {
        manager.save(bookOne);
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{bookOne};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void addOneProductWithOneProductInRepository() {
        oneProduct.save(bookTwo);
        Product[] actual = oneProduct.findAll();
        Product[] expected = new Product[]{bookOne, bookTwo};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddOenProductToAllProduct() {
        Product smartphoneFive = new Smartphone("Apple 14", 11, "Китай");
        allProduct.save(smartphoneFive);
        Product[] actual = allProduct.findAll();
        Product[] expected = new Product[]{
                bookOne, bookTwo, bookThree, bookFour, bookFive, bookSix,
                smartphoneOne, smartphoneTwo, smartphoneThree, smartphoneFour, smartphoneFive};
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldRemoveByIdOneProduct() {
        int id = 1;
        oneProduct.removeId(id);
        Product[] actual = oneProduct.findAll();
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTwoProductToAllProduct() {
        int idBook = 2;
        int idSmartphone = 8;

        allProduct.removeId(idBook);
        allProduct.removeId(idSmartphone);

        Product[] actual = allProduct.findAll();
        Product[] expected = new Product[]{
                bookOne, bookThree, bookFour, bookFive, bookSix,
                smartphoneOne, smartphoneThree, smartphoneFour};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByIdToAllProduct() {
        allProduct.searchBy("Гарри Поттер и философский камень");
        Product[] actual = allProduct.searchBy("Гарри Поттер и философский камень");
        Product[] expected = new Product[]{bookOne};
        assertArrayEquals(expected, actual);
    }



    @Test
    void shouldMatchesTrue() {
        assertTrue(manager.matches(smartphoneOne, "Apple 10"));
    }

    @Test
    void shouldMatchesFalse() {
        assertFalse(manager.matches(smartphoneOne, "Mi"));
    }





}