package app.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DolphinDAO {

    private final EntityManagerFactory emf;

    public DolphinDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

}
