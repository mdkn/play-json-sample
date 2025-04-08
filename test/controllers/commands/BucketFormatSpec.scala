package controllers.commands

import org.scalatestplus.play.PlaySpec
import play.api.libs.json.{JsResult, JsSuccess, JsValue, Json, Reads}

class BucketFormatSpec extends PlaySpec {

  "BucketFormatSpec" should {
    "format object to json" in {
      val bucketValue = BucketValue(
        AppleValue("Sweet apple", "Red"),
        OrangeValue("Bitter orange", "Green"),
        GrapeValue("Sour Grape", "Lime green")
      )
      import BucketFormat._

      val result: JsValue = Json.toJson(bucketValue)

      result.toString.mustBe(
        "{\"appleValue\":{\"name\":\"Sweet apple\",\"color\":\"Red\"},\"orangeValue\":{\"name\":\"Bitter orange\",\"color\":\"Green\"},\"grapeValue\":{\"name\":\"Sour Grape\",\"color\":\"Lime green\"}}"
      )
    }
    "format json to object" in {
      val json =
        "{\"appleValue\":{\"name\":\"Sweet apple\",\"color\":\"Red\"},\"orangeValue\":{\"name\":\"Bitter orange\",\"color\":\"Green\"},\"grapeValue\":{\"name\":\"Sour Grape\",\"color\":\"Lime green\"}}"
      import BucketFormat._

      val result: JsResult[BucketValue] =
        Json.fromJson[BucketValue](
          // We got compile error here when Json.parse is removed.
          Json.parse(json))

      result.mustBe(
        // Wrapping by JsSuccess to match the expected type.
        JsSuccess(
          BucketValue(
            AppleValue("Sweet apple", "Red"),
            OrangeValue("Bitter orange", "Green"),
            GrapeValue("Sour Grape", "Lime green")
          )
        )
      )
    }
  }
}
