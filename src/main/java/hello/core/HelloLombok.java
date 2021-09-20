package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("김경은");
        helloLombok.setAge(24);

        System.out.println("name = " + helloLombok.getName());
        System.out.println("age = " + helloLombok.getAge());
    }
}
