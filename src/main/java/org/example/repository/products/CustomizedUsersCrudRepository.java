package org.example.repository.products;

import org.example.entity.eUsers;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomizedUsersCrudRepository extends JpaRepository<eUsers, Integer> {

    //@EntityGraph(value = "allJoinsWithProducts" , type= EntityGraph.EntityGraphType.FETCH)
    @Query(value = "FROM eUsers u JOIN FETCH u.products")
    //@Query(value = "SELECT u, p FROM eUsers u JOIN eProducts p ON u.id = p.id")
    //@Query(value = """
      //   SELECT users.id AS userId, users.name AS userName, users.login, users.password, users.email, products.*
       //   FROM users LEFT JOIN products ON users.id = products.user_id
       //  """, nativeQuery = true)
    List<eUsers> findAllWithProducts();


}
