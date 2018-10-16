package joblob.springrest.springrestdemo.service;

import joblob.springrest.springrestdemo.model.Role;
import joblob.springrest.springrestdemo.model.User;
import joblob.springrest.springrestdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User user) throws Exception{

        if(user.getRoles() == null || user.getRoles().isEmpty()){
            throw new Exception("User has no role !!!!");
        }

        for (Role role : user.getRoles()){
            if(!role.getName().startsWith("ROLE_")){
                role.setName("ROLE_"+role.getName());
            }

            if(role.getUser() == null){
                role.setUser(user);
            }
        }

        userRepository.save(user);

    }

}
