package ta.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ta.db.HibernateUtils;
import ta.model.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectDaoImp implements Projectdao {

    @Override
    public void save(Project p) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Project p) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Project project = session.get(Project.class, p.getId());
        project.setName(p.getName());
        session.update(project);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Project p) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Project project = session.get(Project.class, p.getId());
        session.delete(project);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> list() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Project> personList = session.createQuery("FROM Project", Project.class).list();
        session.close();
        return personList;
    }
}
