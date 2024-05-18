package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
    

    // Метод для получения соединения с базой данных
    private Connection getConnection() throws NamingException, SQLException {
        // Получаем контекст JNDI
        InitialContext initialContext = new InitialContext();
        // Получаем ссылку на ресурс данных JNDI
        DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/forkr");

        // Выводим информацию о подключенной базе данных
        System.out.println("Connected to database: " + dataSource.getConnection().getCatalog());

        // Получаем соединение с базой данных из ресурса данных
        return dataSource.getConnection();
    }

    public List<User> getAllUsers() throws SQLException, NamingException {
        List<User> users = new ArrayList<>();
        // Получаем соединение с базой данных
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // SQL запрос для получения всех пользователей
        String sql = "SELECT * FROM users";

        try {
            // Подготавливаем запрос
            preparedStatement = connection.prepareStatement(sql);

            // Выполняем запрос и получаем результат
            resultSet = preparedStatement.executeQuery();

            // Обрабатываем результат
            while (resultSet.next()) {
                // Создаем объект User для каждой записи в результате запроса
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setAuthToken(resultSet.getString("authToken"));
                user.setUserName(resultSet.getString("userName"));
                user.setPositionOnStarship(resultSet.getString("positionOnStarship"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
                user.setBalance(resultSet.getInt("balance"));
                user.setBackground(resultSet.getString("background"));
                user.setPublicBackground(resultSet.getString("publicBackground"));
                user.setPhoto(resultSet.getString("photo"));
                user.setSecurityBackground(resultSet.getString("securityBackground"));
                user.setMedicalBackground(resultSet.getString("medicalBackground"));
                user.setPsychologyBackground(resultSet.getString("psychologyBackground"));
                user.setLastAvailable(resultSet.getInt("lastAvailable"));
                user.setUserSettings(resultSet.getInt("userSettings"));

                // Добавляем пользователя в список
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибок
        } finally {
            // Закрываем ресурсы
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
    public void deleteUser(int userId) throws SQLException, NamingException {
        // Получаем соединение с базой данных
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        // SQL запрос для удаления пользователя
        String sql = "DELETE FROM users WHERE userId = ?";

        try {
            // Подготавливаем запрос
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибок
        } finally {
            // Закрываем ресурсы
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addUser(User user) throws SQLException, NamingException {
        // Получаем соединение с базой данных
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            // SQL запрос для добавления нового пользователя
            String sql = "INSERT INTO users (userName, positionOnStarship, age, sex, balance) VALUES (?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            // Устанавливаем значения параметров запроса
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPositionOnStarship());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setInt(5, user.getBalance());

            // Выполняем запрос
            preparedStatement.executeUpdate();
        } finally {
            // Закрываем ресурсы
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
//
//    // Метод для получения пользователя по ID
//    public UserEntity getUserById(int id_user) {
//        try (Connection connection = getConnection()) {
//            // Подготавливаем запрос к базе данных
//            String sql = "SELECT * FROM users WHERE id_user = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setInt(1, id_user);
//                // Выполняем запрос
//                System.out.println("!!!Работает!!!");
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    System.out.println("Не пустой");
//                    // Если результат не пустой, создаем объект UserEntity и заполняем его данными
//                    if (resultSet.next()) {
//                        UserEntity user = new UserEntity();
//                        user.setIdUser(resultSet.getInt("id_user"));
//                        user.setName(resultSet.getString("name"));
//                        user.setPassword(resultSet.getString("password"));
//                        user.setEmail(resultSet.getString("email"));
//                        user.setRole(resultSet.getString("role"));
//                        return user;
//                    }
//                }
//            }
//        } catch (NamingException | SQLException e) {
//            e.printStackTrace(); // Обработка ошибок доступа к базе данных
//        }
//
//        return null; // Если пользователь не найден
//    }
//    // Метод для проверки логина и пароля пользователя
//    public boolean checkLogin(String name, String password) {
//        try (Connection connection = getConnection()) {
//            // Подготавливаем запрос к базе данных
//            String sql = "SELECT * FROM users";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                // Выполняем запрос
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    // Перебираем все комбинации имен и паролей
//                    while (resultSet.next()) {
//                        String storedName = resultSet.getString("name");
//                        String storedPassword = resultSet.getString("password");
//                        // Если найдено совпадение, возвращаем true
//                        if (name.equals(storedName) && password.equals(storedPassword)) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        } catch (NamingException | SQLException e) {
//            e.printStackTrace(); // Обработка ошибок доступа к базе данных
//        }
//        // Если не найдено совпадение, возвращаем false
//        return false;
//    }
//
//    public void saveUser(UserEntity user) {
//        try (Connection connection = getConnection()) {
//            String sql = "INSERT INTO users (id_user, name, password, email) VALUES (null, ?, ?, ?)";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, user.getName());
//                statement.setString(2, user.getPassword());
//                statement.setString(3, user.getEmail());
//                statement.executeUpdate();
//            }
//        } catch (NamingException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String getUserRole(String name, String pass) {
//        // Создать экземпляр UserDao для доступа к данным пользователей
//        UserDao userDao = new UserDao();
//
//        // Получить пользователя по имени и паролю
//        UserEntity user = userDao.getUserByNameAndPassword(name, pass);
//
//        // Проверить, существует ли пользователь
//        if (user != null) {
//            // Вернуть роль пользователя
//            return user.getRole();
//        } else {
//            // Если пользователь не найден, вернуть null или другое значение по умолчанию
//            return null;
//        }
//    }
//
//    public UserEntity getUserByNameAndPassword(String name, String password) {
//        UserEntity user = null;
//
//        try (Connection connection = getConnection()) {
//            String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
//
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, name);
//                statement.setString(2, password);
//
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    if (resultSet.next()) {
//                        // Создать объект UserEntity и заполнить его данными из результата запроса
//                        user = new UserEntity();
//                        user.setIdUser(resultSet.getInt("id_user"));
//                        user.setName(resultSet.getString("name"));
//                        user.setPassword(resultSet.getString("password"));
//                        user.setEmail(resultSet.getString("email"));
//                        user.setRole(resultSet.getString("role"));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }
//
//        return user;
//    }
//
//    public boolean checkAdminLogin(String name, String pass) {
//        try (Connection connection = getConnection()) {
//            String sql = "SELECT COUNT(*) FROM admins WHERE name = ? AND password = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, name);
//                statement.setString(2, pass);
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    if (resultSet.next()) {
//                        int count = resultSet.getInt(1);
//                        return count > 0; // Возвращаем true, если найдена хотя бы одна запись
//                    }
//                }
//            }
//        } catch (NamingException | SQLException e) {
//            e.printStackTrace(); // Обработка ошибок доступа к базе данных
//        }
//        return false; // Если не найдено ни одной записи
//    }



}
