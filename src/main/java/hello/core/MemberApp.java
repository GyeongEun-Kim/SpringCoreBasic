package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //컨테이너 생성 !!!! 스프링빈 등록
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); //이름, 반환타입



        Member member1 =new Member(1L,"member1", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());

    }
}
