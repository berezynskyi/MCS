package controller;

import dao.ConscriptCardDAO;
import dao.MedicalSpecialistDAO;
import entity.ConscriptCard;
import entity.MedicalSpecialist;
import entity.MedicalUnit;
import org.hibernate.Session;
import persistance.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Сервлет для взаємодії із сторінкою /profile.jsp
 * @author Anton Netudykhata and Max Berezynskyi
 *         22.03.2015.
 *
 */

@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet  {

    /**
     *  Отримуємо ідентифкатор конкретного призовника, виводимо усю інформацію, що стосується
     *  заданого призовника.
     *  Усю інформацію про призовника відправляємо на сторінку /profile.jsp
     * @param req запит
     * @param resp відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */
     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int idInt = Integer.parseInt(id);

        ConscriptCardDAO dao = new ConscriptCardDAO();
        ConscriptCard card = dao.getConscriptCardById(idInt);
        req.setAttribute("card",card);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
     }

    /**
     *  Записуємо в базу коментар лікаря, звіряючи для цього його унікальний пароль з
     *  існуючим в базі данних.
     *  Якщо паролі співпадають - успішна запис коментаря в базу, якщо ні -
     *  коментар не записаний, відповідне сповіщення на екран.
     * @param request запит
     * @param response відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //handling request
        String comment = request.getParameter("comment");
        request.setAttribute("comment",comment);
        String password = request.getParameter("password");
        request.setAttribute("password",password);
        String notpass = new String();
        notpass = "";


        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        ConscriptCardDAO dao = new ConscriptCardDAO();
        ConscriptCard card = dao.getConscriptCardById(idInt);
        request.setAttribute("card",card);

        if (isInBase(password)) {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            MedicalUnit unit = new MedicalUnit();

            //Определяем врача, который вводит диагноз
            int idOfSpecialist = identifySpecialist(password);

            unit.setIdConscriptCard(idInt);
            unit.setComment(comment);//comment
            unit.setIdMedicalSpecialist(idOfSpecialist);

            session.save(unit);
            session.getTransaction().commit();
            notpass = "Данні введені в базу";
            comment = "";
            request.setAttribute("comment", comment);
        } else {
            notpass = "Невірно введений пароль";
        }

        request.setAttribute("notpass", notpass);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
}

    /**
     * Повертає булевську перемінну, яка відповідає за
     * відповність введеного пароля з паролем спеціаліста
     * @param pass пароль потрібного спеціаліста
     * @return сходження пароля з наявним в базі
     */
    private boolean isInBase(String pass) {
        MedicalSpecialistDAO med = new MedicalSpecialistDAO();
        List<MedicalSpecialist> list = med.getSpecialists();
        Iterator iterator = list.iterator();
        boolean isHere = false;

        for (MedicalSpecialist specialist : list) {
            if (pass.equals(specialist.getPassword())) {
                isHere = true;
            }
        }
        return isHere;
    }

    /**
     * Повертає ідентифікатор спеціаліста, визначивши тим самим
     * пароль, якого спеціаліста був введений
     * @param password пароль спеціаліста
     * @return ідентифікатор спеціаліста
     */
    private int identifySpecialist (String password) {
        MedicalSpecialistDAO med = new MedicalSpecialistDAO();
        List<MedicalSpecialist> list = med.getSpecialists();
        int idSpecialist = 0;
        for (MedicalSpecialist specialist : list) {
            if (password.equals(specialist.getPassword())) {
                idSpecialist = specialist.getIdMedicalSpecialist();
            }
        }
        return idSpecialist;
    }

}
