package br.com.msansone.apistockscontrol.repository;

import br.com.msansone.apistockscontrol.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {
    List<Login> findByEmailAndPassword(String email, String password);
}
