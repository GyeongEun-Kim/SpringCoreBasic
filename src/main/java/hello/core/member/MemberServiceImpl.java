package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.class 와 같이 동작 // 의존관계 주입해줌
    public MemberServiceImpl(MemberRepository memberRepository) { //생성자
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

    public MemberRepository getMemberRepository () {
        return memberRepository;
    }
}
