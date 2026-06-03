
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UserLoginUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private ArrayList<User> userList = new ArrayList<>();
    public static User currentUser;

    public UserLoginUI() {
        initAdmin();
        setSize(360, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 248, 240));
        initComponents();
    }

    private void initAdmin() {
        userList.add(new User(1, "admin", "123456", "管理员", "13800000001", "川菜"));
    }

    private void initComponents() {
        JLabel title = new JLabel("美食推荐系统", JLabel.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 24));
        title.setForeground(new Color(255, 102, 0));
        title.setBounds(0, 80, 360, 40);
        add(title);

        JLabel labUser = new JLabel("用户名");
        labUser.setBounds(40, 180, 80, 30);
        labUser.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameField = new JTextField();
        usernameField.setBounds(40, 210, 280, 40);

        JLabel labPwd = new JLabel("密码");
        labPwd.setBounds(40, 270, 80, 30);
        labPwd.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordField = new JPasswordField();
        passwordField.setBounds(40, 300, 280, 40);

        JButton btnLogin = new JButton("登录");
        btnLogin.setBounds(40, 380, 280, 50);
        btnLogin.setBackground(new Color(255, 110, 60));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);

        JButton btnReg = new JButton("注册");
        btnReg.setBounds(40, 450, 280, 50);
        btnReg.setBackground(new Color(100, 180, 255));
        btnReg.setForeground(Color.WHITE);
        btnReg.setBorderPainted(false);
        btnReg.setOpaque(true);

        btnLogin.addActionListener(this::doLogin);
        btnReg.addActionListener(e -> new UserRegisterUI(userList));

        add(labUser);
        add(usernameField);
        add(labPwd);
        add(passwordField);
        add(btnLogin);
        add(btnReg);
    }

    private void doLogin(ActionEvent e) {
        String name = usernameField.getText().trim();
        String pwd = new String(passwordField.getPassword()).trim();

        for (User u : userList) {
            if (u.getUsername().equals(name) && u.getPassword().equals(pwd)) {
                currentUser = u;
                JOptionPane.showMessageDialog(this, "欢迎你，" + u.getNickname());
                new UserMainUI().setVisible(true);
                this.dispose();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "账号或密码错误！");
    }
}