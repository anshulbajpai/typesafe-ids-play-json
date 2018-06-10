# typesafe-ids-play-json
An integration of [typesafe-ids](https://github.com/anshulbajpai/typesafe-ids) with [play-json](https://github.com/playframework/play-json)

[![Build Status](https://travis-ci.org/anshulbajpai/typesafe-ids-play-json.svg?branch=master)](https://travis-ci.org/anshulbajpai/typesafe-ids-play-json) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.anshulbajpai/typesafe-ids-play-json_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.anshulbajpai/typesafe-ids-play-json_2.12)
![license](https://img.shields.io/github/license/mashape/apistatus.svg)

This library helps with play-json's Reads/Writes/Format instance derivation for a typesafe-id type.

## Usage

Include typesafe-ids-play-json via SBT from maven central

```scala
libraryDependencies += "com.github.anshulbajpai" %% "typesafe-ids-play-json" % "0.1.0"
```

We support scala 2.11 and 2.12.

If a play-json's implicit Reads/Writes/Format instance for underlying `IdType#IdValue` is available in the scope, then a corresponding implicit instance for `Id[IdType]` will be automatically available.

```scala

  import com.github.anshulbajpai.typsafeids.core.IdType
  import com.github.anshulbajpai.typsafeids.core.Id
  import com.github.anshulbajpai.typesafeids.json.play.implicits._

  trait UserId extends IdType {
    type IdValue = UUID
  }
  
  val userId: Id[UserId] = Id[UserId](UUID.randomUUID())
  
  // Serialization
  Json.toJson(userId) // will evaluate to JsString(userId.value.toString)
  
  //Deserialization
  val uuid = UUID.randomUUID()
  Json.fromJson[Id[UserId]](JsString(uuid.toString)) // will evaluate to JsSuccess(Id[UserId](userId))
```

Please note that we had to import `com.github.anshulbajpai.typesafeids.json.play.implicits._` in the above example.

The above example work because an implicit Reads/Writes/Format instance for `java.util.UUID` (provided by `play.api.libs.json`) is present in scope.