package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //자기자신을 내부에 하나 가지고있음

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {} //생성자 private

    public void logic () {
        System.out.println("싱글톤 객체 로직 출력");
    }
}
