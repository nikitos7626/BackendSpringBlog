package bookstore.personalblog.repository;

import bookstore.personalblog.model.modelBlog;
import bookstore.personalblog.model.modelUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class blogRepository {
    @PersistenceContext
    private EntityManager em;

    public List<modelBlog> getBlog()  //Получение всех статей
    {
        return  em.createQuery("select b from modelBlog b",modelBlog.class).getResultList();
    }

    public modelBlog getBlogById(int id) //получение статьи по id
    {
        return em.find(modelBlog.class,id);
    }

    public modelBlog getBlog(String title){ //Получение статьи по названию
        return em.find(modelBlog.class,title);
    }

    public void deleteBlog(int id)//Удаление статьи
    {
        modelBlog blog= getBlogById(id);
        em.remove(blog);
    }

    public void createBlog(modelBlog blog)//Создание новой статьи
    {
        if(blog!=null) {
            em.persist(blog);
        }

    }

    public modelBlog updateBlog(modelBlog blog){//Изменение статьи
         return  em.merge(blog);
    }

    public  List<modelBlog> findByUser(modelUser user){//Поиск статей по их  автору
        return user.getBlogs();
    }
}
