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

@WebServlet("/calculate")
public class CalculateFacultyServlet extends HttpServlet {
    @EJB
    private FacultyBean facultyBean = new FacultyBean();

    private final int DAYS_IN_SEMESTER = 122;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter(FacultyConsts.ID) != null)
        {
            int id = Integer.parseInt(req.getParameter(FacultyConsts.ID));
            Faculty faculty = facultyBean.get(id);

            req.setAttribute(FacultyConsts.FACULTY, faculty);
            req.setAttribute(FacultyConsts.ID,id);
        }

        req.getRequestDispatcher(PagePath.CALCULATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        try
        {
            int numberOfDays = Integer.parseInt(req.getParameter(FacultyConsts.PERIOD).isEmpty() ?
                                                    "-1" : req.getParameter(FacultyConsts.PERIOD));
            if (numberOfDays > 0)
            {
                if (req.getParameter(FacultyConsts.ID) != null && !req.getParameter(FacultyConsts.ID).isEmpty())
                {
                    int id = Integer.parseInt(req.getParameter(FacultyConsts.ID));
                    Faculty faculty = facultyBean.get(id);
                    double fee = faculty.getSemesterFee();
                    double calculatedFee = fee/DAYS_IN_SEMESTER * numberOfDays;
                    req.setAttribute("calculatedFee", calculatedFee);
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            req.getRequestDispatcher(PagePath.CALCULATE_PAGE).forward(req, resp);
        }
    }
}
