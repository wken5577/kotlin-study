/*
 * 클래스는 여러 개의 인터페이스를 델리게이션할 수 있다.
 * 만약 인터페이스 사이에서 메소드 충돌이 있다면 델리게이션 이용 클래스에서 해당 메소드를 구현해야 한다.
 */

interface Worker{
    fun work()
    fun takeVacation()
    fun fileTimeSheet() = println("File time sheet")
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

interface Assistant{
    fun doChores()
    fun fileTimeSheet() = println("No escape from that")
}

class DepartmentAssistant : Assistant{
    override fun doChores() = println("routine work")
}

/**
 * Worker, Assistant 인터페이스 모두 같은 시그니처의 fileTimeSheet 함수를 가지고 있다.
 * 만약 Manager 클래스에서 fileTimeSheet 메서드를 오버라이드하지 않았다면 메서드 충돌로 인한 컴파일 오류가 났을 것이다.
 */
class Manager(val staff : Worker, val assistant : Assistant) : Worker by staff, Assistant by assistant{
    override fun takeVacation() {
        TODO("Not yet implemented")
    }
    override fun fileTimeSheet() {
        print("manually file time sheet ")
        assistant.fileTimeSheet()
    }
}

val doe = Manager(CSharpProgrammer(), DepartmentAssistant())
doe.work()
doe.fileTimeSheet()
doe.doChores()

