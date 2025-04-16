package controllers.commands

import models.{Apple, Bucket, Grape, Orange}

case class BucketValue(
    label: String,
    appleValue: AppleValue,
    orangeValue: OrangeValue,
    grapeValue: GrapeValue
)

object BucketValue {
  def apply(m: Bucket): BucketValue = BucketValue(
    label = m.label,
    appleValue = AppleValue.apply(m.apple),
    orangeValue = OrangeValue.apply(m.orange),
    grapeValue = GrapeValue.apply(m.grape)
  )
}

case class AppleValue(name: String, color: String)

object AppleValue {
  def apply(m: Apple): AppleValue = AppleValue(m.name, m.color)

  def toModel(v: AppleValue): Apple = Apple(v.name, v.color)
}

case class OrangeValue(name: String, color: String)

object OrangeValue {
  def apply(m: Orange): OrangeValue = OrangeValue(m.name, m.color)

  def toModel(v: OrangeValue): Orange = Orange(v.name, v.color)
}

case class GrapeValue(name: String, color: String)

object GrapeValue {
  def apply(m: Grape): GrapeValue = GrapeValue(m.name, m.color)

  def toModel(v: GrapeValue): Grape = Grape(v.name, v.color)
}
