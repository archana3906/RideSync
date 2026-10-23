package ridesync.service;

import ridesync.model.Ride;
import ridesync.model.Location;
import ridesync.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    public Ride bookRide(Long passengerId, Location pickup, Location drop) {
        Ride ride = new Ride();
        ride.setPassengerId(passengerId);
        ride.setPickupLocation(pickup);
        ride.setDropLocation(drop);
        ride.setFare(150.0); // Estimated base fare
        ride.setStatus("PENDING");

        return rideRepository.save(ride);
    }

    public Ride acceptRide(Long rideId, Long driverId) {
        Optional<Ride> rideOpt = rideRepository.findById(rideId);
        if (rideOpt.isPresent()) {
            Ride ride = rideOpt.get();
            ride.setDriverId(driverId);
            ride.setStatus("ACCEPTED");
            return rideRepository.save(ride);
        }
        throw new RuntimeException("Ride not found with ID: " + rideId);
    }

    public Ride completePayment(Long rideId) {
        Optional<Ride> rideOpt = rideRepository.findById(rideId);
        if (rideOpt.isPresent()) {
            Ride ride = rideOpt.get();
            ride.setStatus("COMPLETED");
            return rideRepository.save(ride);
        }
        throw new RuntimeException("Ride not found with ID: " + rideId);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public List<Ride> getRidesByPassenger(Long passengerId) {
        return rideRepository.findByPassengerId(passengerId);
    }
}