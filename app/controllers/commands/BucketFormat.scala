package controllers.commands

object BucketFormat {
  import play.api.libs.json._
  import play.api.libs.json.Reads._
  import play.api.libs.functional.syntax._

  implicit val appleFormat: Format[AppleValue] = (
    (JsPath \ "name").format[String](minLength[String](1).keepAnd(maxLength[String](255))) and
      (JsPath \ "color").format[String](minLength[String](1).keepAnd(maxLength[String](255)))
    )(AppleValue.apply, v => (v.name, v.color))

  implicit val orangeFormat: Format[OrangeValue] = (
    (JsPath \ "name").format[String](minLength[String](1).keepAnd(maxLength[String](255))) and
      (JsPath \ "color").format[String](minLength[String](1).keepAnd(maxLength[String](255)))
    )(OrangeValue.apply, v => (v.name, v.color))

  implicit val grapeFormat: Format[GrapeValue] = (
    (JsPath \ "name").format[String](minLength[String](1).keepAnd(maxLength[String](255))) and
      (JsPath \ "color").format[String](minLength[String](1).keepAnd(maxLength[String](255)))
    )(GrapeValue.apply, v => (v.name, v.color))

  implicit val bucketFormat: Format[BucketValue] = Json.format[BucketValue]
}
