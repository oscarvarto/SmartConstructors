package io.github.oscarvarto
package models

import cats.data.ValidatedNel
import cats.implicits._
import io.circe._
import io.circe.generic.semiauto._
import org.scalameta.data.data

object Foo {

  sealed trait FooError
  case object IQuxIsNotNatural extends FooError

  sealed trait Foo
  case class Bar(xs: Vector[String]) extends Foo

  object Qux {
    def mk(i: Int, d: Option[Double]): ValidatedNel[FooError, Qux] = {
      if (i >= 0) new Qux(i, d).validNel else IQuxIsNotNatural.invalidNel
    }
  }

  @data(copy = false, apply = false)
  class Qux private[models](i: Int, d: Option[Double]) extends Foo

  /*
  val baos = new ByteArrayOutputStream()
  val output = AvroOutputStream.json[Qux](baos)
  */

  implicit val fooDecoder: Decoder[Foo] = deriveDecoder
  implicit val fooEncoder: Encoder[Foo] = deriveEncoder
}
