package tz.ac.udom.udomsrlite.datamodels;

/**
 * Created by ali on 3/8/18.
 */

public class Session {

    private String course,
            venue,
            instructor,
            programmes;

    private long time,
            logInTime,
            logOutTime;

    private boolean instructorShowedUp;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getProgrammes() {
        return programmes;
    }

    public void setProgrammes(String programmes) {
        this.programmes = programmes;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(long logInTime) {
        this.logInTime = logInTime;
    }

    public long getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(long logOutTime) {
        this.logOutTime = logOutTime;
    }

    public boolean isInstructorShowedUp() {
        return instructorShowedUp;
    }

    public void setInstructorShowedUp(boolean instructorShowedUp) {
        this.instructorShowedUp = instructorShowedUp;
    }
}
