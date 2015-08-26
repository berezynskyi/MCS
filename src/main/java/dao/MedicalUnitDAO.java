package dao;


import java.util.List;
import entity.MedicalUnit;
import entity.MedicalSpecialist;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import persistance.HibernateUtil;

/**
 * Клас DAO для роботи із сутностями типу MedicalUnit
 * @author Anton Netudykhata and Max Berezynskyi
 * 14.03.2015.
 */
public class MedicalUnitDAO {

    /**
     * Заносить обєкт класу MedicalUnit до БД
     * @param unit обєкт,який необхідно занести до БД
     */
    public void addToDB(MedicalUnit unit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(unit);
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
     * Видаляє із БД обєкт по його заданому id
     * @param id id обєкта,який необхідно видалити
     */
    public void deleteFromDB(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            MedicalUnit itemDelete = (MedicalUnit) session.get(MedicalUnit.class, id);
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
     * Повертає обєкт класу, по заданому id
     * @param id id медичної карти, яку повинен повернути метод
     * @return обєкт класу MedicalUnit
     */
    public MedicalUnit getMedicalUnitById(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        MedicalUnit unit = null;

        Session session = factory.openSession();
        Transaction ta = null;
        try {
            ta = session.beginTransaction();
            Criteria cr = session.createCriteria(MedicalSpecialist.class);
            Criterion idCr = Restrictions.like("id", id);
            cr.add(idCr);
            unit = (MedicalUnit) cr.uniqueResult();
//            ta.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return unit;
    }

    /**
     * Повертає список обєктів класу MedicalUnit
     * @return список обєктів класу MedicalUnit
     */
    public List<MedicalUnit> getUnits() {

        List<MedicalUnit> result = null;
//Создаем сессию, она нужна для использования транзакций
//Грубо говоря, транзакция - это как точка восстановления, если не прошла до конца, то все изменения откатываются.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
//Criteria используется  для запроса с целью получения данных из БД
//Такой формулировки, думаю, Вам пока хватит
//Параметром мы передаем тот класс-сущность, который используем. Если бы данные получали из таблицы Cart то передавать
//надо было бы Cart.class
            Criteria criteria = session.createCriteria(MedicalUnit.class);

            result = (List<MedicalUnit>) criteria.list();

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