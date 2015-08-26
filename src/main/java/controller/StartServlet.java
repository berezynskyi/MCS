package controller;

import dao.ConscriptCardDAO;
import entity.ConscriptCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Сервлет для взаємодії із сторінкою /index.jsp
 * @author Anton Netudykhata and Max Berezynskyi
 *         22.03.2015.
 *
 */

@WebServlet("/MedicalOffice")
public class StartServlet extends HttpServlet {

    /**
     *  Отримуємо список призовників, виводимо весь список на сторінку.
     *  Відредагований список відправляємо на сторінку /index.jsp
     * @param req запит
     * @param resp відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ConscriptCardDAO dao = new ConscriptCardDAO();
        List<ConscriptCard> list = dao.getCards();
        req.setAttribute("cards",list);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
