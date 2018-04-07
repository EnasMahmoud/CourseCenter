package pro.phoenix.coursecenter;

/**
 * Created by ANNAS on 3/14/2018.
 */

public class Room {
    boolean availability;
    double coast;
    boolean airc;
    boolean dataShow;
    String roomName;

    public Room() {
    }

    public Room(boolean availability, double coast, boolean airc, boolean dataShow, String roomName) {
        this.availability = availability;
        this.coast = coast;
        this.airc = airc;
        this.dataShow = dataShow;
        this.roomName = roomName;
    }

    public boolean getAvailability() {
        return availability;
    }

    public double getCoast() {
        return coast;
    }

    public boolean getAirc() {
        return airc;
    }

    public boolean getDataShow() {
        return dataShow;
    }

    public String getRoomName() {
        return roomName;
    }
}
