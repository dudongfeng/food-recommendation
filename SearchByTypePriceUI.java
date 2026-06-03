import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchByTypePriceUI extends JFrame {
private FoodService foodService;
private JTextField tfType, tfMin, tfMax;

public SearchByTypePriceUI(FoodService foodService) {
this.foodService = foodService;
setSize(360, 640);
setLocationRelativeTo(null);
setLayout(null);
getContentPane().setBackground(new Color(240,255,245));

JLabel title = new JLabel("基础搜索",JLabel.CENTER);
title.setFont(new Font("微软雅黑",Font.BOLD,22));
title.setForeground(new Color(40,180,100));
title.setBounds(0,60,360,40);
add(title);

JLabel labType = new JLabel("菜系：");
labType.setBounds(40,150,80,30);
tfType = new JTextField();
tfType.setBounds(40,180,280,45);

JButton btnType = new JButton("按菜系搜索");
btnType.setBounds(40,240,280,50);
btnType.setBackground(new Color(80,200,120));
btnType.setForeground(Color.WHITE);
btnType.setBorderPainted(false);btnType.setOpaque(true);

JLabel labMin = new JLabel("最低价：");
labMin.setBounds(40,310,80,30);
tfMin = new JTextField();
tfMin.setBounds(40,340,130,45);

JLabel labMax = new JLabel("最高价：");
labMax.setBounds(190,310,80,30);
tfMax = new JTextField();
tfMax.setBounds(190,340,130,45);

JButton btnPrice = new JButton("按价格搜索");
btnPrice.setBounds(40,400,280,50);
btnPrice.setBackground(new Color(80,200,120));
btnPrice.setForeground(Color.WHITE);
btnPrice.setBorderPainted(false);btnPrice.setOpaque(true);

btnType.addActionListener(e->searchType());
btnPrice.addActionListener(e->searchPrice());

add(labType);add(tfType);add(btnType);
add(labMin);add(tfMin);add(labMax);add(tfMax);add(btnPrice);
setVisible(true);
}

private void searchType() {
String t = tfType.getText().trim();
ArrayList<Food> list = foodService.getFoodList();
StringBuilder sb = new StringBuilder();
for(Food f:list){
if(f.getType().equals(t)) sb.append(f.getName()+" | "+f.getPrice()+"元\n");
}
JOptionPane.showMessageDialog(this,sb.length()==0?"无结果":sb.toString());
}

private void searchPrice() {
double min = Double.parseDouble(tfMin.getText().trim());
double max = Double.parseDouble(tfMax.getText().trim());
ArrayList<Food> list = foodService.getFoodList();
StringBuilder sb = new StringBuilder();
for(Food f:list){
if(f.getPrice()>=min && f.getPrice()<=max) sb.append(f.getName()+"\n");
}
JOptionPane.showMessageDialog(this,sb.length()==0?"无结果":sb.toString());
}
}