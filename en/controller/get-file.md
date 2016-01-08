#getFile File Upload

Controller provide getFile series methods to support file upload.
 <font color='red'>
NOTE: If client request is multpart request( encype='multipart/form-data' is used in form
 request(form 表单使用了 enctype="multipart/form-data"),`getFile` series methods should be invoked first, in order to keep `getPara` working correctly, because multipart request need to extract data incluing parameters via `getFile` series methods.


The defalut upload path is the `upload` sub-folder in root path of the project, which is called the base path of file upload.

you could configure the base path of file download via `me.setBaseUploadPath(baseUploadPath)` in `JFinalConfig.configConstant(Constants me)` and the path accept parameter starts with '/' or absolute path starts with name of disk drive in windows OS,which means base path could be pointed outside the root of project to support multi-instance deployment.When base path set to relative path, the path parameter is a relative path based on root path of the project.
