package dive.tech.projeto.exercicios.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnectionFactory {

    private EntityManagerFactory factory;

    public JpaConnectionFactory() {
        this.factory = Persistence.createEntityManagerFactory("m2semana6");
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
