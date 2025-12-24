package com.onedu.demo.member.repositories;

import com.onedu.demo.member.entities.Authorities;
import com.onedu.demo.member.entities.AuthoritiesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesId>, QuerydslPredicateExecutor<Authorities> {
}
