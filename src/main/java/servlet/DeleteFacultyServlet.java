package servlet;

import bean.FacultyBean;
import servlet.constant.FacultyConsts;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteFacultyServlet extends HttpServlet {

    @EJB
    private FacultyBean facultyBean = new FacultyBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        if(req.getParameter(FacultyConsts.ID) != null && !req.getParameter(FacultyConsts.ID).isEmpty())
        {
            int id = Integer.parseInt(req.getParameter(FacultyConsts.ID));
            facultyBean.delete(id);
        }
        resp.sendRedirect("list");
    }
}