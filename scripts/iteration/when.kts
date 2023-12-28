// when을 사용하면 if-else를 대체할 수 있다.

fun isAlive(alive : Boolean, numberOfLiveNeighbours : Int) : Boolean {
    return when {
        numberOfLiveNeighbours < 2 -> false
        numberOfLiveNeighbours > 3 -> false
        numberOfLiveNeighbours == 3 -> true
        else -> alive && numberOfLiveNeighbours == 2
    }
}