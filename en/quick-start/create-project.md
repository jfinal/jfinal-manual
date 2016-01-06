#Create Project
JFinal recommands developers to use `Eclipse IDE for Java EE Developers` as develop environment. 

[Download URL](http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/SR2/eclipse-jee-lun a-SR2-win32-x86_64.zip)

[Quick start for IDEA users](http://my.oschina.net/chixn/blog/471755)


   
##Dynamic Web Project

  ![](../images/1.1.png)
    
  
##Fill up basic information of project

  ![](../images/1.2.png)
    
**NOTE：** Target runtime should be <None>
   
##Modify Default Output Folder，WebRoot\WEB-INF\classes is recommended

  ![](../images/1.3.png)

<font color="red">NOTE：The `Default out folder` here must be the same as `WebRoot\WEB-INF\classes` folder , in order to use Jetty embedded in JFinal to start project.</font>
    
##Modify Content directory，WebRoot is recommended

  ![](../images/1.4.png)
    
**NOTE：** Default value `WebContent` can be used here ,but `WebRoot\WEB-INF\classes` in previous step  should be modified to `WebContent\WEB-INF\classes`.

   
    

