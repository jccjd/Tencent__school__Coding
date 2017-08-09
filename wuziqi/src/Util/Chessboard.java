package Util;

import bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

/**
 * 棋盘
 */
public class Chessboard extends JFrame{
    private JMenuBar bar; /*系统菜单栏*/
    private JMenu system;/*系统功能*/
    private JMenuItem login;
    private JMenu ManvsMan;
    private JMenuItem MM_Choosewhite;
    private JMenuItem MM_Chooseblack;

    private JMenu ManvsAI;
    private JMenuItem MA_Choosewhite;
    private JMenuItem MA_Chooseblack;

    private Draw draw;/*绘制棋盘区域*/
    public static JLabel userInfo;/*显示用户信息*/
    public static JLabel gameInfo;/*游戏信息*/

    public Chessboard() {
        super("五子棋");
        init();
        this.setSize(600,600);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();
        this.setLocation((width-600)/2,(height-600)/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        addListener();
    }

    public void init() {
        bar = new JMenuBar();
        system = new JMenu("系统功能");
        login = new JMenuItem("登录");
        ManvsMan = new JMenu("人人对战");
        MM_Chooseblack = new JMenuItem("执黑子");
        MM_Choosewhite = new JMenuItem("执白子");

        ManvsAI = new JMenu("人机对战");
        MA_Chooseblack = new JMenuItem("执黑子");
        MA_Choosewhite = new JMenuItem("执白字");

        draw = new Draw();
        bar.add(system);
        userInfo = new JLabel("未登录");
        userInfo.setHorizontalAlignment(JLabel.CENTER);
        gameInfo = new JLabel("游戏未开始");
        gameInfo.setHorizontalAlignment(JLabel.CENTER);

        system.add(login);
        system.add(ManvsMan);
        ManvsAI.add(MA_Chooseblack);
        ManvsAI.add(MA_Choosewhite);

        system.add(ManvsAI);
        ManvsMan.add(MM_Chooseblack);
        ManvsMan.add(MM_Choosewhite);

        this.setLayout(new BorderLayout());
        this.setJMenuBar(bar);
        this.add(draw, BorderLayout.CENTER);
        this.add(userInfo, BorderLayout.NORTH);
        this.add(gameInfo, BorderLayout.SOUTH);

    }

    /*给组件创建监听器*/
    public void addListener() {

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = JOptionPane.showInputDialog("请输入用户名");
                if (userName == null || userName.trim().equals("")) {
                    JOptionPane.showConfirmDialog(null, "用户名不能为空");
                    return;
                }
                draw.getUser().setUserName(userName);
                userInfo.setText("欢迎你"+ userName);
            }
        });

        MM_Chooseblack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                draw.setGameState(1);
                draw.getUser().setColor(1);
                draw.newGame();
                userInfo.setText("你执黑棋");
                gameInfo.setText("游戏开始,黑棋先下");

                /*连接服务器*/
                try {
                    draw.connectServer();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        MM_Choosewhite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.getUser().setColor(2);

                draw.setGameState(1);
                draw.newGame();
                userInfo.setText("你执白棋");
                gameInfo.setText("游戏开始");

                /*连接服务器*/
                try {
                    draw.connectServer();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        MA_Chooseblack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.getUser().setColor(1);
                draw.setGameState(2);//人机对弈
                draw.newGame();
                gameInfo.setText("游戏开始");

            }
        });
        MA_Choosewhite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                draw.getUser().setColor(2);
                draw.setGameState(2);//人机对弈
                draw.newGame();
                gameInfo.setText("游戏开始");
                draw.computerFirstStep();

            }
        });
    }

    public static void main(String[] args) {

        new Chessboard();

    }
}
