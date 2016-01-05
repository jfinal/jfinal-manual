#afterJFinalStart()与 beforeJFinalStop()

JFinalConfig 中的 afterJFinalStart()与 beforeJFinalStop()方法供开发者在 JFinalConfig 继承类中 覆盖。JFinal 会在系统启动完成后回调 afterJFinalStart()方法,会在系统关闭前回调 beforeJFinalStop()方法。这两个方法可以很方便地在项目启动后与关闭前让开发者有机会进行 额外操作,如在系统启动后创建调度线程或在系统关闭前写回缓存。
