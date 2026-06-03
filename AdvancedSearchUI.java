import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class AdvancedSearchUI extends JFrame {
private FoodService foodService;
private JTextField tfKey;

public AdvancedSearchUI(FoodService foodService) {
this.foodService = foodService;
setSize(360,640);
setLocationRelativeTo(null);
setLayout(null);
getContentPane().setBackground(new Color(245,245,255));

JLabel title = new JLabel("高级搜索",JLabel.CENTER);
title.setFont(new Font("微软雅黑",Font.BOLD,22));
title.setForeground(new Color(120,80,220));
title.setBounds(0,60,360,40);
add(title);

JButton btnSort = new JButton("按评分从高到低");
btnSort.setBounds(40,180,280,50);
btnSort.setBackground(new Color(140,100,230));
btnSort.setForeground(Color.WHITE);
btnSort.setBorderPainted(false);btnSort.setOpaque(true);

JLabel labKey = new JLabel("关键词：");
labKey.setBounds(40,260,100,30);
tfKey = new JTextField();
tfKey.setBounds(40,290,280,45);

JButton btnFuzzy = new JButton("模糊搜索");
btnFuzzy.setBounds(40,350,280,50);
btnFuzzy.setBackground(new Color(140,100,230));
btnFuzzy.setForeground(Color.WHITE);
btnFuzzy.setBorderPainted(false);btnFuzzy.setOpaque(true);

btnSort.addActionListener(e->sortScore());
btnFuzzy.addActionListener(e->fuzzy());

add(btnSort);add(labKey);add(tfKey);add(btnFuzzy);
setVisible(true);
}

private void sortScore() {
ArrayList<Food> list = new ArrayList<>(foodService.getFoodList());
list.sort(Comparator.comparingDouble(Food::getScore).reversed());
StringBuilder sb = new StringBuilder();
for(Food f:list) sb.append(f.getName()+" | "+f.getScore()+"\n");
JOptionPane.showMessageDialog(this,sb.toString());
}

private void fuzzy() {
String k = tfKey.getText().trim().toLowerCase();
ArrayList<Food> list = foodService.getFoodList();
StringBuilder sb = new StringBuilder();
for(Food f:list){
if(f.getName().toLowerCase().contains(k) || f.getIntro().toLowerCase().contains(k)){
sb.append(f.getName()+"\n");
}
}
JOptionPane.showMessageDialog(this,sb.length()==0?"无结果":sb.toString());
}
}