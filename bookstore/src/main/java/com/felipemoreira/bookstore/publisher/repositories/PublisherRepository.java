package com.felipemoreira.bookstore.publisher.repositories;

import com.felipemoreira.bookstore.publisher.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
