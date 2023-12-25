/**
 * 코틀린의 data class는 특정한 행동, 동작보다는 데이터를 옮기는 데 특화된 클래스다
 * 주 생성자에는 val이나 var를 사용한 속성 정의가 적어도 하나 이상 필요하다.
 * 데이터 클래스에선 val이나 var이 아닌 파라미터는 사용할 수 없다, 또한 필요하다면 {} 안에 속성이나 메소드를 추가할 수 있다.
 *
 * 각각의 데이터 클래스에 코틀린은 자동으로 equals, hashCode, toString을 작성해준다(주 생성자 속성 기반). 여기에 더해 copy() (모든 속성 기반) 메소드도 제공한다.
 * 또한 componentN 함수를 제공해서 주 생성자에 의해서 만들어진 각 속성에 접근할 수 있도록 한다.
 * componentN 메소드의 주된 목적은 destructuring을 위한 것이다. componentN 메소드를 가졌다면 구조분해가 가능하다
 * kotlin의 destructuring은 프로퍼티 순서에 기반하도록 되어있다.
 */


data class Task (val id : Int, val name : String, val completed : Boolean, val assigned : Boolean){
    val data = 1
}

val task1 = Task(1, "Create project", false, true)
println(task1) // Task(id=1, name=Create project, completed=false, assigned=true)
println(task1.component2()) // Create project
println(task1.name) // Create project

//copy 메서드는 네임드 아규먼트를 이용해서 대체 값을 모든 속성에 전달할 수 있다.
val task1Completed = task1.copy(completed = true, assigned = false)
println(task1Completed) //Task(id=1, name=Create project, completed=true, assigned=false)

//task1 destructuring
val (id, _, _, assigned) = task1
println("id = $id, assigned = $assigned")