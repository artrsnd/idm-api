package cloud.security.api;


import cloud.security.model.representation.User;
import cloud.security.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UsersEndpoint {

    @NonNull
    private UserService userService;

    @Operation(operationId = "getUsers", description = "Get all users registered in the system.")
    @ApiResponse(code = 200, message = "OK - Successfully retrieved the users")
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<EntityModel<User>> getUsers() {
        List<User> users = this.userService.getUsers();

        return Flux.fromIterable(users)
                .flatMap(user -> Mono.just(User.ResponseModel.assemble(user)));
    }
}
