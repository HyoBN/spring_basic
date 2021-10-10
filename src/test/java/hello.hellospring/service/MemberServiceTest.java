package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest{
    
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    
    @Test 
    void join(){
        //given 주어진 상황에서,
        Member member = new Member();
        member.setName("spring");
        
        //when 해당 메소드를 실행했을 때,
        Long saveId = memberService.join(member);
        
        //then 이러한 결과가 나와야한다.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
        
    }
    
    @Test
    public void check() {
        
        //given
        Member member1 = new Member();
        member1.setName("spring");
        
        Member member2 = new Member();
        member2.setName("spring");
        
        memberService.join(member1);
        
        //예외 처리 방법 1)
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        
        //예외 처리 방법 2)
        /*try{
            memberService.join(member2);
            fail(); 
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
        
    }
    
    @Test
    void findMembers(){
        
    }
    
    @Test
    void findOne(){
        
    }
}