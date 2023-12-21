package controller;

import model.Classroom;
import model.Student;
import service.ClassroomService;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentService();
    private ClassroomService classroomService = new ClassroomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "manager":
                showHomePage(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                showFormDelete(req, resp);
                break;

        }
    }

    private void showFormDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        for (Student s :
                studentService.findAll()) {
            if (s.getId() == id) {
                req.setAttribute("student", s);
            }
        }
        List<Classroom> classrooms = classroomService.findAll();
        req.setAttribute("lstClassroom", classrooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/deleteStudent.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        for (Student s :
                studentService.findAll()) {
            if (s.getId() == id) {
                req.setAttribute("student", s);
            }
        }
        List<Classroom> classrooms = classroomService.findAll();
        req.setAttribute("lstClassroom", classrooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/editStudent.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        List<Classroom> classrooms = classroomService.findAll();
        req.setAttribute("lstStudent", students);
        req.setAttribute("lstClassroom", classrooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                editStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameSearch");
        List<Student> students = studentService.findByName(name);
        List<Classroom> classrooms = classroomService.findAll();
        req.setAttribute("lstStudent", students);
        req.setAttribute("lstClassroom", classrooms);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.delete(id);
        resp.sendRedirect("/student?action=manager");
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String DOB = req.getParameter("DOB");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int idClass = Integer.parseInt(req.getParameter("idClass"));
        Classroom classroom = new Classroom(idClass);
        Student student = new Student(name, DOB, email, address, phone, classroom);
        studentService.edit(id, student);
        resp.sendRedirect("/student?action=manager");
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String DOB = req.getParameter("DOB");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int idClass = Integer.parseInt(req.getParameter("idClass"));
        Classroom classroom = new Classroom(idClass);
        Student student = new Student(name, DOB, email, address, phone, classroom);
        studentService.add(student);
        resp.sendRedirect("/student?action=manager");
    }
}
