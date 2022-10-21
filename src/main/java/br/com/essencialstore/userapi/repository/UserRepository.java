package br.com.essencialstore.userapi.repository;

import br.com.essencialstore.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);

    List<User> queryByNameLike(String name);
}
