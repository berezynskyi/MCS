package dao;

import entity.MedicalSpecialist;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import persistance.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * Клас DAO для роботи із сутностями типу Medicalspecialist
 * @author Anton Netudykhata and Max Berezynskyi
14.03.2015.
 */
public class MedicalSpecialistDAO {

    /**
     * Додає до БД обьект класу Medicalspecialist
     * @param medspec спеціаліст,якого треба додати до БД
     */
    public void addToDB(MedicalSpecialist medspec) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(medspec);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Видаляє із БД спеціаліста із заданим id
     * @param id id спеціаліста,якого треба видалити із БД
     */
    public void deleteFromDB(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            System.out.println("1");
            session.beginTransaction();
            System.out.println("2");
            MedicalSpecialist itemDelete = (MedicalSpecialist) session.get(MedicalSpecialist.class, id);
            System.out.println("3");
            session.delete(itemDelete);

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Повертає обєкт класу Medicalspecialist по заданому id
     * @param id id спеціаліста, який повинен повернути метод
     * @return обєкт класу Medicalspecialist
     */
    public MedicalSpecialist getMedicalSpecialistById(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        MedicalSpecialist specialist = null;

        Session session = factory.openSession();
        Transaction ta = null;
        try {
            ta = session.beginTransaction();
            Criteria cr = session.createCriteria(MedicalSpecialist.class);
            Criterion idCr = Restrictions.like("id", id);
            cr.add(idCr);
            specialist = (MedicalSpecialist) cr.uniqueResult();
//            ta.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return specialist;
    }

    /**
     * Повертає список обєктів класу Medicalspecialist
     * @return список обєктів класу Medicalspecialist
     */
    public List<MedicalSpecialist> getSpecialists() {

        List<MedicalSpecialist> result = null;
//Создаем сессию, она нужна для использования транзакций
//Грубо говоря, транзакция - это как точка восстановления, если не прошла до конца, то все изменения откатываются.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
//Criteria используется  для запроса с целью получения данных из БД
//Такой формулировки, думаю, Вам пока хватит
//Параметром мы передаем тот класс-сущность, который используем. Если бы данные получали из таблицы Cart то передавать
//надо было бы Cart.class
            Criteria criteria = session.createCriteria(MedicalSpecialist.class);

            result = (List<MedicalSpecialist>) criteria.list();

            session.getTransaction().commit();
        } catch (Exception e) {
//Обработку исключений обязательно пишите. Но это я оставлю Вам на самостоятельную работу.
            e.printStackTrace();
        }finally {
            if (session != null) session.close();
        }
        return result;
    }
}


