package org.example.repository.products;

import org.example.entity.eProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomizedProductsCrudRepository extends JpaRepository<eProducts, Integer> {

    @Query(value = "FROM eProducts p JOIN FETCH p.user WHERE p.id=:id")
    Optional<eProducts> findByIdWithUser(int id);
}
