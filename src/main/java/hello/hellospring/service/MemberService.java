package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.hellospring.entity.Member;
import hello.hellospring.repository.MemberRepository;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public class MemberService{
    private final MemberRepository memberRepository;
    
    // Dependency Injection(DI, 의존성 주입)
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    

    //회원 가입.
    public Long join(Member member){
        //회원 이름 중복 방지.
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
        
        memberRepository.save(member);
        return member.getId();
    }
    
    //전체 회원 조회.
    public List<Member> findMembers() {
         return memberRepository.findAll();
    }
    
    
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
        
    }
}