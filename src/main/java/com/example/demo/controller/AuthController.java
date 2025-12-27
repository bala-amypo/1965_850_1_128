// package sbs.rosedev.springFirst.controller;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import sbs.rosedev.springFirst.dto.AuthRequest;
// import sbs.rosedev.springFirst.dto.AuthResponse;
// import sbs.rosedev.springFirst.entity.UserAccount;
// import sbs.rosedev.springFirst.services.AuthService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthService authService;

//     public AuthController(AuthService authService) {
//         this.authService = authService;
//     }

//     @PostMapping("/register")
//     public UserAccount register(
//             @RequestBody UserAccount user) {
//         return authService.register(user);
//     }

//     @PostMapping("/login")
//     public AuthResponse login(
//             @RequestBody AuthRequest request) {
//         return authService.login(request);
//     }
// }
