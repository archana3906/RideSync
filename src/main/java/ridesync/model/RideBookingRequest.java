package ridesync.model;

public class RideBookingRequest {
    private Long passengerId;
    private Location pickupLocation;
    private Location dropLocation;

    public RideBookingRequest() {}

    public Long getPassengerId() { return passengerId; }
    public void setPassengerId(Long passengerId) { this.passengerId = passengerId; }

    public Location getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(Location pickupLocation) { this.pickupLocation = pickupLocation; }

    public Location getDropLocation() { return dropLocation; }
    public void setDropLocation(Location dropLocation) { this.dropLocation = dropLocation; }
}