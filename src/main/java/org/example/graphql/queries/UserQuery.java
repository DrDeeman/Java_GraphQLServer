package org.example.graphql.queries;

import graphql.com.google.common.collect.Lists;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.eUsers;
import org.example.repository.products.CustomizedUsersCrudRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class UserQuery {

    private final CustomizedUsersCrudRepository usersRepository;

    UserQuery(
            CustomizedUsersCrudRepository usersRepository
    ){
        this.usersRepository = usersRepository;
    }

    @QueryMapping
    public List<eUsers> getUsersAll(DataFetchingEnvironment data){
        if(data.getSelectionSet().contains("products")){
            return Lists.newArrayList(usersRepository.findAllWithProducts());
        }
        return Lists.newArrayList(usersRepository.findAll());
    }

}
