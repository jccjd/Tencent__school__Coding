package Util;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    JTextField jTextField;
    JPasswordField jPasswordField;
    JLabel jLabel1,jLabel2;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2;
             public Login(){
                 jTextField = new JTextField(12);
                 jPasswordField = new JPasswordField(13);
                 jLabel1 = new JLabel("用户名");
                 jLabel2 = new JLabel("密码 ");
                 jb1 = new JButton("确认");
                 jb2 = new JButton("取消");
                 jp1 = new JPanel();
                 jp2 = new JPanel();
                 jp3 = new JPanel();

                 //设置布局
                 this.setLayout(new GridLayout(3,1));
                         jp1.add(jLabel1);
                jp1.add(jTextField);//第一块面板添加用户名和文本框

                 jp2.add(jLabel2);
                 jp2.add(jPasswordField);//第二块面板添加密码和密码输入框

                 jp3.add(jb1);
                 jp3.add(jb2); //第三块面板添加确认和取消
                 this.add(jp1);
                 this.add(jp2);
                 this.add(jp3);  //将三块面板添加到登陆框上面
                 //设置显示
                 this.setSize(300, 200);
                 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                 this.setTitle("登陆");

          }
   public static void main(String[] args){
                new Login();
   }

}

