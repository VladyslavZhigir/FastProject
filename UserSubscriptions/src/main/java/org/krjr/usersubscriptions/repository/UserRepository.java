package org.krjr.usersubscriptions.repository;

import org.krjr.usersubscriptions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
