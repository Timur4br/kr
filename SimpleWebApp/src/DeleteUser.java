import dao.UserDao;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteUser", urlPatterns = "/DeleteUser")
public class DeleteUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем ID пользователя для удаления
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Создаем экземпляр UserDao для взаимодействия с базой данных
        UserDao userDao = new UserDao();

        // Удаляем пользователя из базы данных

        try {
            userDao.deleteUser(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }


        // Перенаправляем пользователя на другую страницу или обновляем текущую
        response.sendRedirect("users.jsp");
    }
}
