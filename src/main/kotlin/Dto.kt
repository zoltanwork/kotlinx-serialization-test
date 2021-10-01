import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class AnyClass (
  val anInt: Int,
  @Serializable(with = LocalDateTimeSerializer::class)
  val aDate: LocalDateTime?
)

object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
  override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("localDateTime", PrimitiveKind.STRING)

  override fun serialize(encoder: Encoder, value: LocalDateTime) {
    encoder.encodeString(value.toString())
  }

  override fun deserialize(decoder: Decoder): LocalDateTime {
    var s = decoder.decodeString()
    if (s.lastIndexOf('.') > 0) {
      s = s.substring(0, s.lastIndexOf('.'))
    }
    return LocalDateTime.parse(s)
  }
}
