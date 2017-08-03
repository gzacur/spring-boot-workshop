package py.com.pronet.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.pronet.entities.User;
import py.com.pronet.repository.UserRepository;

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
	public List<User> userByName(String name) {		
		
		Query q = em.createNativeQuery("Select * from user where nombre like ?");
		q.setParameter(1, "%"+name+"%");
		
		return q.getResultList();
		
	}
	
}
