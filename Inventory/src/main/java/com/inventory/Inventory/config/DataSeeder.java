package com.inventory.Inventory.config;

import com.inventory.Inventory.model.Category;
import com.inventory.Inventory.model.Product;
import com.inventory.Inventory.repository.CategoryRepository;
import com.inventory.Inventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Runs whenever application starts. Populates with dummy data
@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //Categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        //Products
        Product phone = new Product();
        phone.setName("Phone");
        phone.setDescription("smartphone with amazing features. Very new");
        phone.setImageUrl("https://ik.imagekit.io/3dqckpw4d/upload/1694593711Untitled%20design%20(21).png");
        phone.setPrice(75000.00);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("new laptop with amazing features. Latest model");
        laptop.setImageUrl("https://quicktech.in/cdn/shop/files/MBP14-inch_M3Pro_2.jpg?v=1704279230&width=1445");
        laptop.setPrice(125000.00);
        laptop.setCategory(electronics);

        Product windBreaker = new Product();
        windBreaker.setName("Wind Breaker");
        windBreaker.setDescription("Black coloured wind cheater");
        windBreaker.setImageUrl("https://cdn.staticans.com/image/tr:e-sharpen-01,h-1355,w-1080,cm-pad_resize/catalog/adventuras/product/KE3972-396/KE3972-396-1.jpg");
        windBreaker.setPrice(15000.00);
        windBreaker.setCategory(clothing);

        Product jeans = new Product();
        jeans.setName("Jeans");
        jeans.setDescription("Blue coloured denim jeans");
        jeans.setImageUrl("https://levi.pt/content/img/900x1200/levis_jeam_masculino_501-original-fit-jeans-00501-0114_stonewash_9.jpg");
        jeans.setPrice(2500.00);
        jeans.setCategory(clothing);

        Product stove = new Product();
        stove.setName("Stove");
        stove.setDescription("Stove with amazing features. Instant defrost. Black");
        stove.setImageUrl("https://glenindia.com/cdn/shop/files/1_e5c26f20-0562-4456-81b2-a44ed07af34a_1200x1200.webp?v=1708924690");
        stove.setPrice(35000.00);
        stove.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, windBreaker, jeans, stove));
    }
}
