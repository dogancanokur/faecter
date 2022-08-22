package net.okur.faector.auth;

import com.fasterxml.jackson.annotation.JsonView;
import net.okur.faector.configuration.FaectorUserDetails;
import net.okur.faector.shared.CurrentUser;
import net.okur.faector.shared.Views;
import net.okur.faector.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0")
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/auth")
    @JsonView(Views.Base.class)
    public ResponseEntity<?> handleAuthentication(@CurrentUser FaectorUserDetails userPrincipal) {
        return ResponseEntity.status(HttpStatus.OK).body(userPrincipal.getUser());
    }
}
