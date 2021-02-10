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



@WebServlet("/add")
public class AddFacultyServlet extends HttpServlet {

    @EJB
    private FacultyBean facultyBean = new FacultyBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("edit") != null)
        {
            int id = Integer.parseInt(req.getParameter("edit"));
            Faculty faculty = facultyBean.get(id);

            req.setAttribute(FacultyConsts.FACULTY, faculty);
        }

        req.getRequestDispatcher(PagePath.ADD_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        try {
            String name = req.getParameter(FacultyConsts.NAME);
            int numberOfPeople = Integer.parseInt(req.getParameter(FacultyConsts.NUMBER_OF_PEOPLE).isEmpty() ?
                                                    "-1" : req.getParameter(FacultyConsts.NUMBER_OF_PEOPLE));

            double semesterFee = Double.parseDouble(req.getParameter(FacultyConsts.SEMESTER_FEE).isEmpty() ?
                                                    "-1" : req.getParameter(FacultyConsts.SEMESTER_FEE));

            if (!name.isEmpty() && numberOfPeople > 0 && semesterFee > 0)
            {
                if (!req.getParameter(FacultyConsts.ID).isEmpty())
                {
                    int id = Integer.parseInt(req.getParameter(FacultyConsts.ID));
                    Faculty faculty = facultyBean.get(id);
                    faculty.setName(name);
                    faculty.setNumberOfPeople(numberOfPeople);
                    faculty.setSemesterFee(semesterFee);

                    facultyBean.update(faculty);
                } else {
                    facultyBean.add(new Faculty(name, numberOfPeople, semesterFee));
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            resp.sendRedirect("list");
        }
    }
}