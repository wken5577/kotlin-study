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
import kotlinx.coroutines.runBlocking

class AirportStatusTest : StringSpec(){
    val iad = Airport("IAD", "Dulles", true)
    val iah = Airport("IAH", "Houston", false)
    val inv = Airport("INV", "Invalid Airport", false)

    override fun beforeTest(testCase: TestCase) {
        mockkObject(Airport)
        every { Airport.getAirportData("IAD") } returns iad
        every { Airport.getAirportData("IAH") } returns iah
        every { Airport.getAirportData("INV") } returns inv
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }

    init {

        "getAirportStatus returns status for airports in sorted order" {
            forall(
                row(listOf<String>(), listOf<Airport>()),
                row(listOf("IAD"), listOf(iad)),
                row(listOf("IAD", "IAH"), listOf(iad, iah)),
                row(listOf("IAH", "IAD"), listOf(iad, iah)),
                row(listOf("INV"), listOf(inv))
            )
            { input, result ->
                runBlocking { getAirportStatus(input) shouldBe result }
            }
        }


    }

}