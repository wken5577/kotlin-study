/**
 * 지금까지 만들었던 클래스는 속성과 인스턴스 메소드만 가지고 있었다.
 * 속성이나 메소드가 클래스 레벨에서 필요하고, 클래스의 특정 인스턴스와는 관련이 없어야 한다면 클래스 안에 만들 수 없다.
 * 대신 그런 속성이나 메소드를 컴패니언 객체로 만든다. (java의 static같은 느낌 정확히 말해서 static과는 다르다)
 * 컴패니언 객체는 클래스 안에 정의한 싱글톤이다. 컴패니언 객체는 인터페이스를 구현할 수도 있고 다른 클래스를 확장할 수도 있다.
 */

/**
 * MachimeOperator 클래스는 클래스 레벨의 속성과 메소드가 필요히다. 컴패니언 객체를 이용해서 구현하도록 하자
 * companion object 키워드를 사용해서 컴패니언 객체를 생성한다.
 * 해당 객체 안에 checkedIn 속성과, minimunBreak 메소드는 어떤 인스턴스에도 속하지 않는 클래스 레벨이 된다.
 * 단 멀티 스레드 환경에서 컴패니언 객체에 뮤터블 속성을 사용하면 스레드 안정성 문제를 발생시킬 수 있다.
 */

class MachineOperator (val name : String){
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--
    companion object{
        var checkedIn = 0
        fun minimumBreak() = "15 minutes every 2 hours"
    }
}
val operator1 = MachineOperator("Mater")
val operator2 = MachineOperator("Francis")
operator1.checkin()
operator2.checkin()
println(MachineOperator.minimumBreak())
println(MachineOperator.checkedIn)

/**
 * 컴패니언 객체 자체의 참조가 필요한 경우도 있다.
 */

val ref = MachineOperator.Companion

/**
 * 클래스에 .Companion을 붙여서 접근할 수 있지만 컴패니언제 적절한 이름을 넣을 수도 있다.
 * companion object MachineOperatorFactory{
 *         var checkedIn = 0
 *         fun minimumBreak() = "15 minutes every 2 hours"
 *     }
 */

/**
 * 다음과 같이 컴패니언 객체를 펙토리로 사용할 수도 있다.
 * MachineOperator class의 생성자를 private로 만들고 컴패니언 객체의 create함수에서 적절한 인스턴스를 만들어서 return하는 것이다.
 * class MachineOperator private constructor(val name : String){
 *      ...
 *      companion objcet{
 *          ...
 *          fun create (name : String) : MachineOperator{
 *              val instance = MachineOperator(name)
 *              instance.checkIn()
 *              return instance
 *          }
 *      }
 * }
 */
