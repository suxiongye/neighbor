package servlet;

import action.BirthdayAction;
import bean.Point;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 15-7-21.
 */
public class BirthdayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BirthdayAction birthdayAction = new BirthdayAction(Integer.parseInt(request.getParameter("node_num")));
        response.setContentType("text;html;charset=utf-8");
        PrintWriter out = response.getWriter();
        birthdayAction.birthdayDis();
        Map<Point,Point> posPair = birthdayAction.getPosPair();

        for(Map.Entry<Point,Point> entry :posPair.entrySet()){
            out.println(entry.getKey().toString()+"  "+entry.getValue().toString());
        }
        out.print("latency = "+birthdayAction.getLatency());
    }
}
