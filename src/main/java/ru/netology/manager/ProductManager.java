package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductPepository;

public class ProductManager {
    private ProductPepository repo;

    public ProductManager(ProductPepository repo) {
        this.repo = repo;
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.FindAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
            return result;
    }
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}


