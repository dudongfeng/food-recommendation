import javax.swing.*;
import java.awt.*;

/**
 * C-第5次提交：项目唯一启动入口，整合A用户、B美食、C推荐三大模块入口
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame mainFrame = new JFrame("美食推荐系统-主首页");
            mainFrame.setSize(360,640);
            mainFrame.setLayout(new GridLayout(3,1,15,15));
            mainFrame.setBorder(BorderFactory.createEmptyBorder(40,30,40,30));
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);

            // 三个跳转按钮（对应A/B/C三人模块）
            JButton btnUser = new JButton("📱用户中心(登录/注册)");
            btnUser.setBackground(new Color(80,180,255));
            btnUser.setForeground(Color.WHITE);

            JButton btnFood = new JButton("🍲美食搜索管理");
            btnFood.setBackground(new Color(255,170,60));
            btnFood.setForeground(Color.WHITE);

            JButton btnAI = new JButton("🤖AI智能美食推荐");
            btnAI.setBackground(new Color(120,220,120));
            btnAI.setForeground(Color.WHITE);

            mainFrame.add(btnUser);
            mainFrame.add(btnFood);
            mainFrame.add(btnAI);

            // AI按钮打开C自己的推荐界面
            btnAI.addActionListener(e->{
                new RecommendUI().setVisible(true);
            });

            // A、B界面由对应成员实现，这里预留跳转窗口
            btnUser.addActionListener(e->{
                JOptionPane.showMessageDialog(null,"跳转【A成员：用户登录注册界面】");
            });
            btnFood.addActionListener(e->{
                JOptionPane.showMessageDialog(null,"跳转【B成员：美食搜索界面】");
            });

            mainFrame.setVisible(true);
        });
    }
}