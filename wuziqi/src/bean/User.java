package bean;

import Util.Chessboard;

import java.io.Serializable;

/**
 * 游戏玩家
 */
public class User implements Serializable{
    private String userName;
    private int Color;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        Color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (Color != user.Color) return false;
        return userName != null ? userName.equals(user.userName) : user.userName == null;
    }

}
