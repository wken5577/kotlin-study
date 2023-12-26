/*
 * 코틀린에서 델리게이션을 사용하면 델리게이션을 사용하는 클래스는 델리게이트 객체에 할당될 수 있다.
 *
 * val coder : JavaProgrammer = doe -> error발생
 * 하지만 아래는 가능하다 (Manager가 Worker를 구현하고 있기 때문에)
 * val employee : Worker = doe
 *
 * 델리게이션의 목적은 Manager가 Worker를 이용하는 것이다. 하지만 코틀린의 델리게이션 부작용으로
 * Manager는 Worker로 취급된다.
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
/*
 * 델리게이션 객체를 var로 선언하여 뮤터블로 다룬다면 다음과 같은 문제가 생길 수 있다
 * Manager 객체에는 staff에 대한 참조, 그리고 델리게이션을 위한 참조 2가지가 있다.
 * 즉 클래스 안에 백킹 필드로서 존재하는 참조, 또 하나는 델리게이션의 목적으로 존재하는 참조이다.
 * 우리가 다음과 같이 staff를 변경하는 것은 필드만 변경하는 것이지 델리게이션의 참조를 변경하는 것은 아니다.
 *
 * 또 다른 문제도 있는데 staff를 CSharpProgrammer의 인스턴스로 변경했을 때 JavaProgrammer에 접근할 수 없게 된다.
 * 하지만 델리게이션이 JavaProgrammer에 대한 참조를 가지고 있기 때문에 가비지 콜렉터가 JavaProgrammer를 수거하지 않는다.
 * 그래서 속성이 변경되더라도 델리게이션의 생명주기가 객체의 생명 주기와 동일해진다.
 */

class Manager(var staff : Worker) : Worker by staff
val doe = Manager(JavaProgrammer())
println("staff is ${doe.staff.javaClass.simpleName}")
doe.work() // worker is coding in Java
println("change staff")
doe.staff = CSharpProgrammer()
println("staff is ${doe.staff.javaClass.simpleName}") //staff는 CSharpProgrammer로 변경되었지만 델리게이션의 참조는 여전히 JavaProgrammer이다.
doe.work() // worker is coding in Java -> C#이 나올거로 예상했을 수도 있다.