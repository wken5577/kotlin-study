/*
 * version1에서 상속과 Java방식의 위임의 문제점을 확인했다.
 * kotlin에서는 이를 해결하기 위해 by 키워드를 제공한다.
 */

interface Worker{
    fun work()
    fun takeVacation()
}

class JavaProgrammer() : Worker {
    override fun work() {
        println("worker is coding in Java")
    }

    override fun takeVacation() {
        println("worker is on vacation")
    }
}

class CSharpProgrammer() : Worker {
    override fun work() {
        println("worker is coding in C#")
    }

    override fun takeVacation() {
        println("worker is on vacation")
    }
}

/*
 * Manager class는 JavaProgrammer를 이용해 Worker 인터페이스를 구현하고 있다.
 * kotlin컴파일러는 Worker에 속하는 메소드를 바이트 코드 수준에서 구현하고 by 키워드 뒤에 나오는 JavaProgramer 클래스의 인스턴스로 호출을 요청한다.
 * by 키워드가 컴파일 시간에 version1에서 구현했던 Manager클래스를 자동으로 구현해준다.
 * 우리가 doe.work()를 호출할 때 우리는 Manager클래스의 work()를 호출하고 해당 work 메소드는 JavaProgrammer의 work()를 호출한다.
 *
 * 이 방식도 문제점이 있는데 Manager 클래스의 인스턴스는 오직 JavaProgrammer 클래스의 인스턴스에만 요청할 수 있다. (즉 다른 종류의 Worker를 구현한 클래스에게는 요청할 수 없다.)
 * 또한 Manager 클래스는 JavaProgrammer 클래스의 인스턴스를 가지고 있지 않다. (즉 JavaProgrammer 클래스의 인스턴스를 직접 참조할 수 없다.)
 */
class Manager () : Worker by JavaProgrammer()

val doe = Manager()
doe.work()