import java.util.ArrayList;

public class FoodService {
private ArrayList<Food> foodList = new ArrayList<>();
private int idSeq = 1;

public FoodService() {
initData();
}

private void initData() {
foodList.add(new Food(idSeq++, "麻婆豆腐", "川菜", 28, 4.7, "麻辣鲜香，下饭神器"));
foodList.add(new Food(idSeq++, "水煮鱼", "川菜", 58, 4.8, "鲜嫩麻辣，油而不腻"));
foodList.add(new Food(idSeq++, "清蒸鲈鱼", "粤菜", 68, 4.9, "清淡鲜美，营养丰富"));
foodList.add(new Food(idSeq++, "白切鸡", "粤菜", 48, 4.6, "原汁原味，肉质鲜嫩"));
foodList.add(new Food(idSeq++, "三文鱼刺身", "日料", 88, 4.9, "新鲜爽口，高蛋白"));
}

public void addFood(String name, String type, double price, double score, String intro) {
foodList.add(new Food(idSeq++, name, type, price, score, intro));
}

public ArrayList<Food> getFoodList() {
return foodList;
}
}