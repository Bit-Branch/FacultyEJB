package bean;

import entity.Faculty;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class FacultyBean {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    private EntityManager em = emf.createEntityManager();


    public Faculty add(Faculty faculty)
    {
        em.getTransaction().begin();
        em.merge(faculty);
        em.getTransaction().commit();
        return faculty;
    }

    public Faculty get(int id)
    {
        return em.find(Faculty.class, id);
    }

    public void update(Faculty faculty)
    {
        add(faculty);
    }

    public void delete(int id)
    {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public List<Faculty> getAll()
    {
        TypedQuery<Faculty> namedQuery = em.createQuery("Select e from Faculty e", Faculty.class);
        return namedQuery.getResultList();
    }

}