package com.demoju.hellospring;

import com.demoju.hellospring.repository.JdbcTemplateMemberRepository;
import com.demoju.hellospring.repository.JpaMemberRepository;
import com.demoju.hellospring.repository.MemberRepository;
import com.demoju.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean MemberRepository memberRepository() {
        //return new MemoryMemberRepositoryImpl();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
