#afterJFinalStart()与 beforeJFinalStop()

`afterJfinalStart()` and `beforeJFinalStop` methods are provided to developers to be overwritten in derived class of `JFInalConfig`.

JFinal would call `afterJfinalStart` method after system start completely, call `beforeJFinalStop` before system shutdown.These two methods provide changes for developers to do extra operations before project start and after project stop like creating schedual threads after system start,persistenting cache(?) before system shutdown.
