package bookstore.personalblog.repository;

import bookstore.personalblog.model.modelBlog;
import bookstore.personalblog.model.modelUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class userRepository {
    @PersistenceContext
    private EntityManager em;

    public List<modelUser> getUsers() {
        return em.createQuery("select u from modelUser u", modelUser.class).getResultList();
    }

    public modelUser getUser(int id) {
        return em.find(modelUser.class, id);
    }

    public  void addUser(modelUser user) {
        if(user!=null)
            em.persist(user);
    }

    public void findByEmail(String email) {
         em.find(modelUser.class, email);
    }







}
