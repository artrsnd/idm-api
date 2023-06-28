package cloud.security.model.representation;

import cloud.security.api.UserEndpoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id;
    private String username;

    public abstract static class ResponseModel {
        public static EntityModel<User> assemble(User user) {
            Objects.requireNonNull(user);

            EntityModel<User> userModel = EntityModel.of(user);

            userModel.add(WebMvcLinkBuilder.linkTo(UserEndpoint.class).slash(user.getId()).withSelfRel());

            return userModel;
        }
    }
}


