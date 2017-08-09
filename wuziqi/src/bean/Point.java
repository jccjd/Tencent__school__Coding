package bean;

import java.io.Serializable;

/**
 * 棋盘落子的信息
 */
public class Point implements Serializable{
    private int x;
    private int y;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Point(int x, int y, int score) {

        this.x = x;
        this.y = y;
        this.score = score;
    }

    public Point(int score) {

        this.score = score;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point() {
    }

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }
}
