package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    private ProductPepository repo = new ProductPepository();

    Product product1 = new Book(1, "Граф Монте Кристо", 700, "Александр Дюма");
    Product product2 = new Book(2, "Белый клык", 500, "Джек Лондон");
    Product product3 = new Book(3, "Гарри поттер", 1100, "Джоан Роулинг");
    Product product4 = new Smartphone(4, "Iphone 13", 82_000, "Apple");
    Product product5 = new Smartphone(5, "Samsung S21", 69_000, "Samsung");
    Product product6 = new Smartphone(6, "Honor 50", 21_000, "Honor");


    @Test
    public void ShouldSaveProducts() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        Product[] expected = new Product[]{product1, product2, product3};
        Product[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSaveProductsWhen1Product() {
        repo.save(product3);
        Product[] expected = new Product[]{product3};
        Product[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.RemoveById(4);

        Product[] expected = new Product[]{product1, product2, product3, product5, product6};
        Product[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldGetEmpty() {
        Product[] expected = new Product[]{};
        Product[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}