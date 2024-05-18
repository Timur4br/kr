import dao.QuestDao;
import dao.UserDao;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteQuest", urlPatterns = "/DeleteQuest")
public class DeleteQuest extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем ID пользователя для удаления
        int questId = Integer.parseInt(request.getParameter("questId"));

        // Создаем экземпляр UserDao для взаимодействия с базой данных
        QuestDao questDao= new QuestDao();

        // Удаляем пользователя из базы данных

        try {
            questDao.deleteUser(questId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }


        // Перенаправляем пользователя на другую страницу или обновляем текущую
        response.sendRedirect("quests.jsp");
    }
}
