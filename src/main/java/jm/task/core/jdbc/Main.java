package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    private static UserService userService = new UserServiceImpl();
    private static User user1 = new User("Максим","Иванов", (byte) 45);
    private static User user2 = new User("Данил", "Сидоренко", (byte) 33);
    private static User user3 = new User("Иван", "Кирсанов", (byte) 21);
    private static User user4 = new User("Катя", "Сидорова", (byte) 13);

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
