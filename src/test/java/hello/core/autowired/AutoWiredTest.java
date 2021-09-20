package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired (required = false)
        public void setNoBean1 (Member NoBean1) {
            System.out.println("NoBean1 = " + NoBean1);
        }

        @Autowired
        public void setNoBean2 (@Nullable Member NoBean2) {
            System.out.println("NoBean2 = " + NoBean2);
        }

        @Autowired
        public void setNoBean1 (Optional<Member> NoBean3) {
            System.out.println("NoBean3 = " + NoBean3);
        }
    }
}
