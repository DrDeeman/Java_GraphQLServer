package org.example.graphql.queries;

import graphql.com.google.common.collect.Lists;
import org.example.entity.eUsers;
import org.example.repository.products.CustomizedUsersCrudRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQuery {

    private final CustomizedUsersCrudRepository usersRepository;

    UserQuery(
            CustomizedUsersCrudRepository usersRepository
    ){
        this.usersRepository = usersRepository;
    }

    @QueryMapping
    public List<eUsers> getUsersAll(){
        var iter = usersRepository.findAll().iterator();
        iter.forEachRemaining(action->{
            System.out.println(action.getProducts().size());
        });
        return Lists.newArrayList(usersRepository.findAll());
    }

}
