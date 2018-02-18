package io.github.oscarvarto.models

import cats.data._
import cats.implicits._

sealed trait ComposerError
case object EmptyName extends ComposerError

object Composer {
  def apply(name: String,
            birthplace: String,
            compositions: Seq[String]): ValidatedNel[ComposerError, Composer] = {
    new Composer(name, birthplace, compositions){}.validNel
  }
}

sealed abstract case class Composer(name: String, birthplace: String, compositions: Seq[String])
