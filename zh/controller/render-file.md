#renderFile 文件下载

Controller 提供了 renderFile 系列方法支持文件下载。 文件默认下载路径为项目根路径下的 download 子路径之下,该路径称为文件下载基础路
径 。 可 以 在 JFinalConfig.configConstant(Constants me) 方 法 中 通 过 me.setBaseDownloadPath(baseDownloadPath) 设置文件下载基础路径,该路径参数接受以”/”打 头或者以 windows 磁盘盘符打头的绝对路径,即可将基础路径指向项目根径之外,方便单机 多实例部署。当该路径参数设置为相对路径时,则是以项目根为基础的相对路径。
