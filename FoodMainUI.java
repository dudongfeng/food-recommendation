import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FoodMainUI extends JFrame {
private FoodService service = new FoodService();

public FoodMainUI() {
setSize(360,640);
setLocationRelativeTo(null);
setLayout(null);
getContentPane().setBackground(new Color(250,255,245));

JLabel title = new JLabel("美食管理",JLabel.CENTER);
title.setFont(new Font("微软雅黑",Font.BOLD,24));
title.setForeground(new Color(0,180,100));
title.setBounds(0,60,360,40);
add(title);

JButton btnList = createBtn("全部美食",80);
JButton btnSearch = createBtn("基础搜索",150);
JButton btnAdv = createBtn("高级搜索",220);
JButton btnAdd = createBtn("添加美食",290);
JButton btnDetail = createBtn("查看详情",360);

btnList.addActionListener(e->showAll());
btnSearch.addActionListener(e->new SearchByTypePriceUI(service));
btnAdv.addActionListener(e->new AdvancedSearchUI(service));
btnAdd.addActionListener(e->addFood());
btnDetail.addActionListener(e->showDetail());

add(btnList);add(btnSearch);add(btnAdv);add(btnAdd);add(btnDetail);
setVisible(true);
}

private JButton createBtn(String txt,int y){
JButton btn = new JButton(txt);
btn.setBounds(40,y,280,50);
btn.setBackground(new Color(0,190,110));
btn.setForeground(Color.WHITE);
btn.setFont(new Font("微软雅黑",Font.BOLD,15));
btn.setBorderPainted(false);btn.setOpaque(true);
return btn;
}

private void showAll() {
ArrayList<Food> list = service.getFoodList();
StringBuilder sb = new StringBuilder();
for(Food f:list) sb.append(f.getId()+" | "+f.getName()+" | "+f.getType()+"\n");
JOptionPane.showMessageDialog(this,sb.toString());
}

private void addFood() {
String name = JOptionPane.showInputDialog("名称：");
String type = JOptionPane.showInputDialog("菜系：");
double price = Double.parseDouble(JOptionPane.showInputDialog("价格："));
double score = Double.parseDouble(JOptionPane.showInputDialog("评分："));
String intro = JOptionPane.showInputDialog("简介：");
service.addFood(name,type,price,score,intro);
JOptionPane.showMessageDialog(this,"添加成功");
}

private void showDetail() {
int id = Integer.parseInt(JOptionPane.showInputDialog("美食ID："));
for(Food f:service.getFoodList()){
if(f.getId()==id){
String msg = "名称："+f.getName()+"\n菜系："+f.getType()+"\n价格："+f.getPrice()+"\n评分："+f.getScore()+"\n介绍："+f.getIntro();
JOptionPane.showMessageDialog(this,msg);
return;
}
}
JOptionPane.showMessageDialog(this,"未找到");
}
}