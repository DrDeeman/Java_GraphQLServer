package org.example.graphql.mutations;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserInput;
import org.example.entity.eUsers;
import org.example.repository.products.CustomizedUsersCrudRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class UserMutation {

    private final CustomizedUsersCrudRepository usersRepository;

    UserMutation(
            CustomizedUsersCrudRepository usersRepository
    ) {
        this.usersRepository = usersRepository;
    }

    @MutationMapping
    public eUsers createOrUpdateUser(@Argument UserInput userInput) {
        eUsers user = new eUsers(userInput.name(), userInput.login(), userInput.password(), userInput.email(), List.of());
        user.setId(userInput.id());
        return this.usersRepository.saveAndFlush(user);
    }


}
