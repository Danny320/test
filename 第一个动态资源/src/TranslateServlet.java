import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/24 17:54
 */
public class TranslateServlet extends HttpServlet {
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("apple","苹果");
        map.put("pear","梨");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String english = req.getParameter("english");
        String chinese;
        if(map.containsKey(english)) {
            chinese = map.get(english);
        }else {
            chinese = "null";
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<p>"+english+"的中文翻译是"+chinese+"</p>");
    }
}
