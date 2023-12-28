// car.yearOfMake를 호출하면 실제로는 car.getYearOfMake를 호출한 것이다.
// kotlin컴파일러로 컴파일하여 실험해서 확인해보자

class Car (val yearOfMake : Int, var color : String)