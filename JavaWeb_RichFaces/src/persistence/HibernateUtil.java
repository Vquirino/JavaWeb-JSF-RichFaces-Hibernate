package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	public static final SessionFactory sessionFactory;
	public static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	public HibernateUtil() {
	}

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure(
					"config/hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session getInstance() throws Exception {
		Session session = (Session) threadLocal.get();
		if (session == null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
}
