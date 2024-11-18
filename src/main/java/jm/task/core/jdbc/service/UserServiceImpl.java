package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl r = new UserDaoJDBCImpl();
    public void createUsersTable() {
    r.createUsersTable();
    }

    public void dropUsersTable() {
        r.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        r.saveUser(name, lastName, age);
        System.out.printf("User с именем — %s добавлен в базу данных \n", name);
    }

    public void removeUserById(long id) {
        r.removeUserById(id);
    }

    public List<User> getAllUsers() {
    List<User> list = r.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }

    public void cleanUsersTable() {
        r.cleanUsersTable();
    }
}
