/*
 * java 방식의 delegation (위임)
 * Manager class가 Worker 를 구현한 class에게 일을 위임한다.
 *
 * 이 디자인에는 문제가 있다.
 * Manager class 안에 work와 takeVacation 함수를 구현했지만 둘 다 그냥 worker에게 위임만 한다.
 * Worker에 더 많은 메소드가 있다고 생각하면 Manager에는 더 많은 메소드를 구현해야 한다.
 * 또한 oop의 개방 폐쇄 원칙을 위반한다.
 * 클래스를 확장하기 위해서 Manager class를 수정해야 하기 때문이다.
 * 하지만 Manager은 JavaProgrammer, CSharpProgrammer가 아니다. 따라서 상속을 이용한 모델링도 LSP를 위반한다.
 */

interface Worker{
    fun work()
    fun takeVacation()
}

class JavaProgrammer(val name: String) : Worker {
    override fun work() {
        println("$name is coding in Java")
    }

    override fun takeVacation() {
        println("$name is on vacation")
    }
}

class CSharpProgrammer(val name: String) : Worker {
    override fun work() {
        println("$name is coding in C#")
    }

    override fun takeVacation() {
        println("$name is on vacation")
    }
}

class Manager(val worker: Worker) {
    fun work () = worker.work()
    fun takeVacation() = worker.takeVacation()
}