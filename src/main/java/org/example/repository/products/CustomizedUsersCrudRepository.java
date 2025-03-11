package org.example.repository.products;

import org.example.entity.eUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedUsersCrudRepository extends CrudRepository<eUsers, Integer> {
}
