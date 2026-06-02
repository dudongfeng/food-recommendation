/**
 * C-第2次提交：AI推荐提示词模板，3种场景：约会/聚餐/养生
 */
public class PromptTemplate {
    // 场景枚举
    public enum Scene {DATE,FAMILY,EATHEALTH}

    /**
     * 根据场景+偏好生成完整prompt
     * @param scene 推荐场景
     * @param favor 用户口味偏好
     * @param maxPrice 预算上限
     * @return 组装好的AI提问
     */
    public static String buildPrompt(Scene scene,String favor,double maxPrice){
        String base = "";
        switch (scene){
            case DATE:
                base = "帮我推荐适合情侣约会的美食，口味："+favor+"，总价不超过"+maxPrice+"元，返回格式：【菜名|菜系|单价|推荐理由】多条换行";
                break;
            case FAMILY:
                base = "帮我推荐家庭聚餐菜品，口味："+favor+"，人均不超过"+maxPrice+"元，返回格式：【菜名|菜系|单价|推荐理由】多条换行";
                break;
            case EATHEALTH:
                base = "帮我推荐养生健康餐，口味："+favor+"，单餐不超过"+maxPrice+"元，返回格式：【菜名|菜系|单价|推荐理由】多条换行";
                break;
        }
        return base;
    }
}