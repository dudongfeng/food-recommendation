
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserMainUI extends JFrame {
    private ArrayList<Favorite> favList = new ArrayList<>();
    private int favId = 1;

    public UserMainUI() {
        setSize(360, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 250, 245));

        JLabel title = new JLabel("用户中心", JLabel.CENTER);
        title.setBounds(0, 60, 360, 40);
        title.setFont(new Font("微软雅黑", Font.BOLD, 24));
        title.setForeground(new Color(255, 80, 0));
        add(title);

        JButton btnList = createBtn("我的收藏", 170, 80);
        JButton btnAdd = createBtn("添加收藏", 170, 150);
        JButton btnDel = createBtn("删除收藏", 170, 220);
        JButton btnFilter = createBtn("筛选收藏", 170, 290);
        JButton btnFood = createBtn("美食管理", 170, 360);
        JButton btnAi = createBtn("AI推荐", 170, 430);

        btnList.addActionListener(e -> showFav());
        btnAdd.addActionListener(e -> addFav());
        btnDel.addActionListener(e -> delFav());
        btnFilter.addActionListener(e -> filterFav());
        btnFood.addActionListener(e -> new FoodMainUI().setVisible(true));
        btnAi.addActionListener(e -> new RecommendUI().setVisible(true));

        add(btnList);add(btnAdd);add(btnDel);add(btnFilter);add(btnFood);add(btnAi);
        setVisible(true);
    }

    private JButton createBtn(String txt, int w, int y) {
        JButton btn = new JButton(txt);
        btn.setBounds((360-w)/2, y, w, 55);
        btn.setBackground(new Color(255, 120, 60));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("微软雅黑", Font.BOLD, 15));
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        return btn;
    }

    private void showFav() {
        StringBuilder sb = new StringBuilder();
        for (Favorite f : favList) {
            if (f.getUserId() == UserLoginUI.currentUser.getId()) {
                sb.append(f.getId()+" | "+f.getFoodName()+" | "+f.getType()+"\n");
            }
        }
        JOptionPane.showMessageDialog(this, sb.length()==0 ? "暂无收藏" : sb.toString());
    }

    private void addFav() {
        String fid = JOptionPane.showInputDialog("美食ID：");
        String fname = JOptionPane.showInputDialog("美食名称：");
        String type = JOptionPane.showInputDialog("菜系：");
        String remark = JOptionPane.showInputDialog("备注：");
        favList.add(new Favorite(favId++, UserLoginUI.currentUser.getId(),
                Integer.parseInt(fid), fname, type, remark));
        JOptionPane.showMessageDialog(this, "收藏成功");
    }

    private void delFav() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("收藏ID："));
        favList.removeIf(f->f.getId()==id && f.getUserId()==UserLoginUI.currentUser.getId());
        JOptionPane.showMessageDialog(this, "删除成功");
    }

    private void filterFav() {
        String type = JOptionPane.showInputDialog("输入菜系：");
        StringBuilder sb = new StringBuilder();
        for (Favorite f : favList) {
            if (f.getUserId() == UserLoginUI.currentUser.getId() && f.getType().equals(type)) {
                sb.append(f.getFoodName()+"\n");
            }
        }
        JOptionPane.showMessageDialog(this, sb.length()==0 ? "无结果" : sb.toString());
    }
}