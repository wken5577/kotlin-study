import java.lang.RuntimeException

/*
* kotlin에서는 class기본이 final이다.
* 따라서 상속을 하려면 open을 붙여야 한다. 또한 자식 클래스에서는 구현 메소드에 override를 붙여야 한다.
* 속성도 오버라이드 할 수 있는데 val로 정의된 속성은 val, var을 모두 사용하여 오버라이드 할 수 있다.
* 하지만 var로 정의된 속성은 val로 오버라이드 할 수 없다.
* kotlin은 java와 다르게 implements와 extends를 구분하지 않는다.
*/

/*
 * Vehicle classs toString을 오버라이드 하면서 final을 붙여서 자식 클래스에서 오버라이드 할 수 없게 한다.
 * year 속성은 오버리이드 불가, color, km는 open 키워드를 활용하여 자식이 오버라이드 가능하도록 함
 */
open class Vehicle(val year : Int, open var color : String){
    open val km = 0
    final override fun toString() : String{
        return "Vehicle(year=$year, color=$color, km=$km)"
    }
    fun repaint(newColor : String){
        color = newColor
    }
}

/*
 * Vehicle을 상속받는 Car 클래스
 * km 속성을 오버라이드하고 setter에서 0보다 큰 수만을 받도록 수정
 * drive메소드는 open으로 명시되지 않았기 때문에 final이 된다
 */
open class Car (year : Int, color : String) : Vehicle(year, color){
    override var km : Int = 0
        set(value) {
            if (value < 1)
                throw RuntimeException("km must be greater than 0")
            field = value
        }
    fun drive (distance : Int){
        km += distance
    }

}

val car = Car(2019, "red")
println(car) // Vehicle(year=2019, color=red, km=0)
println(car.color) // red
car.drive(10)
println(car) // Vehicle(year=2019, color=red, km=10)

/*
 * Car를 상속받는 FamilyCar 클래스
 * Car의 km속성과는 다르게 FamilyCar 클래스는 color속성의 값을 저장하지 않는다.
 * 대신 getter, setter를 활용하여 부모 클래스의 속성을 사용한다.
 * Car class가 color를 오버라이드 하지 않았기 때문에 color는 Vehicle class의 color를 사용한다.
 * color는 Vehicle안에 저장되어 있지만 FamilyCar의 인스턴스가 속성의 값을 검증하고 color가 비어있는 것을 허용하지 않는다.
 * color의 getter와 setter만 오버라이드한 느낌이다
 */
class FamilyCar(year : Int, color : String) : Car(year, color) {
    override var color : String
        get() = super.color
        set(value) {
            if (value.isEmpty())
                throw RuntimeException("color must not be empty")
            super.color = value
        }

}

val familyCar = FamilyCar(2019, "blue")
println(familyCar)
