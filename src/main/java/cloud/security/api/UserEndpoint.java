package cloud.security.api;

import cloud.security.model.representation.User;
import cloud.security.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserEndpoint {
    // Injected automatically via Constructor by Spring Dependency Inversion
    @NonNull
    private UserService userService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<EntityModel<User>> getUserById(@PathVariable String id) {
        UUID userId;
        EntityModel<User> entityModel;
        User user;

        if (StringUtils.isBlank(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        try {
            userId = UUID.fromString(id.trim());
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is invalid.");
        }

        user = this.userService.getUser(userId);

        return Mono.justOrEmpty(User.ResponseModel.assemble(user));
    }
}
