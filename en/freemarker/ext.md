#Extension in JFinal

You can configure shared utility class for FreeMarker with `FreeMarkerRender.getConfiguration().setSharedVariable(“myKit”, new MyKit())` , then use `${myKit.method(para)}` in view.
