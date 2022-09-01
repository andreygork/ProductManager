package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductPepository;

public class ProductManagerTest {
    private ProductPepository repo = new ProductPepository();
    private ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Граф Монте Кристо", 700, "Александр Дюма");
    Product product2 = new Book(2, "Белый клык", 500, "Джек Лондон");
    Product product3 = new Book(3, "Гарри поттер", 1100, "Джоан Роулинг");
    Product product4 = new Smartphone(4, "Iphone 13", 82_000, "Apple");
    Product product5 = new Smartphone(5, "Samsung S21", 69_000, "Samsung");
    Product product6 = new Smartphone(6, "Honor 50", 21_000, "Honor");

    @BeforeEach
    public void setup() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
    }

    @Test
    public void SearchByBookName() {
        Product[] expected = new Product[]{product2};
        Product[] actual = manager.searchBy("Белый клык");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchByInvalidSmartphoneName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Iphone 6S");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchByBookNameWhenEmpty() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Десять негритят");
        Assertions.assertArrayEquals(expected, actual);
    }
}