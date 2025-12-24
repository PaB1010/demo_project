package com.onedu.demo.member.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1126417030L;

    public static final QMember member = new QMember("member1");

    public final com.onedu.demo.global.entities.QBaseEntity _super = new com.onedu.demo.global.entities.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath addressSub = createString("addressSub");

    public final ListPath<Authorities, QAuthorities> authorities = this.<Authorities, QAuthorities>createList("authorities", Authorities.class, QAuthorities.class, PathInits.DIRECT2);

    public final StringPath bio = createString("bio");

    public final DatePath<java.time.LocalDate> birthDt = createDate("birthDt", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> credentialChangedAt = createDateTime("credentialChangedAt", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.onedu.demo.member.contants.Gender> gender = createEnum("gender", com.onedu.demo.member.contants.Gender.class);

    public final EnumPath<com.onedu.demo.member.contants.MemberCondition> memberCondition = createEnum("memberCondition", com.onedu.demo.member.contants.MemberCondition.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath zipCode = createString("zipCode");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

