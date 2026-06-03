
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserRegisterUI extends JFrame {
    private JTextField tfUsername, tfNickname, tfPhone, tfFavorite;
    private JPasswordField pfPwd, pfRepwd;
    private ArrayList<User> userList;

    public UserRegisterUI(ArrayList<User> userList) {
        this.userList = userList;
        setSize(360, 640);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 250, 255));

        JLabel title = new JLabel("用户注册", JLabel.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 22));
        title.setForeground(new Color(30, 144, 255));
        title.setBounds(0, 50, 360, 40);
        add(title);

        JLabel labUser = new JLabel("用户名");
        labUser.setBounds(40, 120, 100, 30);
        tfUsername = new JTextField();
        tfUsername.setBounds(40, 150, 280, 40);

        JLabel labPwd = new JLabel("密码");
        labPwd.setBounds(40, 200, 100, 30);
        pfPwd = new JPasswordField();
        pfPwd.setBounds(40, 230, 280, 40);

        JLabel labRepwd = new JLabel("确认密码");
        labRepwd.setBounds(40, 280, 100, 30);
        pfRepwd = new JPasswordField();
        pfRepwd.setBounds(40, 310, 280, 40);

        JLabel labNick = new JLabel("昵称");
        labNick.setBounds(40, 360, 100, 30);
        tfNickname = new JTextField();
        tfNickname.setBounds(40, 390, 280, 40);

        JLabel labPhone = new JLabel("手机号");
        labPhone.setBounds(40, 440, 100, 30);
        tfPhone = new JTextField();
        tfPhone.setBounds(40, 470, 130, 40);

        JLabel labFav = new JLabel("偏好");
        labFav.setBounds(180, 440, 100, 30);
        tfFavorite = new JTextField();
        tfFavorite.setBounds(180, 470, 140, 40);

        JButton btnReg = new JButton("完成注册");
        btnReg.setBounds(40, 530, 280, 50);
        btnReg.setBackground(new Color(60, 180, 100));
        btnReg.setForeground(Color.WHITE);
        btnReg.setBorderPainted(false);
        btnReg.setOpaque(true);
        btnReg.addActionListener(e -> doRegister());

        add(labUser);add(tfUsername);
        add(labPwd);add(pfPwd);
        add(labRepwd);add(pfRepwd);
        add(labNick);add(tfNickname);
        add(labPhone);add(tfPhone);
        add(labFav);add(tfFavorite);
        add(btnReg);
        setVisible(true);
    }

    private void doRegister() {
        String username = tfUsername.getText().trim();
        String pwd = new String(pfPwd.getPassword()).trim();
        String repwd = new String(pfRepwd.getPassword()).trim();
        String nickname = tfNickname.getText().trim();
        String phone = tfPhone.getText().trim();
        String fav = tfFavorite.getText().trim();

        if (!pwd.equals(repwd)) {
            JOptionPane.showMessageDialog(this, "两次密码不一致！");
            return;
        }
        int newId = userList.size() + 1;
        userList.add(new User(newId, username, pwd, nickname, phone, fav));
        JOptionPane.showMessageDialog(this, "注册成功！");
        this.dispose();
    }
}