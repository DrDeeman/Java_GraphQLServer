package org.example.graphql.mutations;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.ProductInput;
import org.example.entity.eProducts;
import org.example.entity.eUsers;
import org.example.repository.products.CustomizedProductsCrudRepository;
import org.example.repository.products.CustomizedUsersCrudRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
public class ProductMutation {

    private final CustomizedUsersCrudRepository usersRepository;

    private final CustomizedProductsCrudRepository productsRepository;

    ProductMutation(
            CustomizedUsersCrudRepository usersRepository,
            CustomizedProductsCrudRepository productsRepository
    ) {
        this.usersRepository = usersRepository;
        this.productsRepository = productsRepository;
    }

    @MutationMapping
    public eUsers createOrUpdateProduct(@Argument ProductInput productInput) {
        eUsers user = this.usersRepository.findById(productInput.userId()).orElseThrow();
        eProducts product = new eProducts(
                productInput.name(),
                BigDecimal.valueOf(productInput.price()),
                LocalDateTime.parse(productInput.year_issue(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                productInput.raiting(),
                "",
                user
        );

        product.setId(productInput.id());
        user.addProduct(product);
        return this.usersRepository.saveAndFlush(user);
    }


    @MutationMapping
    public boolean deleteProduct(@Argument int id) {
        this.productsRepository.deleteById(id);
        return productsRepository.findById(id).isEmpty();
    }
}
