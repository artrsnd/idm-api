package cloud.security.service;

import cloud.security.model.representation.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class UserService {
    public List<User> getUsers() {
        return Arrays.asList(User.builder().id(UUID.randomUUID()).username("admin").build(),
                User.builder().id(UUID.randomUUID()).username("root").build());
    }

    public User getUser(UUID uuid) {
        return User.builder().id(uuid).username("admin").build();
    }
}
