package dao;

import entity.ConscriptCard;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import persistance.HibernateUtil;

import java.util.List;

/**
 *  Клас DAO для роботи із сутностями типу ConscriptCard
 * @author Anton Netudykhata and Max Berezynskyi
 *         16.03.2015.
 */
public class ConscriptCardDAO {

    /**
     * Додає до бази данних об'єкт
     * @param card об'єкт, який заноситься до БД
     */
    public void addToDB(ConscriptCard card) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(card);
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
     * Видаляє із БД по значенню id
     * @param id значення id об'єкта, котрий треба видалити
     */
    public void deleteFromDB(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            ConscriptCard itemDelete = (ConscriptCard) session.get(ConscriptCard.class, id);
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
     * Повертає картку призовника, по заданому id
     * @param id id картки призовника,яку треба повернути
     * @return картка призовника із заданим id
     */
    public ConscriptCard getConscriptCardById(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        ConscriptCard unit = null;

        Session session = factory.openSession();
        Transaction ta = null;
        try {
            ta = session.beginTransaction();
            Criteria cr = session.createCriteria(ConscriptCard.class);
            Criterion idCr = Restrictions.like("id", id);
            cr.add(idCr);
            unit = (ConscriptCard) cr.uniqueResult();
//            ta.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
//            session.close();
        }
        return unit;
    }

    /**
     * Повертає список карток призовників
     * @return список карток призовників
     */
    public List<ConscriptCard> getCards() {

        List<ConscriptCard> result = null;
//Создаем сессию, она нужна для использования транзакций
//Грубо говоря, транзакция - это как точка восстановления, если не прошла до конца, то все изменения откатываются.
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
//Criteria используется  для запроса с целью получения данных из БД
//Такой формулировки, думаю, Вам пока хватит
//Параметром мы передаем тот класс-сущность, который используем. Если бы данные получали из таблицы Cart то передавать
//надо было бы Cart.class
            Criteria criteria = session.createCriteria(ConscriptCard.class);

            result = (List<ConscriptCard>) criteria.list();

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

