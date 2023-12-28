fun sort (numbers : List<Int>) : List<Int> =
    if (numbers.isEmpty())
        numbers
    else {
        val pivot = numbers.first()
        val tail = numbers.drop(1)
        val lessOrEqual = tail.filter { it <= pivot }
        val larger = tail.filter {  it > pivot }
        sort(lessOrEqual) + pivot + sort(larger)
    }

println(sort(listOf(5, 3, 1, 2, 4))) // [1, 2, 3, 4, 5]
