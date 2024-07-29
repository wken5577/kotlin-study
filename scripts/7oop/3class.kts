/**
 *  가장 작은 클래스
 * 이름 앞에 class 키워드를 적으면 된다.
 * property가 하나도 없어서 의미가 없다
 */
// class Car

/**
 * 클래스에 yearOfMake라는 속성을 정의했다.
 * 우리는 생성자가 정수형 파라미터를 받도록 정의했다.
 * 코틀린 컴파일러는 생성자를 작성하고, 필드를 정의하고, getter를 추가해준다.
 */

class Car(val yearOfMake : Int)


// 인스턴스 생성하기
val car = Car(2019)
// car.yearOfMake -> 실제로는 car.getYearOfMake()를 호출한 것임
println(car.yearOfMake) //2019

// 지역변수로 val을 사용했기 때문에 속성은 변경하려고하면 에러가 뜰 것이다.
car.yearOfMake = 2022 // error: val cannot be reassigned