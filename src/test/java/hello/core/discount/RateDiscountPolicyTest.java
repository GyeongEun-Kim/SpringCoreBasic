package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("VIP는 10프로 할인이 되어야한다")
    void vip_o() {
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount==1000);
    }

    @Test
    @DisplayName("vip가 아니면 10프로할인이 적용되지 않아야한다")
    void vip_x() {
        Member member2 = new Member (2L, "memberBASIC",Grade.BASIC);
        int discount = discountPolicy.discount(member2,10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }
}