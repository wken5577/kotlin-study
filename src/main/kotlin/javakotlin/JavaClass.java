package javakotlin;

import java.util.List;
import java.util.stream.Collectors;

public class JavaClass {

    // kotlin이 java와 잘 동작하는지 확인
    public int getZero() {
        return 0;
    }
    public List<String> convertToUpper(List<String> names) {
        return names.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    // kotlin의 키워드랑 java코드랑 conflict날 때 어떻게 해결할지
    public void suspend(){
        System.out.println("suspending .....");
    }
    public String when(){
        return "Now!";
    }
}
