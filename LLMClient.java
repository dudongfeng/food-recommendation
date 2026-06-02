import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * C-第1次提交：大模型http调用工具
 */
public class LLMClient {
    // 模拟AI接口地址，可替换真实大模型api
    private static final String API_URL = "https://mock-ai-api.com/chat";

    // 发送提示词，返回AI原始回答
    public String chat(String prompt) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json;utf-8");

            // 写入请求参数
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
            String jsonReq = "{\"prompt\":\"" + prompt.replace("\"","\\\"") + "\"}";
            osw.write(jsonReq);
            osw.flush();
            osw.close();

            // 读取AI返回结果
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            br.close();
            conn.disconnect();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "AI调用失败：网络异常";
        }
    }
}