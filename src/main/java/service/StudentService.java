package service;

import model.Classroom;
import model.Student;
import service.IService.IStudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService<Student> {
    private Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Student student) {
        String sql = "insert into student(name, DOB, email, address, phone, classID) values (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDOB());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getClassroom().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Student student) {
        String sql = "update  student set name = ?, DOB = ?, email = ?, address = ?, phone = ?, classID = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDOB());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6, student.getClassroom().getId());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from student where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "select student.*, c.name as nameClassroom from student join classroom c on c.id = student.classID order by student.id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String DOB = resultSet.getString("DOB");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int classID = resultSet.getInt("classID");
                String nameClassroom = resultSet.getString("nameClassroom");
                Classroom classroom = new Classroom(classID, nameClassroom);
                Student student = new Student(id, name, DOB, email, address, phone, classroom);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> findByName(String nameSearch) {
        List<Student> students = new ArrayList<>();
        String sql = "select student.*, c.name as nameClassroom from student join classroom c on c.id = student.classID WHERE student.name LIKE '%" + nameSearch + "%'  order by student.id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String DOB = resultSet.getString("DOB");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int classID = resultSet.getInt("classID");
                String nameClassroom = resultSet.getString("nameClassroom");
                Classroom classroom = new Classroom(classID, nameClassroom);
                Student student = new Student(id, name, DOB, email, address, phone, classroom);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
