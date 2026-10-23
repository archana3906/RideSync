package ridesync.controller;

import ridesync.model.User;
import ridesync.model.Passenger;
import ridesync.model.Driver;
import ridesync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/passengers")
    public ResponseEntity<?> registerPassenger(@RequestBody Passenger passenger) {
        try {
            Passenger saved = userService.registerPassenger(passenger);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/drivers")
    public ResponseEntity<?> registerDriver(@RequestBody Driver driver) {
        try {
            Driver saved = userService.registerDriver(driver);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String phone = loginData.get("phone");
        String password = loginData.get("password");

        User user = userService.login(phone, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid phone or password");
        }
    }
}