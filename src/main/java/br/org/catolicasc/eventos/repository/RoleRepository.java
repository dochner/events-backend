package br.org.catolicasc.eventos.repository;

import br.org.catolicasc.eventos.model.ERole;
import br.org.catolicasc.eventos.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}