import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * C-第4次提交：AI推荐图形界面，手机竖版GUI，彩色按钮
 */
public class RecommendUI extends JFrame {
    private JComboBox<String> sceneBox; // 场景下拉
    private JTextField favorField;      // 口味输入
    private JTextField priceField;     // 预算输入
    private JTextArea resultArea;     // 推荐结果展示

    public RecommendUI(){
        initUI();
    }

    private void initUI(){
        // 手机尺寸：竖屏
        setTitle("AI美食智能推荐");
        setSize(360,640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        setResizable(false);

        // 顶部面板
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4,2,5,5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        topPanel.add(new JLabel("用餐场景："));
        sceneBox = new JComboBox<>(new String[]{"约会用餐","家庭聚餐","养生健康餐"});
        topPanel.add(sceneBox);

        topPanel.add(new JLabel("口味偏好："));
        favorField = new JTextField("清淡/麻辣/酸甜");
        topPanel.add(favorField);

        topPanel.add(new JLabel("预算上限(元)："));
        priceField = new JTextField("80");
        topPanel.add(priceField);

        // 彩色按钮
        JButton recommendBtn = new JButton("✨一键AI推荐");
        recommendBtn.setBackground(new Color(255,120,120));
        recommendBtn.setForeground(Color.WHITE);
        recommendBtn.setFont(new Font("微软雅黑",Font.BOLD,14));
        topPanel.add(recommendBtn);

        // 结果区域
        resultArea = new JTextArea();
        resultArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        resultArea.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(resultArea);

        add(topPanel,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);

        // 按钮点击事件：完整AI链路
        recommendBtn.addActionListener(e->{
            doRecommend();
        });
    }

    // 执行推荐全流程：模板→调用AI→解析→展示
    private void doRecommend(){
        try {
            // 1.获取页面参数
            String sceneStr = (String) sceneBox.getSelectedItem();
            String favor = favorField.getText().trim();
            double price = Double.parseDouble(priceField.getText());

            // 2.转换场景枚举
            PromptTemplate.Scene scene;
            switch (sceneStr){
                case "约会用餐":scene=PromptTemplate.Scene.DATE;break;
                case "家庭聚餐":scene=PromptTemplate.Scene.FAMILY;break;
                default:scene=PromptTemplate.Scene.EATHEALTH;
            }

            // 3.拼接提示词
            String prompt = PromptTemplate.buildPrompt(scene,favor,price);
            // 4.调用AI
            LLMClient client = new LLMClient();
            String aiResp = client.chat(prompt);
            // 5.解析结果
            RecommendEngine engine = new RecommendEngine();
            List<Food> foodList = engine.parseFoodData(aiResp);

            // 6.渲染到界面
            StringBuilder sb = new StringBuilder("====AI推荐美食清单====\n");
            for(Food f:foodList){
                sb.append("【").append(f.getFoodName()).append("】\n")
                        .append("菜系：").append(f.getType()).append("｜单价：").append(f.getPrice()).append("元\n")
                        .append("推荐理由：").append(f.getDesc()).append("\n-----------------\n");
            }
            resultArea.setText(sb.toString());
        }catch (Exception err){
            JOptionPane.showMessageDialog(this,"输入有误！预算填写数字");
        }
    }
}