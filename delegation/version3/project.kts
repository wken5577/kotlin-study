/*
 * version2에서 발생한 Manager class의 문제점을 해결해보자.
 * 인스턴스를 생성하면서 델리게이션을 지정하지 않고 생성자에게 델리게이션 파라미터를 전달함으로써 쉽게 해결 가능하다.
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

class Manager(val staff : Worker) : Worker by staff{
    fun meeting() {
        println("Manager is having a meeting with ${staff.javaClass.simpleName}")
    }
}

val doe = Manager(CSharpProgrammer())
val roe = Manager(JavaProgrammer())

doe.work()
doe.meeting()
doe.takeVacation()

roe.work()
roe.meeting()