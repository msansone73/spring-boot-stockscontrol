package br.com.msansone.apistockscontrol.repository;

import br.com.msansone.apistockscontrol.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByLoginId(Long loginId);

}
