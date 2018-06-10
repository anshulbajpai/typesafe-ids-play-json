import xerial.sbt.Sonatype.GitHubHosting

publishMavenStyle := true
licenses := Seq("MIT" -> url("https://mit-license.org/license.txt"))
sonatypeProjectHosting := Some(GitHubHosting("anshulbajpai", "typesafe-ids-play-json", "bajpai.anshul@gmail.com"))
