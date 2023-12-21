// kotlin은 문자열 탬플릿을 사용할 수 있다
// 문자열 안에서 $를 사용하면 그 뒤에 오는 변수는 할당된 값으로 치환된다.
// 역슬래시를 사용하면 $를 문자 그대로 사용할 수 있다.
// $뒤에 변수 이름이나 표현식이 없다면 $는 문자로 취급된다.

val price = 12.25
val taxRate = 0.08
val output = "The amount $price after tax comes to $${price * (1 + taxRate)}"
val disclaimer = "The amount is in US$, that's right in \$only"
println(output)
println(disclaimer)

// 결과
//The amount 12.25 after tax comes to $13.23
//The amount is in US$, that's right in $only