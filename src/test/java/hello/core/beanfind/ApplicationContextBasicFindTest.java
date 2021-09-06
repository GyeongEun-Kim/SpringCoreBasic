package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;

import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    //ctrl + e --> 이전코드로 바로 이동할 수 있음
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() {
        MemberService memberService =ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService.getClass() = " + memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    public void findBeanByType() {
        MemberService memberService =ac.getBean( MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체타입으로 빈 조회")
    public void findBeanByName2() {
        MemberServiceImpl memberService =ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }//구체타입으로 조회할수도 있지만 좋지는 않음 (구현에 의존하게됨)

    @Test
    @DisplayName("빈 이름으로 조회X")
    public void findBeanByNameX() {
        MemberService memberService =ac.getBean("xxxx",MemberService.class);

    }
}
