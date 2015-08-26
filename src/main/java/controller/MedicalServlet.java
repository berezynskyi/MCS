package controller;

import dao.MedicalSpecialistDAO;
import dao.MedicalUnitDAO;
import entity.MedicalSpecialist;
import entity.MedicalUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * Сервлет для взаємодії із сторінкою /medicalCard.jsp
 * @author Anton Netudykhata and Max Berezynskyi
 *         22.03.2015.
 *
 */

@WebServlet("/MedUnit")
public class MedicalServlet extends HttpServlet {

    /**
     *  Отримуємо список медичних карток, і видаляємо у списку все,що не стосується
     *  заданого id призовника,чия картка відкрита.
     *  Відредагований список відправляємо на сторінку /medicalCard.jsp
     * @param req запит
     * @param resp відповідь
     * @throws ServletException необхідне виключення
     * @throws IOException необхідне виключення
     */

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int idInt = Integer.parseInt(id);

        MedicalUnitDAO dao = new MedicalUnitDAO();
        List<MedicalUnit> list = dao.getUnits();
        for (ListIterator<MedicalUnit> i = list.listIterator(); i.hasNext(); ) {
            MedicalUnit el = i.next();
            if(el.getIdConscriptCard() != idInt) {
                i.remove();
            }
        }

        req.setAttribute("medUnits",list);
        req.getRequestDispatcher("/medicalCard.jsp").forward(req, resp);

    }

    /**
     * Повертає прізвище,імя, по-батькові спеціаліста, із заданим id
     * @param id id потрібного спеціаліста
     * @return прізвище,імя, по-батькові спеціаліста
     */
    public static String getSpecFIO(int id) {
        MedicalSpecialistDAO dao = new MedicalSpecialistDAO();
        MedicalSpecialist spec = dao.getMedicalSpecialistById(id);
        String fio = spec.getRank()+" ("+spec.getSurname()+" "+spec.getName()+" "+spec.getFathersName()+")";
        return fio;
    }
}
