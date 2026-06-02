import java.util.ArrayList;
import java.util.List;

/**
 * C-第3次提交：AI返回文本解析，转为Food实体（兼容B成员Food类格式）
 */
// 先复用B的Food简易实体（项目统一实体）
class Food{
    private String foodName;
    private String type;
    private double price;
    private String desc;
    // 构造+getset
    public Food(String foodName,String type,double price,String desc){
        this.foodName=foodName;
        this.type=type;
        this.price=price;
        this.desc=desc;
    }
    // getter
    public String getFoodName(){return foodName;}
    public String getType(){return type;}
    public double getPrice(){return price;}
    public String getDesc(){return desc;}
}

public class RecommendEngine {
    /**
     * 解析AI原始字符串→Food集合
     */
    public List<Food> parseFoodData(String aiRawText){
        List<Food> list = new ArrayList<>();
        if(aiRawText.contains("失败")) return list;
        String[] lines = aiRawText.split("\n");
        for(String line : lines){
            if(line.startsWith("【")&&line.contains("|")&&line.endsWith("】")){
                String inner = line.replace("【","").replace("】","");
                String[] arr = inner.split("\\|");
                if(arr.length>=4){
                    try{
                        String name = arr[0];
                        String type = arr[1];
                        double price = Double.parseDouble(arr[2]);
                        String reason = arr[3];
                        list.add(new Food(name,type,price,reason));
                    }catch (Exception e){
                        // 格式错误跳过本条
                    }
                }
            }
        }
        return list;
    }
}