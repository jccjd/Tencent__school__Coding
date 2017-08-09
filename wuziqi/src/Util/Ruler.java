package Util;

public class Ruler {
    private int[][] ChessMan;

    private static final int FIVE = 1000;
    public static final int FOUR_LIVE = 90;
    public static final int FOUR_DEAD = 60;
    public static final int THREE_LIVE = 50;
    public static final int THREE_DEAD =30;
    public static final int TWO_LIVE = 20;
    public static final int TWO_DEAD = 10;
    public int[][] getChessMan() {
        return ChessMan;
    }

    public void setChessMan(int[][] chessMan) {
        ChessMan = chessMan;
    }

    public Ruler(int[][] chessMan) {
        ChessMan = chessMan;
    }

    public int isOver() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                /*横向判断*/
                if (x + 4 <15&&ChessMan[x][y] == 1 && ChessMan[x+1][y] == 1 && ChessMan[x+2][y] == 1
                        && ChessMan[x+3][y] == 1 && ChessMan[x+4][y] == 1) {
                    return 1;
                }else if (x + 4 <15&&ChessMan[x][y] == 2 && ChessMan[x+1][y] == 2 && ChessMan[x+2][y] == 2
                        && ChessMan[x+3][y] == 2 && ChessMan[x+4][y] == 2) {
                    return 2;
                }
                /*纵向判断*/
                if (y + 4 <15&&ChessMan[x][y] == 1 && ChessMan[x][y+1] == 1 && ChessMan[x][y+2] == 1
                        && ChessMan[x][y+3] == 1 && ChessMan[x][y+4] == 1) {
                    return 1;
                }else if (y + 4 <15&&ChessMan[x][y] == 2 && ChessMan[x][y+1] == 2 && ChessMan[x][y+2] == 2
                        && ChessMan[x][y+3] == 2 && ChessMan[x][y+4] == 2) {
                    return 2;
                }
                /*左斜下判断*/
                if (x - 4 > 0&&y + 4 <15&&ChessMan[x][y] == 1 && ChessMan[x-1][y+1] == 1 && ChessMan[x-2][y+2] == 1
                        && ChessMan[x-3][y+3] == 1 && ChessMan[x-4][y+4] == 1) {
                    return 1;
                }else if (x - 4 > 0&&y + 4 <15&&ChessMan[x][y] == 2 && ChessMan[x-1][y+1] == 2 && ChessMan[x-2][y+2] == 2
                        && ChessMan[x-3][y+3] == 2 && ChessMan[x-4][y+4] == 2) {
                    return 2;
                }
                /*右斜下判断*/
                if (y+4<15&&x + 4 <15&&ChessMan[x][y] == 2 && ChessMan[x+1][y+1] == 2 && ChessMan[x+2][y+2] == 2
                        && ChessMan[x+3][y+3] == 2 && ChessMan[x+4][y+4] == 2) {
                    return 2;
                } else if (x + 4 <15 && y + 4 <15 &&ChessMan[x][y] == 1 && ChessMan[x+1][y+1] == 1 && ChessMan[x+2][y+2] == 1
                        && ChessMan[x+3][y+3] == 1 && ChessMan[x+4][y+4] == 1) {
                    return 1;
                }
            }
        }

        return 0;
    }
    public int calScore(int x,int y,int color){

        //成5, 1000分 20种棋形
        int score=0;
        //X0000
        if(ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==color&&ChessMan[x+4][y]==color){
            score+=FIVE;
        }
        //0X000
        if(x-1>=0&&ChessMan[x-1][y]==color&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==color){
            score+=FIVE;
        }
        //00X00
        if(x-2>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color){
            score+=FIVE;
        }
        //000X0
        if(x-3>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==color&&ChessMan[x+1][y]==color){
            score+= FIVE;
        }
        //0000X
        if(x-4>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==color&&ChessMan[x-4][y]==color){
            score+=FIVE;
        }

        /**
         * x
         * 0
         * 0
         * 0
         * 0
         */
        if(ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==color&&ChessMan[x][y+4]==color){
            score+=FIVE;
        }
        /**
         * 0
         * x
         * 0
         * 0
         * 0
         */
        if(y-1>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==color){
            score+=FIVE;
        }
        /**
         * 0
         * 0
         * x
         * 0
         * 0
         */
        if(y-2>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color){
            score+=FIVE;
        }
        /**
         * 0
         * 0
         * 0
         * x
         * 0
         */
        if(y-3>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==color&&ChessMan[x][y+1]==color){
            score+=FIVE;
        }
        /**
         * 0
         * 0
         * 0
         * 0
         * x
         */
        if(y-4>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==color&&ChessMan[x][y-4]==color){
            score+=FIVE;
        }
        /**    x
         *    0
         *   0
         *  0
         * 0
         */
        if(x-4>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==color&&ChessMan[x-4][y+4]==color){
            score+=FIVE;
        }
        /**    0
         *    x
         *   0
         *  0
         * 0
         */
        if(x-3>=0&&y-1>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==color){
            score+=FIVE;
        }
        /**    0
         *    0
         *   x
         *  0
         * 0
         */
        if(x-2>=0&&y-2>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color){
            score+=FIVE;
        }
        /**    0
         *    0
         *   0
         *  x
         * 0
         */
        if(x-1>=0&&y-3>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==color&&ChessMan[x-1][y+1]==color){
            score+=FIVE;
        }
        /**    0
         *    0
         *   0
         *  0
         * x
         */
        if(y-4>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==color&&ChessMan[x+4][y-4]==color){
            score+=FIVE;
        }
        /**
         * x
         *  0
         *   0
         *    0
         *     0
         */
        if(ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==color&&ChessMan[x+4][y+4]==color){
            score+=FIVE;
        }
        /**
         * 0
         *  x
         *   0
         *    0
         *     0
         */
        if(x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==color){
            score+=FIVE;
        }
        /**
         * 0
         *  0
         *   x
         *    0
         *     0
         */
        if(x-2>=0&&y-2>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color){
            score+=FIVE;
        }
        /**
         * 0
         *  0
         *   0
         *    x
         *     0
         */
        if(x-3>=0&&y-3>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==color&&ChessMan[x-4][y-4]==color){
            score+=FIVE;
        }
        /**
         * 0
         *  0
         *   0
         *    0
         *     x
         */
        if(x-4>=0&&y-4>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==color&&ChessMan[x-4][y-4]==color){
            score+=FIVE;
        }
        //活4
        //_x000_
        if(x-1>=0&&ChessMan[x-1][y]==0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==color&&ChessMan[x+4][y]==0){
            score+=FOUR_LIVE;
        }
        //_0x00_
        if(x-2>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==0){
            score+=FOUR_LIVE;
        }
        //_00x0_
        if(x-3>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==0){
            score+=FOUR_LIVE;
        }
        //_000x_
        if(x-4>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==color&&ChessMan[x-4][y]==0&&ChessMan[x+1][y]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         * x
         * 0
         * 0
         * 0
         * _
         */
        if(y-1>=0&&ChessMan[x][y-1]==0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==color&&ChessMan[x][y+4]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         * 0
         * x
         * 0
         * 0
         * _
         */
        if(y-2>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         * 0
         * 0
         * x
         * 0
         * _
         */
        if(y-3>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         * 0
         * 0
         * 0
         * x
         * _
         */
        if(y-4>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==color&&ChessMan[x][y-4]==0&&ChessMan[x][y+1]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         *  x
         *   0
         *    0
         *     0
         *      _
         */
        if(x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]==0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==color&&ChessMan[x+4][y+4]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         *  0
         *   x
         *    0
         *     0
         *      _
         */
        if(x-2>=0&&y-2>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         *  0
         *   0
         *    x
         *     0
         *      _
         */
        if(x-3>=0&&y-3>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==0){
            score+=FOUR_LIVE;
        }
        /**
         * _
         *  0
         *   0
         *    0
         *     X
         *      _
         */
        if(x-4>=0&&y-4>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==color&&ChessMan[x-4][y-4]==0&&ChessMan[x+1][y+1]==0){
            score+=FOUR_LIVE;
        }
        /**
         *      _
         *     x
         *    0
         *   0
         *  0
         * _
         */
        if(x-4>=0&&y-1>=0&&ChessMan[x+1][y-1]==0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==color&&ChessMan[x-4][y+4]==0){
            score+=FOUR_LIVE;
        }
        /**
         *      _
         *     0
         *    x
         *   0
         *  0
         * _
         */
        if(x-3>=0&&y-2>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==0){
            score+=FOUR_LIVE;
        }
        /**
         *      _
         *     0
         *    0
         *   x
         *  0
         * _
         */
        if(x-2>=0&&y-3>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==0){
            score+=FOUR_LIVE;
        }
        /**
         *      _
         *     0
         *    0
         *   0
         *  x
         * _
         */
        if(x-1>=0&&y-4>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==color&&ChessMan[x+4][y-4]==0&&ChessMan[x-1][y+1]==0){
            score+=FOUR_LIVE;
        }

        //死4
        //●x○○○_
        if((x==0||(x-1>=0&&ChessMan[x-1][y]!=color))&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==color&&ChessMan[x+4][y]==0){
            score+=FOUR_DEAD;
        }
        //●○x○○_
        if((x-1==0||(x-2>=0&&ChessMan[x-2][y]!=color))&&x-1>=0&&ChessMan[x-1][y]==color&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==0){
            score+=FOUR_DEAD;
        }
        //●○○x○_
        if((x-2==0||(x-3>=0&&ChessMan[x-3][y]!=color))&&x-2>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==0){
            score+=FOUR_DEAD;
        }
        //●○○○x_
        if((x-3==0||(x-4>=0&&ChessMan[x-4][y]!=color))&&x-3>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==color&&ChessMan[x+1][y]==0){
            score+=FOUR_DEAD;
        }
        //_○○○x●
        if((x==14||(x+1<=14&&ChessMan[x+1][y]!=color))&&x-4>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==color&&ChessMan[x-4][y]==0){
            score+=FOUR_DEAD;
        }
        //_○○x○●
        if((x+1==14||(x+2<=14&&ChessMan[x+2][y]!=color))&&x-3>=0&&ChessMan[x+1][y]==color&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==0){
            score+=FOUR_DEAD;
        }
        //_○x○○●
        if((x+2==14||(x+3<=14&&ChessMan[x+3][y]!=color))&&x-2>=0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==0){
            score+=FOUR_DEAD;
        }
        //_x○○○●
        if((x==14||(x+4<=14&&ChessMan[x+4][y]!=color))&&x-1>=0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==color&&ChessMan[x-1][y]==0){
            score+=FOUR_DEAD;
        }

        /**
         * ●
         * x
         * ○
         * ○
         * ○
         * _
         */
        if((y==0||(y-1>=0&&ChessMan[x][y-1]!=color))&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==color&&ChessMan[x][y+4]==0){
            score+=FOUR_DEAD;
        }
        /**
         * ●
         * o
         * x
         * ○
         * ○
         * _
         */
        if((y-1==0||(y-2>=0&&ChessMan[x][y-2]!=color))&&y-1>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==0){
            score+=FOUR_DEAD;
        }
        /**
         * ●
         * o
         * o
         * x
         * ○
         * _
         */
        if((y-2==0||(y-3>=0&&ChessMan[x][y-3]!=color))&&y-2>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==0){
            score+=FOUR_DEAD;
        }
        /**
         * ●
         * o
         * o
         * o
         * x
         * _
         */
        if((y-3==0||(y-4>=0&&ChessMan[x][y-4]!=color))&&y-3>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==color&&ChessMan[x][y+1]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         * o
         * o
         * o
         * x
         * ●
         */
        if((y==14||(y+1<=14&&ChessMan[x][y+1]!=color))&&y-4>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==color&&ChessMan[x][y-4]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         * o
         * o
         * x
         * o
         * ●
         */
        if((y+1==14||(y+2<=14&&ChessMan[x][y+2]!=color))&&y-3>=0&&ChessMan[x][y+1]==color&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         * o
         * x
         * o
         * o
         * ●
         */
        if((y+2==14||(y+3<=14&&ChessMan[x][y+3]!=color))&&y-2>=0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         * x
         * o
         * o
         * o
         * ●
         */
        if((y+3==14||(y+4<=14&&ChessMan[x][y+4]!=color))&&y-1>=0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==color&&ChessMan[x][y-1]==0){
            score+=FOUR_DEAD;
        }
        /**
         * ●
         *  x
         *   o
         *    o
         *     o
         *      _
         */
        if((x==0||y==0||(x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]!=color))&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==color&&ChessMan[x+4][y+4]==0){
            score+=FOUR_DEAD;
        }
        /**
         * ●
         *  o
         *   x
         *    o
         *     o
         *      _
         */
        if((x-1==0||y-1==0||(x-2>=0&&y-2>=0&&ChessMan[x-2][y-2]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==0){
            score+=FOUR_DEAD;
        }
        /**
         * ●
         *  o
         *   o
         *    x
         *     o
         *      _
         */
        if((x-2==0||y-2==0||(x-3>=0&&y-3>=0&&ChessMan[x-3][y-3]!=color))&&x-2>=0&&y-2>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==0){
            score+=FOUR_DEAD;
        }
        /**
         * ●
         *  o
         *   o
         *    o
         *     x
         *      _
         */
        if((x-3==0||y-3==0||(x-4>=0&&y-4>=0&&ChessMan[x-4][y-4]!=color))&&x-3>=0&&y-3>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==color&&ChessMan[x+1][y+1]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         *  o
         *   o
         *    o
         *     x
         *      ●
         */
        if((x==14||y==14||(x+1<=14&&y+1<=14&&ChessMan[x+1][y+1]!=color))&&x-4>=0&&y-4>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==color&&ChessMan[x-4][y-4]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         *  o
         *   o
         *    x
         *     o
         *      ●
         */
        if((x+1==14||y+1==14||(x+2<=14&&y+2<=14&&ChessMan[x+2][y+2]!=color))&&x-3>=0&&y-3>=0&&ChessMan[x+1][y+1]==color&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         *  o
         *   x
         *    o
         *     o
         *      ●
         */
        if((x+2==14||y+2==14||(x+3<=14&&y+3<=14&&ChessMan[x+3][y+3]!=color))&&x-2>=0&&y-2>=0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==0){
            score+=FOUR_DEAD;
        }
        /**
         * _
         *  x
         *   o
         *    o
         *     o
         *      ●
         */
        if((x+3==14||y+3==14||(x+4<=14&&y+4<=14&&ChessMan[x+4][y+4]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==color&&ChessMan[x-1][y-1]==0){
            score+=FOUR_DEAD;
        }

        /**
         *      ●
         *     x
         *    o
         *   o
         *  o
         * _
         */
        if((x==14||y==0||(x+1<=14&&y-1>=0&&ChessMan[x+1][y-1]!=color))&&x-4>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==color&&ChessMan[x-4][y+4]==0){
            score+=FOUR_DEAD;
        }

        /**
         *      ●
         *     o
         *    x
         *   o
         *  o
         * _
         */
        if((x+1==14||y-1==0||(x+2<=14&&y-2>=0&&ChessMan[x+2][y-2]!=color))&&x-3>=0&&y-1>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==0){
            score+=FOUR_DEAD;
        }

        /**
         *      ●
         *     o
         *    o
         *   x
         *  o
         * _
         */
        if((x+2==14||y-2==0||(x+3<=14&&y-3>=0&&ChessMan[x+3][y-3]!=color))&&x-2>=0&&y-2>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==0){
            score+=FOUR_DEAD;
        }
        /**
         *      ●
         *     o
         *    o
         *   o
         *  x
         * _
         */
        if((x+3==14||y-3==0||(x+4<=14&&y-4>=0&&ChessMan[x+4][y-4]!=color))&&x-1>=0&&y-3>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==color&&ChessMan[x-1][y+1]==0){
            score+=FOUR_DEAD;
        }

        /**
         *      _
         *     o
         *    o
         *   o
         *  x
         * ●
         */
        if((x==0||y==14||(x-1>=0&&y+1<=14&&ChessMan[x-1][y+1]!=color))&&y-4>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==color&&ChessMan[x+4][y-4]==0){
            score+=FOUR_DEAD;
        }
        /**
         *      _
         *     o
         *    o
         *   x
         *  o
         * ●
         */
        if((x-1==0||y+1==14||(x-2>=0&&y+2<=14&&ChessMan[x-2][y+2]!=color))&&x-1>=0&&y-3>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==0){
            score+=FOUR_DEAD;
        }
        /**
         *      _
         *     o
         *    x
         *   o
         *  o
         * ●
         */
        if((x-2==0||y+2==14||(x-3>=0&&y+3<=14&&ChessMan[x-3][y+3]!=color))&&x-2>=0&&y-2>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==0){
            score+=FOUR_DEAD;
        }
        /**
         *      _
         *     x
         *    o
         *   o
         *  o
         * ●
         */
        if((x-3==0||y+3==14||(x-4>=0&&y+4<=14&&ChessMan[x-4][y+4]!=color))&&x-3>=0&&y-1>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==color&&ChessMan[x+1][y-1]==0){
            score+=FOUR_DEAD;
        }

        //活3
        //_xoo_
        if(x-1>=0&&ChessMan[x-1][y]==0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==0){
            score+=THREE_LIVE;
        }
        //_oxo_
        if(x-2>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==0){
            score+=THREE_LIVE;
        }
        //_oox_
        if(x-3>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==0&&ChessMan[x+1][y]==0){
            score+=THREE_LIVE;
        }
        /**
         * _
         * x
         * o
         * o
         * _
         */
        if(y-1>=0&&ChessMan[x][y-1]==0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==0){
            score+=THREE_LIVE;
        }
        /**
         * _
         * o
         * x
         * o
         * _
         */
        if(y-2>=0&&ChessMan[x][y-2]==0&&ChessMan[x][y-1]==color&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==0){
            score+=THREE_LIVE;
        }
        /**
         * _
         * o
         * o
         * x
         * _
         */
        if(y-3>=0&&ChessMan[x][y-3]==0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y+1]==0){
            score+=THREE_LIVE;
        }
        /**
         * _
         *  x
         *   o
         *    o
         *     _
         */
        if(x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]==0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==0){
            score+=THREE_LIVE;
        }
        /**
         * _
         *  o
         *   x
         *    o
         *     _
         */
        if(x-2>=0&&y-2>=0&&ChessMan[x-2][y-2]==0&&ChessMan[x-1][y-1]==color&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==0){
            score+=THREE_LIVE;
        }

        /**
         * _
         *  o
         *   o
         *    x
         *     _
         */
        if(x-3>=0&&y-3>=0&&ChessMan[x-3][y-3]==0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x+1][y+1]==0){
            score+=THREE_LIVE;
        }
        /**
         *     _
         *    o
         *   o
         *  x
         * _
         */
        if(x-1>=0&&y-3>=0&&ChessMan[x-1][y+1]==0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==0){
            score+=THREE_LIVE;
        }
        /**
         *     _
         *    o
         *   x
         *  o
         * _
         */
        if(x-2>=0&&y-2>=0&&ChessMan[x-2][y+2]==0&&ChessMan[x-1][y+1]==color&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==0){
            score+=THREE_LIVE;
        }
        /**
         *     _
         *    x
         *   o
         *  o
         * _
         */
        if(x-3>=0&&y-1>=0&&ChessMan[x-3][y+3]==0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x+1][y-1]==0){
            score+=THREE_LIVE;
        }
        //死三
        //●x○○_
        if((x==0||(x-1>=0&&ChessMan[x-1][y]!=color))&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x+3][y]==0){
            score+=THREE_DEAD;
        }
        //●○x○_
        if((x-1==0||(x-2>=0&&ChessMan[x-2][y]!=color))&&ChessMan[x-1][y]==color&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==0){
            score+=THREE_DEAD;
        }
        //●○○x_
        if((x-2==0||(x-3>=0&&ChessMan[x-3][y]!=color))&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x+1][y]==0){
            score+=THREE_DEAD;
        }
        //_○○x●
        if((x==14||(x+1<=14&&ChessMan[x+1][y]!=color))&&x-3>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==color&&ChessMan[x-3][y]==0){
            score+=THREE_DEAD;
        }
        //_○x○●
        if((x+1==14||(x+2<=14&&ChessMan[x+2][y]!=color))&&x-2>=0&&ChessMan[x+1][y]==color&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==0){
            score+=THREE_DEAD;
        }
        //_x○○●
        if((x+2==14||(x+3<=14&&ChessMan[x+3][y]!=color))&&x-1>=0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==color&&ChessMan[x-1][y]==0){
            score+=THREE_DEAD;
        }

        /**
         * ●
         * x
         * ○
         * ○
         * _
         */
        if((y==0||(y-1>=0&&ChessMan[x][y-1]!=color))&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y+3]==0){
            score+=THREE_DEAD;
        }
        /**
         * ●
         * o
         * x
         * ○
         * _
         */
        if((y-1==0||(y-2>=0&&ChessMan[x][y-2]!=color))&&ChessMan[x][y-1]==color&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==0){
            score+=THREE_DEAD;
        }
        /**
         * ●
         * o
         * o
         * x
         * _
         */
        if((y-2==0||(y-3>=0&&ChessMan[x][y-3]!=color))&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y+1]==0){
            score+=THREE_DEAD;
        }

        /**
         * _
         * o
         * o
         * x
         * ●
         */
        if((y==14||(y+1<=14&&ChessMan[x][y+1]!=color))&&y-3>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==color&&ChessMan[x][y-3]==0){
            score+=THREE_DEAD;
        }
        /**
         * _
         * o
         * x
         * o
         * ●
         */
        if((y+1==14||(y+2<=14&&ChessMan[x][y+2]!=color))&&y-2>=0&&ChessMan[x][y+1]==color&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==0){
            score+=THREE_DEAD;
        }
        /**
         * _
         * x
         * o
         * o
         * ●
         */
        if((y+2==14||(y+3<=14&&ChessMan[x][y+3]!=color))&&y-1>=0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==color&&ChessMan[x][y-1]==0){
            score+=THREE_DEAD;
        }

        /**
         * ●
         *  x
         *   o
         *    o
         *      _
         */
        if((x==0||y==0||(x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]!=color))&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x+3][y+3]==0){
            score+=THREE_DEAD;
        }
        /**
         * ●
         *  o
         *   x
         *    o
         *      _
         */
        if((x-1==0||y-1==0||(x-2>=0&&y-2>=0&&ChessMan[x-2][y-2]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==0){
            score+=THREE_DEAD;
        }
        /**
         * ●
         *  o
         *   o
         *    x
         *      _
         */
        if((x-2==0||y-2==0||(x-3>=0&&y-3>=0&&ChessMan[x-3][y-3]!=color))&&x-2>=0&&y-2>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x+1][y+1]==0){
            score+=THREE_DEAD;
        }

        /**
         *  _
         *   o
         *    o
         *     x
         *      ●
         */
        if((x==14||y==14||(x+1<=14&&y+1<=14&&ChessMan[x+1][y+1]!=color))&&x-3>=0&&y-3>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==color&&ChessMan[x-3][y-3]==0){
            score+=THREE_DEAD;
        }
        /**
         *  _
         *   o
         *    x
         *     o
         *      ●
         */
        if((x+1==14||y+1==14||(x+2<=14&&y+2<=14&&ChessMan[x+2][y+2]!=color))&&x-2>=0&&y-2>=0&&ChessMan[x+1][y+1]==color&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==0){
            score+=THREE_DEAD;
        }
        /**
         * _
         *   x
         *    o
         *     o
         *      ●
         */
        if((x+2==14||y+2==14||(x+3<=14&&y+3<=14&&ChessMan[x+3][y+3]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==color&&ChessMan[x-1][y-1]==0){
            score+=THREE_DEAD;
        }

        /**
         *      ●
         *     x
         *    o
         *   o
         * _
         */
        if((x==14||y==0||(x+1<=14&&y-1>=0&&ChessMan[x+1][y-1]!=color))&&x-3>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x-3][y+3]==0){
            score+=THREE_DEAD;
        }

        /**
         *      ●
         *     o
         *    x
         *   o
         * _
         */
        if((x+1==14||y-1==0||(x+2<=14&&y-2>=0&&ChessMan[x+2][y-2]!=color))&&x-2>=0&&y-1>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==0){
            score+=THREE_DEAD;
        }

        /**
         *      ●
         *     o
         *    o
         *   x
         * _
         */
        if((x+2==14||y-2==0||(x+3<=14&&y-3>=0&&ChessMan[x+3][y-3]!=color))&&x-1>=0&&y-2>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x-1][y+1]==0){
            score+=THREE_DEAD;
        }

        /**
         *     _
         *    o
         *   o
         *  x
         * ●
         */
        if((x==0||y==14||(x-1>=0&&y+1<=14&&ChessMan[x-1][y+1]!=color))&&y-3>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==color&&ChessMan[x+3][y-3]==0){
            score+=THREE_DEAD;
        }
        /**
         *     _
         *    o
         *   x
         *  o
         * ●
         */
        if((x-1==0||y+1==14||(x-2>=0&&y+2<=14&&ChessMan[x-2][y+2]!=color))&&x-1>=0&&y-2>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==0){
            score+=THREE_DEAD;
        }
        /**
         *     _
         *    x
         *   o
         *  o
         * ●
         */
        if((x-2==0||y+2==14||(x-3>=0&&y+3<=14&&ChessMan[x-3][y+3]!=color))&&x-2>=0&&y-1>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==color&&ChessMan[x+1][y-1]==0){
            score+=THREE_DEAD;
        }

        //活2
        //_xo_
        if(x-1>=0&&ChessMan[x-1][y]==0&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==0){
            score+=TWO_LIVE;
        }
        //_ox_
        if(x-2>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==0&&ChessMan[x+1][y]==0){
            score+=TWO_LIVE;
        }

        /**
         * _
         * x
         * o
         * _
         */
        if(y-1>=0&&ChessMan[x][y-1]==0&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==0){
            score+=TWO_LIVE;
        }
        /**
         * _
         * o
         * x
         * _
         */
        if(y-2>=0&&ChessMan[x][y-2]==0&&ChessMan[x][y-1]==color&&ChessMan[x][y+1]==0){
            score+=TWO_LIVE;
        }

        /**
         * _
         *  x
         *   o
         *    _
         */
        if(x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]==0&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==0){
            score+=TWO_LIVE;
        }
        /**
         * _
         *  o
         *   x
         *     _
         */
        if(x-2>=0&&y-2>=0&&ChessMan[x-2][y-2]==0&&ChessMan[x-1][y-1]==color&&ChessMan[x+1][y+1]==0){
            score+=TWO_LIVE;
        }


        /**
         *    _
         *   o
         *  x
         * _
         */
        if(x-1>=0&&y-2>=0&&ChessMan[x-1][y+1]==0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==0){
            score+=TWO_LIVE;
        }
        /**
         *    _
         *   x
         *  o
         * _
         */
        if(x-2>=0&&y-1>=0&&ChessMan[x-2][y+2]==0&&ChessMan[x-1][y+1]==color&&ChessMan[x+1][y-1]==0){
            score+=TWO_LIVE;
        }

        //死二
        //●x○_
        if((x==0||(x-1>=0&&ChessMan[x-1][y]!=color))&&ChessMan[x+1][y]==color&&ChessMan[x+2][y]==0){
            score+=TWO_DEAD;
        }
        //●○x_
        if((x-1==0||(x-2>=0&&ChessMan[x-2][y]!=color))&&ChessMan[x-1][y]==color&&ChessMan[x+1][y]==0){
            score+=TWO_DEAD;
        }

        //_○x●
        if((x==14||(x+1<=14&&ChessMan[x+1][y]!=color))&&x-2>=0&&ChessMan[x-1][y]==color&&ChessMan[x-2][y]==0){
            score+=TWO_DEAD;
        }
        //_x○●
        if((x+1==14||(x+2<=14&&ChessMan[x+2][y]!=color))&&x-1>=0&&ChessMan[x+1][y]==color&&ChessMan[x-1][y]==0){
            score+=TWO_DEAD;
        }

        /**
         * ●
         * x
         * ○
         * _
         */
        if((y==0||(y-1>=0&&ChessMan[x][y-1]!=color))&&ChessMan[x][y+1]==color&&ChessMan[x][y+2]==0){
            score+=TWO_DEAD;
        }
        /**
         * ●
         * o
         * x
         * _
         */
        if((y-1==0||(y-2>=0&&ChessMan[x][y-2]!=color))&&ChessMan[x][y-1]==color&&ChessMan[x][y+1]==0){
            score+=TWO_DEAD;
        }

        /**
         * _
         * o
         * x
         * ●
         */
        if((y==14||(y+1<=14&&ChessMan[x][y+1]!=color))&&y-2>=0&&ChessMan[x][y-1]==color&&ChessMan[x][y-2]==0){
            score+=TWO_DEAD;
        }
        /**
         * _
         * x
         * o
         * ●
         */
        if((y+1==14||(y+2<=14&&ChessMan[x][y+2]!=color))&&y-1>=0&&ChessMan[x][y+1]==color&&ChessMan[x][y-1]==0){
            score+=TWO_DEAD;
        }

        /**
         * ●
         *  x
         *   o
         *     _
         */
        if((x==0||y==0||(x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]!=color))&&ChessMan[x+1][y+1]==color&&ChessMan[x+2][y+2]==0){
            score+=TWO_DEAD;
        }
        /**
         * ●
         *  o
         *   x
         *     _
         */
        if((x-1==0||y-1==0||(x-2>=0&&y-2>=0&&ChessMan[x-2][y-2]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x+1][y+1]==0){
            score+=TWO_DEAD;
        }

        /**
         *   _
         *    o
         *     x
         *      ●
         */
        if((x==14||y==14||(x+1<=14&&y+1<=14&&ChessMan[x+1][y+1]!=color))&&x-2>=0&&y-2>=0&&ChessMan[x-1][y-1]==color&&ChessMan[x-2][y-2]==0){
            score+=TWO_DEAD;
        }
        /**
         *   _
         *    x
         *     o
         *      ●
         */
        if((x+1==14||y+1==14||(x+2<=14&&y+2<=14&&ChessMan[x+2][y+2]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x+1][y+1]==color&&ChessMan[x-1][y-1]==0){
            score+=TWO_DEAD;
        }

        /**
         *      ●
         *     x
         *    o
         *  _
         */
        if((x==14||y==0||(x+1<=14&&y-1>=0&&ChessMan[x+1][y-1]!=color))&&x-2>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x-2][y+2]==0){
            score+=TWO_DEAD;
        }

        /**
         *      ●
         *     o
         *    x
         *  _
         */
        if((x+1==14||y-1==0||(x+2<=14&&y-2>=0&&ChessMan[x+2][y-2]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x-1][y+1]==0){
            score+=TWO_DEAD;
        }


        /**
         *    _
         *   o
         *  x
         * ●
         */
        if((x==0||y==14||(x-1>=0&&y+1<=14&&ChessMan[x-1][y+1]!=color))&&y-2>=0&&ChessMan[x+1][y-1]==color&&ChessMan[x+2][y-2]==0){
            score+=TWO_DEAD;
        }
        /**
         *    _
         *   x
         *  o
         * ●
         */
        if((x-1==0||y+1==14||(x-2>=0&&y+2<=14&&ChessMan[x-2][y+2]!=color))&&x-1>=0&&y-1>=0&&ChessMan[x-1][y+1]==color&&ChessMan[x+1][y-1]==0){
            score+=TWO_DEAD;
        }

        ////////////////////////////
        return score;
    }

}
