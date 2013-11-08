<#assign shiro=JspTaglibs["http://shiro.apache.org/tags"]>
<!DOCTYPE html>
<html lang="en">
<#include "commons/header.ftl" >

<body >
<#include "commons/navbar.ftl" >

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

    <#include "commons/sidebar.ftl" >

        <div class="main-content" id="main-content" style="height: 100%">
            <!--
            <iframe id="mainframe" frameborder="0" name="main"
                    style="width:100%;height:100%;" scrolling="no"
                    border="0" src="${rc.getContextPath()}/main">
                    </iframe>
            -->
            <#include "./main.ftl">
        </div><!-- /.main-content -->


    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<#include "commons/common-script.ftl" >


<script type="text/javascript" src="${rc.getContextPath()}/assets/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/assets/js/jquery.ztree.excheck-3.5.min.js"></script>


<script type="text/javascript">
    /**
    $(document).ready(function(id, url) {
        $("#element").click(function() {
            console.log("load...");
            $("#main-content").load("./main.ftl");
        });
    });
     **/
    function loadPage(url) {
        $("#main-content").load(url);
    }
</script>
</body>
</html>
