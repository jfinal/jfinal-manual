#在JFinal中扩展

可以通过 FreeMarkerRender.getConfiguration().setSharedVariable(“myKit”, new MyKit())为 FreeMarker 设置共享工具类,在 view 中使用 ${myKit.method(para)}。
