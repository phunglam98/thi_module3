package service;

import model.Classroom;
import model.Student;
import service.IService.IClassroomService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomService implements IClassroomService<Classroom> {
    private Connection connection = ConnectToMySQL.getConnection();

    @Override
    public List<Classroom> findAll() {
        List<Classroom> classrooms = new ArrayList<>();
        String sql = "select * from classroom;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Classroom classroom = new Classroom(id, name);
                classrooms.add(classroom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classrooms;
    }
}
