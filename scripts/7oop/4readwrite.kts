// class 속성을 뮤터블로 작성할 수도 있다.

class Car(val yearOfMake : Int, var color : String)

val car = Car(2019, "Red")
car.color = "Green"
println(car.color) //Green