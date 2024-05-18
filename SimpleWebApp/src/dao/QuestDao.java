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

import model.Quest;


public class QuestDao {
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


    public List<Quest> getAllQuest() throws SQLException, NamingException {
        List<Quest> quests = new ArrayList<>();
        // Получаем соединение с базой данных
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // SQL запрос для получения всех пользователей
        String sql = "SELECT * FROM quests";

        try {
            // Подготавливаем запрос
            preparedStatement = connection.prepareStatement(sql);

            // Выполняем запрос и получаем результат
            resultSet = preparedStatement.executeQuery();

            // Обрабатываем результат
            while (resultSet.next()) {
                // Создаем объект User для каждой записи в результате запроса
                Quest quest = new Quest();
                quest.setQuestId(resultSet.getInt("questId"));
                quest.setQuestTitle(resultSet.getString("questTitle"));
                quest.setQuestText(resultSet.getString("questText"));
                quest.setPersonId(resultSet.getString("personId"));
                quest.setReward(resultSet.getInt("reward"));
                quest.setPenalty(resultSet.getInt("penalty"));
                //quest.setTimeOfStarted(resultSet.Timestamp("timeOfStarted"));
                quest.setTimeForQuestInMinutes(resultSet.getInt("timeForQuestInMinutes"));
                quest.setPlaceId(resultSet.getString("placeId"));
                quest.setModelId(resultSet.getString("modelId"));
                quest.setLevelDifficulty(resultSet.getInt("levelDifficulty"));
                //est.setQuestStatus(resultSet.getString("questStatus")))


                // Добавляем пользователя в список
                quests.add(quest);
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
        return quests;
    }
    public void deleteUser(int questId) throws SQLException, NamingException {
        // Получаем соединение с базой данных
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        // SQL запрос для удаления пользователя
        String sql = "DELETE FROM quests WHERE questId = ?";

        try {
            // Подготавливаем запрос
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, questId);

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
}
