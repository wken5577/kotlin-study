package apps

import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify

class AirportTest : StringSpec() {
    private val iah = Airport("IAH", "Houston", true)
    private val iad = Airport("IAD", "Washington", false)
    private val ord = Airport("ORD", "Chicago", true)
    override fun beforeTest(testCase: TestCase) {
        mockkObject(Airport)
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }

    init{
        "canary test should pass"{
            true shouldBe true
        }
        "create airport"{
            iah.code shouldBe "IAH"
            iad.name shouldBe "Washington"
            ord.delay shouldBe true
        }

        "sort empty list should return empty list"{
            Airport.sort(listOf()) shouldBe listOf()
        }

        "sort airports should return airports in sorted order of name" {
            Airport.sort(listOf(iah, iad, ord)) shouldBe listOf(ord, iah, iad)
        }

        "sort airports by name" {
            forall(
                row(listOf(), listOf()),
                row(listOf(iah), listOf(iah)),
                row(listOf(iah, iad, ord), listOf(ord, iah, iad))
            ) {
                airports, sortedAirports ->
                Airport.sort(airports) shouldBe sortedAirports
            }
        }

        "get Airport data invokes fetchData" {
            // 모킹한 Airport 컴패니언 객체의 fetchData함수를 모킹 -> mockk의 every함수로 준비된 응답을 만들어놓았다
            every { Airport.fetchData("IAD") } returns """{"IATA":"IAD","Name":"Washington","Delay":false}"""

            //mockk의 verify는 모킹한 함수가 호출되었는지 확인한다
            Airport.getAirportData("IAD")
            verify { Airport.fetchData("IAD") }
        }

        "getAirportData extracts Airport from JSON returned by fetchData" {
            every { Airport.fetchData("IAD") } returns """{"IATA":"IAD","Name":"Washington","Delay":false}"""
            Airport.getAirportData("IAD") shouldBe iad
            verify { Airport.fetchData("IAD") }
        }

        "getAirportData handles error fetching data" {
            every { Airport.fetchData("ERR") } returns "{}"
            Airport.getAirportData("ERR") shouldBe
                    Airport("ERR", "Invalid Airport", false)
            verify { Airport.fetchData("ERR") }
        }
    }
}
