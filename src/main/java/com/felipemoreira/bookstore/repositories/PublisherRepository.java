package com.felipemoreira.bookstore.repositories;

import com.felipemoreira.bookstore.entities.Publisher;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Optional<Publisher> findByNameOrCode(String name, String code);
}
