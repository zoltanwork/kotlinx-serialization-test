import kotlinx.serialization.json.Json
import kotlin.test.Test

class DtoTest {
  @Test
  fun testSerializationCoroutines() {
    val a = Json.decodeFromString(
      AnyClass.serializer(),
      """{"anInt":"100","aDate":"2019-04-12T07:06:12.000+00:00"}"""
    )
    println(a)
  }
}