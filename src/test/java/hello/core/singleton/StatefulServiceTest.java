package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread A : A사용자 10000 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //Thread B: B사용자 20000 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: A사용자 주문금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
//        //ThreadB: B사용자 주문금액 조회
//        statefulService2.getPrice();
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}