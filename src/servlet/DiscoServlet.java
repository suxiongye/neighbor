package servlet;

import action.DiscoAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 15-7-21.
 */
public class DiscoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscoAction discoAction = new DiscoAction();
        if (request.getParameter("prime1")!="" && request.getParameter("prime2")!="")
        {
            discoAction.initDis(Integer.parseInt(request.getParameter("prime1")),
                    Integer.parseInt(request.getParameter("prime2")));
        }
        discoAction.discoDis();
        //输出
        response.setContentType("text;html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("Latency = " + discoAction.getLatency());
    }
}
