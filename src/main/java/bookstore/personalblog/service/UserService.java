package bookstore.personalblog.service;

import bookstore.personalblog.jwt.JwtService;
import bookstore.personalblog.jwt.genToken;
import bookstore.personalblog.model.modelUser;
import bookstore.personalblog.model.role;
import bookstore.personalblog.repository.userRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private  final userRepository userRepository;
    public  UserService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<modelUser> getUsers() {
        return userRepository.getUsers();
    }

    public modelUser getUser(int id)
    {
        return userRepository.getUser(id);
    }


    public void addUser(modelUser user){
        userRepository.addUser(user);
    }

    public void findByEmail(String email)
    {
        userRepository.findByEmail(email);
    }

}
