package joblob.springrest.springrestdemo.repository;

import joblob.springrest.springrestdemo.model.User;
import org.springframework.dao.DataAccessException;

public interface UserRepository {

     void save (User user) throws DataAccessException;
}
