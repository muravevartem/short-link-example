package com.example.shortlink.repository;

import com.example.shortlink.entity.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LinkRepository extends CrudRepository<Link, Integer> {
    Optional<Link> findByHash(@Param("hash") String hash);
}
