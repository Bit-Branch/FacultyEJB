package servlet;
import bean.FacultyBean;
import entity.Faculty;
import servlet.constant.FacultyConsts;
import servlet.constant.PagePath;
import util.FacultyComparator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/filter")
public class FilterFacultyServlet extends HttpServlet {

    @EJB
    private FacultyBean facultyBean = new FacultyBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Faculty> allFaculty = facultyBean.getAll();

        req.setAttribute(FacultyConsts.FACULTIES, allFaculty);

        req.getRequestDispatcher(PagePath.FILTER_PAGE).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        try
        {
            List<Faculty> allFaculty = facultyBean.getAll();
            List<Faculty> filteredFaculty = new ArrayList<>();
            Faculty first = Collections.min(allFaculty,new FacultyComparator());
            filteredFaculty.add(first);
            if (allFaculty.size() > 1)
            {
                allFaculty.remove(first);
                Faculty second = Collections.min(allFaculty,new FacultyComparator());
                filteredFaculty.add(second);
            }

            req.setAttribute(FacultyConsts.FACULTIES, filteredFaculty);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            req.getRequestDispatcher(PagePath.FILTER_PAGE).forward(req, resp);
        }
    }
}