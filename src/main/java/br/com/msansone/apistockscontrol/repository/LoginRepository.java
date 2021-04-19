package br.com.msansone.apistockscontrol.repository;

import br.com.msansone.apistockscontrol.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByLoginAndPassword(String login, String password);
}
