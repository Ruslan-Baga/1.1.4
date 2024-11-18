package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        try (Statement statement = util.getConnection().createStatement()) {
            String createTable =  "CREATE TABLE IF NOT EXISTS users ("
                    + "id BIGINT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(255) NOT NULL, "
                    + "lastname VARCHAR(255) NOT NULL,"
                    + "age TINYINT(3) NOT NULL"
                    + ")";
            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }


    public void dropUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE users");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
            String query = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
        try (PreparedStatement prepStat = util.getConnection().prepareStatement(query)) {
            prepStat.setString(1, name);
            prepStat.setString(2, lastName);
            prepStat.setByte(3, age);
            prepStat.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement statement = util.getConnection().prepareStatement("DELETE FROM users where id = ?")){
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try(Statement statement = util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users")) {
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cleanUsersTable() {
        try(Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
