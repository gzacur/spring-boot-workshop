package py.com.pronet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.pronet.entities.User;
import py.com.pronet.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    EntityManager em;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override

    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userRepo.findById(id);
    }

    public List<User> userByName(String name) {

        Query q = em.createNativeQuery("Select * from user where nombre like ?");
        q.setParameter(1, "%" + name + "%");

        return q.getResultList();


    }

}
