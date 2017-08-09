package Server;

import bean.GameDate;
import bean.IOUtil;
import bean.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *服务器
 * */
public class GameServer {

    private ServerSocket server;
    private Map<User,Socket> players;
    public GameServer() {
        players = new HashMap<>();
        try {
            server = new ServerSocket(8888);
            System.out.println("服务器启动");
            while (true) {

                System.out.println("等待客户端连接");
                Socket socket = server.accept();
                GameDate date = (GameDate) IOUtil.readObject(socket.getInputStream());
                players.put(date.getUser(), socket);
                System.out.println("用户" + date.getUser().getUserName()+"已上线");
                new Thread(new GameServerThread(date.getUser(),socket)).start();

            }
        } catch (IOException e) {
            System.out.println("此端口已被占用");
        }
    }
    class GameServerThread implements Runnable {
        private User user;
        private Socket socket;

        @Override
        public void run() {
            while (true) {
                try {
                    GameDate date = (GameDate)IOUtil.readObject(socket.getInputStream());
                    Set<User> users = players.keySet();
                    for (User temp : users) {
                        if (temp.equals(user)) continue;
                        IOUtil.writeObject(date, players.get(temp).getOutputStream());
                    }
                } catch (IOException e) {
                    System.out.println("错误2");
                }
            }
        }

        public GameServerThread(User user, Socket socket) {
            this.user = user;
            this.socket = socket;
        }
    }

    public static void main(String[] args) {
        new GameServer();
    }

}
