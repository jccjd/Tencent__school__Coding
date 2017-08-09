package Util;

import bean.GameDate;
import bean.IOUtil;
import bean.Point;
import bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 棋盘
 */
public class Draw extends JPanel {

    private int py_x = 50;
    private int py_y = 50;
    private int number_x = 30;
    private int nubber_y = 55;

    private User user;
    private boolean isBegin;
    private int WhichColor;//1为黑
    private int[][] ChessMan;//2为白
    private ImageIcon black,white,empty;
    private int gameState; //1.人人对弈2.人机对弈
    private Socket socket;
    private Ruler ruler;
    private Point point;
    private int move_x, move_y;
    public Draw() {

        this.setSize(500,500);
        this.setBackground(Color.gray);
        ChessMan = new int[30][30];
        ruler = new Ruler(ChessMan);
        isBegin = true;
        String basePath = this.getClass().getResource("/").getPath();
        black = new ImageIcon(basePath+"picture/black.png");
        white = new ImageIcon(basePath+"picture/white.png");
        empty = new ImageIcon(basePath+"picture/empty.png");
        WhichColor=1;
        user = new User();
        addListener();
    }

    public void newGame() {
        ChessMan = new int[30][30];
        isBegin = true;
        WhichColor = 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintchessboard(g);
        paintchessman(g);
        if (user.getColor() == 1||user.getColor()==2) {
            paintcursor(g);
        }
        ruler.setChessMan(ChessMan);
        if (ruler.isOver() == 1) {
            Chessboard.gameInfo.setText("黑方胜");
            isBegin = false;
        } else if (ruler.isOver() == 2) {
            Chessboard.gameInfo.setText("白方胜");
            isBegin = false;
        }
    }


    public void paintchessboard(Graphics g) {

        /*画数字*/
        String number = "";
        for (int i = 0; i < 15; i++) {
            g.drawString(i + number ,30*i+py_x-3,py_y-10);
            if (i>=10) {
                g.drawString(i + number ,py_x-30,30*i+py_y+3);
            } else {
                g.drawString(i + number ,py_x-25,30*i+py_y+3);
            }
        }

        for (int i = 0; i < 15; i++) {
            /*画x轴*/
            g.drawLine( py_x + 0,py_y + i*30, py_x + 14*30,py_y + i*30);
            /*画y轴*/
            g.drawLine(py_x + i*30, py_y + 0, py_x + i*30, py_y + 14*30);

        }
        /*加粗边框线*/
        Graphics2D gbold = (Graphics2D) g;
        Line2D line_1 = new Line2D.Double(py_x + 0, py_y + 0, py_x + 14 * 30,py_y + 0);
        Line2D line_2 = new Line2D.Double(py_x + 0, py_y + 0, py_x + 0,py_y + 14 * 30);
        Line2D line_3 = new Line2D.Double(py_x + 14 * 30, py_y + 0, py_x + 14 * 30,py_y + 14 * 30);
        Line2D line_4 = new Line2D.Double(py_x + 0, py_y + 14 * 30, py_x + 14 * 30,py_y + 14 * 30);

        BasicStroke bs_1=new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
        gbold.setStroke(bs_1);
        gbold.draw(line_1);
        gbold.draw(line_2);
        gbold.draw(line_3);
        gbold.draw(line_4);

        /*五个原始点*/
        g.fillOval(py_x + 30 * 3 - 5, py_y + 30 * 3 - 5, 10, 10);
        g.fillOval(py_x + 30 * 3 - 5, py_y + 30 * 3 - 5, 10, 10);
        g.fillOval(py_x + 30 * 3 - 5, py_y + 30 * 11 - 5, 10, 10);
        g.fillOval(py_x + 30 * 11 - 5, py_y + 30 * 3 - 5, 10, 10);
        g.fillOval(py_x + 30 * 11 - 5, py_y + 30 * 11 - 5, 10, 10);
        g.fillOval(py_x + 30 * 7 - 5, py_y + 30 * 7 - 5, 10, 10);

        /*加数字*/

    }

    /*绘制棋子*/
    public void paintchessman(Graphics g) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (ChessMan[i][j] == 1) {
                    /*画黑棋*/
                    g.drawImage(black.getImage(),30 * i +py_x - 10, 30 * j +py_y - 10,20,20,this);
                } else if (ChessMan[i][j] == 2){
                    /*画白棋*/
                    g.drawImage(white.getImage(),30 * i +py_x - 10, 30 * j +py_y -10,20,20,this);
                }
            }
        }
    }


    public void changeColor() {
        if (WhichColor == 1) {
            WhichColor = 2;
        }
        else if (WhichColor == 2) {
            WhichColor = 1;
        }
    }

    public void showGameInfo() {
        if (WhichColor == 1) {
            Chessboard.gameInfo.setText("轮到黑方下棋");
        } else if (WhichColor == 2) {
            Chessboard.gameInfo.setText("轮到白方下棋");
        }
    }

    public void addListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (!isBegin) return;
                if (user.getColor() != WhichColor) return;
                int x = e.getX();
                int y = e.getY();
                if (x >= 0 + py_x - 10 && y >=0 +py_y -10
                        && x <= 420 +py_x + 10 && y <= 420 + py_y + 10) {
                    x = (int) Math.round((x - py_x)/30.0);
                    y = (int) Math.round((y - py_y)/30.0);
                    if (ChessMan[x][y] != 0) return;
                    ChessMan[x][y] = user.getColor();
                    repaint();
                    changeColor();
                    showGameInfo();
                    /*人人对弈*/
                    if (gameState == 1) {
                        /*通知服务器,当前用户下棋信息*/
                        GameDate date = new GameDate();
                        date.setUser(user);
                        date.setPoint(new Point(x, y));

                        sendInfo2Server(date);
                    } else if (gameState == 2) {
                        /*人机对弈*/
                        computerCalNextStep();
                    }
                }
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!isBegin)return;
                int x = e.getX();
                int y = e.getY();
                if (x >= 0 + py_x - 10 && y >= 0 + py_y - 10
                        && x <= 420 + py_x + 10 && y <= 420 + py_y + 10) {
                    move_x = (int) Math.round((x - py_x) / 30.0);
                    move_y = (int) Math.round((y - py_y) / 30.0);
                }
                 repaint();
            }
        });
    }
    /*绘制光标*/
    public void paintcursor(Graphics g) {
        g.drawImage(empty.getImage(), 30 * move_x + py_x - 10, 30 * move_y + py_y - 10,
                20, 20, this);
    }

    /*电脑计算下一步棋*/
    public void computerCalNextStep() {
        //让电脑随机下棋
//        while (true) {
//            int x = (int) (Math.random() * 15);
//            int y = (int) (Math.random() * 15);
//            if (ChessMan[x][y] != 0) continue;
//            int computerColor = 0;
//            if (user.getColor() == 1) computerColor = 2;
//            if (user.getColor() == 2) computerColor = 1;
//            ChessMan[x][y] = computerColor;
//            repaint();
//            changeColor();
//            showGameInfo();
//            return;
//        }
        /*Ai下棋*/
        Point bestpoint = this.getBestPoint();
        int computerColor = 0;
        if (user.getColor() == 1) computerColor = 2;
        else if (user.getColor() == 2) computerColor = 1;

        ChessMan[bestpoint.getX()][bestpoint.getY()] = computerColor;
            repaint();
            changeColor();
            showGameInfo();

    }
    /*电脑计算最优点*/
    public Point getBestPoint() {
        int maxScore = 0;
        List<Point> allPoint = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (ChessMan[i][j] != 0) continue;
                    int tempScore = ruler.calScore(i, j, 1)+ruler.calScore(i,j,2);
                    if (maxScore < tempScore) maxScore = tempScore;
                    point = new Point(i, j, tempScore);
                    allPoint.add(point);
            }
        }
        List<Point> bestPoint = new ArrayList<>();
        for (Point p : allPoint) {
            if (p.getScore() == maxScore) {
                bestPoint.add(p);
            }
        }
        return bestPoint.get((int)(Math.random()*bestPoint.size()));
    }

    /*电脑先下*/
    public void computerFirstStep() {
        ChessMan[7][7] = 1;
        repaint();
        changeColor();
        showGameInfo();
    }

    /*连接服务器*/
    public void connectServer() throws IOException {
        socket = new Socket("127.0.0.1", 8888);
        GameDate gameDate = new GameDate();
        gameDate.setUser(user);
        IOUtil.writeObject(gameDate,socket.getOutputStream());
        /*启动线程*/
        new Thread(new GetInfoFromServer()).start();
    }

    /*给服务器发信息*/
    public void sendInfo2Server(GameDate date)  {

        try {
            IOUtil.writeObject(date,socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("未连接服务器");
        }

    }

    public User getUser() {
        return user;
    }


    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    /*从服务器读数据的线程*/
    class GetInfoFromServer implements Runnable{
        int serverColor = 0;
        @Override
        public void run() {
            while (true) {
                try {

                    GameDate date = (GameDate)IOUtil.readObject(socket.getInputStream());
                    ChessMan[date.getPoint().getX()]
                            [date.getPoint().getY()]
                            = date.getUser().getColor();
                    serverColor = date.getUser().getColor();
                    repaint();
                    changeColor();
                } catch (IOException e) {

                }
                showGameInfo();
            }
        }
        public int getServerColor() {
            return serverColor;
        }
    }
}
