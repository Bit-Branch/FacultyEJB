package servlet;

import bean.FacultyBean;
import entity.Faculty;
import servlet.constant.FacultyConsts;
import servlet.constant.PagePath;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class MainServlet extends HttpServlet{

    @EJB
    private FacultyBean facultyBean = new FacultyBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Faculty> allFaculty = facultyBean.getAll();

        req.setAttribute(FacultyConsts.FACULTIES, allFaculty);

        req.getRequestDispatcher(PagePath.LIST_PAGE).forward(req, resp);

    }

}