package nuvemdesoftware.ceramicpro.repository;


import java.util.Optional;

import nuvemdesoftware.ceramicpro.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}