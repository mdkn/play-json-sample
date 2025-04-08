package models

case class Bucket(label: String, apple: Apple, orange: Orange, grape: Grape)

sealed trait Fruit {
  val name: String
  val color: String
}

case class Apple(
    override val name: String,
    override val color: String
) extends Fruit

case class Orange(
    override val name: String,
    override val color: String
) extends Fruit

case class Grape(
    override val name: String,
    override val color: String
) extends Fruit
