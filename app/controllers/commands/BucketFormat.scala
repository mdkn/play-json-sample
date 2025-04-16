package controllers.commands

object BucketFormat {
  import play.api.libs.json._

  implicit val appleFormat: Format[AppleValue] = Json.format[AppleValue]

  implicit val orangeFormat: Format[OrangeValue] = Json.format[OrangeValue]

  implicit val grapeFormat: Format[GrapeValue] = Json.format[GrapeValue]

  implicit val bucketFormat: Format[BucketValue] = Json.format[BucketValue]
}
