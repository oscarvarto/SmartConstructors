package io.github.oscarvarto

import cats.data.ValidatedNel
import io.github.oscarvarto.models.Foo._
import io.circe.parser._
import io.circe.syntax._

object Hello extends App {

  val foo: ValidatedNel[FooError, Foo] = Qux.mk(13, Some(14.0))

  val json = foo.map(_.asJson.noSpaces)
  json.foreach(println)

  val decodedFoo = json.map(decode[Foo])
  decodedFoo.foreach(println)
}
