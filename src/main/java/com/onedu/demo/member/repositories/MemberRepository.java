package com.onedu.demo.member.repositories;

import com.onedu.demo.member.entities.Member;
import com.onedu.demo.member.entities.QMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    @EntityGraph(attributePaths = "authorities")
    Optional<Member> findByEmail(String email);

    Optional<Member> findByNameAndPhoneNumber(String name, String Mobile);

    Optional<Member> findByPhoneNumber(String mobile);

    default boolean phoneNumberExists(String phoneNumber) {

        QMember member = QMember.member;

        return exists(member.phoneNumber.eq(phoneNumber));
    }

    default boolean exists(String email) {

        QMember member = QMember.member;

        return exists(member.email.eq(email));
    }
}
