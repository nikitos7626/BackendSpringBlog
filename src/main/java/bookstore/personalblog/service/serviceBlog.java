package bookstore.personalblog.service;


import bookstore.personalblog.model.modelBlog;
import bookstore.personalblog.model.modelUser;
import bookstore.personalblog.repository.blogRepository;
import jakarta.servlet.http.PushBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceBlog {
    private final blogRepository blogRepository;

    public  serviceBlog(blogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<modelBlog>  getBlog()
    {
        return blogRepository.getBlog();
    }

    public modelBlog getBlogById(int id)
    {
        return blogRepository.getBlogById(id);
    }

    public modelBlog getBlogByTitle(String title)
    {
        return blogRepository.getBlog(title);
    }

    public void deleteBlog(int id)
    {
        blogRepository.deleteBlog(id);
    }
    public modelBlog updateBlog(modelBlog blog)
    {
        return blogRepository.updateBlog(blog);
    }

    public modelBlog addBlog(modelBlog blog)
    {
        blogRepository.createBlog(blog);
        return blog;
    }

    public List<modelBlog> findByUser(modelUser user){
       return blogRepository.findByUser(user);
    }



}
