package bean;

import java.io.Serializable;

public class GameDate implements Serializable{
    private User user;
    private Point point;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public GameDate() {

    }

}
