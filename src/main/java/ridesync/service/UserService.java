package ridesync.service;

import ridesync.model.User;
import ridesync.model.Passenger;
import ridesync.model.Driver;
import ridesync.repository.UserRepository;
import ridesync.repository.PassengerRepository;
import ridesync.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private DriverRepository driverRepository;

    public Passenger registerPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Driver registerDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public User login(String phone, String password) {
        List<User> users = userRepository.findByPhone(phone);

        for (User user : users) {
            if (user.getPassword() != null && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}