import java.time.LocalDateTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * class for where the order for the coffee will be picked up
 * @author Yunis Tamang
 */
public class PickUpLocation {
    private Date pickupTime;
    private branches location;
    private List<Coffee> theOrder;

    /**
     * constructor for the class
     * @param time time of pickup
     * @param place place of pickup
     * @param orders the order to be picked up
     */
    public PickUpLocation(Date time, branches place, List<Coffee> orders){
        pickupTime = time;
        location = place;
        theOrder = orders;
    }

    /**
     * branches for the coffee to be picked up from
     */
    enum branches{
        CORONADO,
        HILLSCREST,
        CALRSBAD
    }

    /**
     * gets date of pickup
     * @return  pickupTime
     */
    public Date getPickupTime(){
        return pickupTime;
    }

    /**
     * gets pickupLocation
     * @return location
     */
    public branches getPickUpLocation(){
        return location;
    }




}
