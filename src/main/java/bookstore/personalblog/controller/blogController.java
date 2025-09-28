package bookstore.personalblog.controller;

import bookstore.personalblog.model.modelBlog;
import bookstore.personalblog.service.serviceBlog;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs") // теперь все эндпоинты начинаются с /api/blogs
public class blogController {

    private final serviceBlog serviceBlog;

    public blogController(serviceBlog serviceBlog) {
        this.serviceBlog = serviceBlog;
    }

    // Получить все посты
    @GetMapping
    public List<modelBlog> getAllBlogs() {
        return serviceBlog.getBlog();
    }

    // Получить пост по id
    @GetMapping("/{id}")
    public modelBlog getBlogById(@PathVariable int id) {
        return serviceBlog.getBlogById(id);
    }

    // Получить пост по title (лучше query параметр, чем path)
    @GetMapping("/search")
    public modelBlog getBlogByTitle(@RequestParam String title) {
        return serviceBlog.getBlogByTitle(title);
    }

    // Создать пост
    @PostMapping
    public modelBlog createBlog(@RequestBody modelBlog blog) {
        return serviceBlog.addBlog(blog);
    }

    // Обновить пост
    @PutMapping("/{id}")
    public modelBlog updateBlog(@PathVariable int id, @RequestBody modelBlog blog) {
        blog.setId(id);
        return serviceBlog.updateBlog(blog);
    }

    // Удалить пост
    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable int id) {
        serviceBlog.deleteBlog(id);
    }
}
