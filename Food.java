public class Food {
    private String name;
    private String type;
    private double price;
    private double score;

    public class Food {
    private int id;
    private String name;
    private String cuisine;
    private double price;
    private double rating;
    java
public class Food {
private int id;
private String name;
private String type;
private double price;
private double score;
private String intro;

public Food() {}

public Food(int id, String name, String type, double price, double score, String intro) {
this.id = id;
this.name = name;
this.type = type;
this.price = price;
this.score = score;
this.intro = intro;
}

public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public String getType() { return type; }
public void setType(String type) { this.type = type; }
public double getPrice() { return price; }
public void setPrice(double price) { this.price = price; }
public double getScore() { return score; }
public void setScore(double score) { this.score = score; }
public String getIntro() { return intro; }
public void setIntro(String intro) { this.intro = intro; }
}