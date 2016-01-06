#getFile 文件上传

Controller 提供了 getFile 系列方法支持文件上传。 <font color='red'>特别注意:如果客户端请求为 multipart
request(form 表单使用了 enctype="multipart/form-data"),那么必须先调用 getFile 系列方法才 http://www.jfinal.com
能使 getPara 系列方法正常工作,因为 multipart request 需要通过 getFile 系列方法解析请求体中 的数据,包括参数。</font>

文件默认上传至项目根路径下的 upload 子路径之下,该路径称为文件上传基础路径。可以 在 JFinalConfig.configConstant(Constants me)方法中通过 me.setBaseUploadPath(baseUploadPath) 设置文件上传基础路径,该路径参数接受以”/”打头或者以 windows 磁盘盘符打头的绝对路径, 即可将基础路径指向项目根径之外,方便单机多实例部署。当该路径参数设置为相对路径时, 则是以项目根为基础的相对路径。
