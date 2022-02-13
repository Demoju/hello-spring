package com.demoju.hellospring;

import com.demoju.hellospring.repository.MemberRepository;
import com.demoju.hellospring.repository.MemoryMemberRepositoryImpl;
import com.demoju.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean MemberRepository memberRepository() {
        return new MemoryMemberRepositoryImpl();
    }
}
