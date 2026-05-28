public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String favoriteCuisine;

    public User() {}

    public User(int id, String username, String password, String nickname, String phone, String favoriteCuisine) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.favoriteCuisine = favoriteCuisine;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getFavoriteCuisine() { return favoriteCuisine; }
    public void setFavoriteCuisine(String favoriteCuisine) { this.favoriteCuisine = favoriteCuisine; }
}