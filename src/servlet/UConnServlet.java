package servlet;

import action.UConnAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 15-7-21.
 */
public class UConnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UConnAction uConnAction = new UConnAction();
        if(request.getParameter("prime")!=null && request.getParameter("prime")!="")
        {
            uConnAction.initUConn(Integer.parseInt(request.getParameter("prime")));
        }
        uConnAction.uConnDis();
        //输出
        response.setContentType("text;html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("Latency = " + uConnAction.getLatency());
    }
}
