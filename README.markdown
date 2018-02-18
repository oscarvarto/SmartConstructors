# Minimal project to show Smart Constructor Pattern with Scala

See a [thorough discussion of the Smart Constructor Pattern here](https://www.cakesolutions
.net/teamblogs/enforcing-invariants-in-scala-datatypes)

This project uses two implementations for the [Smart Constructor pattern](https://wiki.haskell.org/Smart_constructors) in Scala.

1) The weird (but useful)

```scala
sealed abstract case class Foo()
```

Rob Norris (@tpolecat in github, twitter), a very well known typelevel contributor, explains it very nicely in [this gist](https://gist.github.com/tpolecat/a5cb0dc9adeacc93f846835ed21c92d2).
This approach has the benefit that does not require compiler plugins.


2) Using the `@data` annotation (requires scala macros)

```scala
@data(copy=false, apply=false) 
class Foo()
```

## Additional Information/Links

* [smartypants](https://github.com/davegurnell/smartypants)
* [Roadmap towards non-experimental macros](http://www.scala-lang.org/blog/2017/10/09/scalamacros.html)
