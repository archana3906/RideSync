package ridesync.model;

import jakarta.persistence.*;

@Entity
public class Driver extends User {

    private boolean availability = true;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "driver_lat")),
            @AttributeOverride(name = "longitude", column = @Column(name = "driver_lng")),
            @AttributeOverride(name = "address", column = @Column(name = "driver_address"))
    })
    private Location currentLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Driver() {}

    public boolean acceptRide() { return true; }
    public void updateLocation() {}
    public void completeRide() {}

    // Getters and Setters
    public boolean isAvailability() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }

    public Location getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(Location currentLocation) { this.currentLocation = currentLocation; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}