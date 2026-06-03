
public class Favorite {
    private int id;
    private int userId;
    private int foodId;
    private String foodName;
    private String type;
    private String remark;

    public Favorite() {}

    public Favorite(int id, int userId, int foodId, String foodName, String type, String remark) {
        this.id = id;
        this.userId = userId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.type = type;
        this.remark = remark;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getFoodId() { return foodId; }
    public void setFoodId(int foodId) { this.foodId = foodId; }
    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}