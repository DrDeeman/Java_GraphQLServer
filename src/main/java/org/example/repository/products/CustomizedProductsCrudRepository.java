package org.example.repository.products;

import org.example.entity.eProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedProductsCrudRepository extends CrudRepository<eProducts, Integer> {
}
