/*
 * 코틀린 컴파일러는 델리게이션에 사용되는 클래스마다 델리게이션 메소드를 위한 랩퍼를 만든다.
 * 사용하는 클래스와 델리게이션 클래스에 동일한 이름과 시그니처가 있는 메소드가 있다면 어떻게 될까?
 * 코틀린은 이 문제를 해결했다. 결과적으로 선택이 가능하고 델리게이션 클래스의 모든 메소드를 일일이 위임할 필요가 없다
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
 * 델리게이션 클래스(Worker)가 인터페이스의 메소드를 구현하지 않은 경우 델리게이션을 이용하는 클래스(Manager)에서 구현해야 한다.
 * 델리게이션 클래스가 인터페이스 메소드를 이미 구현한 시점에 델리게이션을 이용하는 클래스에서 다시 메소드를 구현하려고 하는 경우 override 키워드를 사용해야 한다.
 * 이 경우 해당 메소드에 우선순위가 생기고 컴파일러는 랩퍼 메소드를 생성하지 않는다
 * 아래에 코트에서 코틀린 컴파일러는 work 메소드의 랩퍼만 생성할 것이다.
 */
class Manager(val staff : Worker) : Worker by staff{
    fun meeting() {
        println("Manager is having a meeting with ${staff.javaClass.simpleName}")
    }

    override fun takeVacation() {
        println("Manager is on vacation")
    }
}

val doe = Manager(CSharpProgrammer())
doe.work()
doe.takeVacation()