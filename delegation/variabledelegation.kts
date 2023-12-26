/*
 * 변수 델리게이션을 사용해보자
 */

import stringfilter.PoliteString

var comment : String by PoliteString("Some nice message")
println(comment)
comment = "This is a stupid message"
println(comment)
println("comment length = ${comment.length}")

var title : String by mutableMapOf<String, Any?>()
title = "My Great Post"
title = "My Awesome Post"
println(title)