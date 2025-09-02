package app.daos;

import app.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DolphinDAO implements IDAO<Person, Integer> {

    private final EntityManagerFactory emf;

    public DolphinDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public Person create(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new RuntimeException("Error creating a new person",ex);
        }
        return person;
    }

    @Override
    public Person getById(Integer id) {
        return null;
    }

    @Override
    public Person update(Person person) {
        try  (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            person.getFees().forEach(fee -> em.merge(fee));
            person.getNotes().forEach(note -> em.merge(note));
            person = em.merge(person);
            em.getTransaction().commit();
            return  person;
        } catch (Exception ex) {
            throw new RuntimeException("Error updating a new person",ex);
        }

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Person> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
            return query.getResultList();
        }catch (Exception ex){
            throw new RuntimeException("Error getting all persons",ex);
        }
    }
}
