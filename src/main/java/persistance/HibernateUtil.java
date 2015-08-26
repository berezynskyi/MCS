package persistance;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Клас для взаємодії з конфіг файлами і створення обєкту SessionFactory,котрий відповідає за створення hibernate-сесії
 * @author Anton Netudykhata and Max Berezynskyi
14.03.2015.
 */
public class HibernateUtil {

    /**
     * обєкт SessionFactory,котрий відповідає за створення hibernate-сесії
     */
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    /**
     * Створює нову сесію із hibernate.cfg.xml
     * @return сесію із hibernate.cfg.xml
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Создает сессию с hibernate_mapping.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Повертає обєкт SessionFactory
     * @return обєкт SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    /**
     * Очищує кеш і закриває зєднання із БД
     */
    public static void shutdown() {
        // Чистит кеш и закрывает соединение с БД
        getSessionFactory().close();
    }

}
