package ridesync.controller;

import ridesync.model.Ride;
import ridesync.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
@CrossOrigin(origins = "*")
public class RideController {

    @Autowired
    private RideService rideService;

    @GetMapping
    public ResponseEntity<List<Ride>> getAllRides() {
        return ResponseEntity.ok(rideService.getAllRides());
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<Ride>> getRidesByPassenger(@PathVariable Long passengerId) {
        return ResponseEntity.ok(rideService.getRidesByPassenger(passengerId));
    }

    @PostMapping("/book")
    public ResponseEntity<?> bookRide(@RequestBody Ride rideRequest) {
        try {
            Ride bookedRide = rideService.bookRide(
                    rideRequest.getPassengerId(),
                    rideRequest.getPickupLocation(),
                    rideRequest.getDropLocation()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(bookedRide);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error booking ride: " + e.getMessage());
        }
    }

    @PostMapping("/{rideId}/accept")
    public ResponseEntity<?> acceptRide(@PathVariable Long rideId, @RequestParam Long driverId) {
        try {
            Ride acceptedRide = rideService.acceptRide(rideId, driverId);
            return ResponseEntity.ok(acceptedRide);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/{rideId}/pay")
    public ResponseEntity<?> payForRide(@PathVariable Long rideId) {
        try {
            Ride completedRide = rideService.completePayment(rideId);
            return ResponseEntity.ok(completedRide);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}