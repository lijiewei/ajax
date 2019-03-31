//在 html 所有标签(DOM)都加载之后，就会去执行
//DOM文档对象转换为jQuery对象，然后通过ready(fn)注册页面加载事件，当页面加载完毕后执行fn函数
$(document).ready(function(){

    //AJAX 请求完成时运行的函数,$(document)表示DOM对象转换为jQuery对象
    $(document).ajaxComplete(function () {
        console.log("jqueryAjax请求结束");
    });
    //为将来的 $.ajax()请求设置默认值,$.get()和$.post()不能触发
    $.ajaxSetup({
        url:"./xhr1Servlet?name=zhangsan&age=25",
        async:true,
        type:"GET",
        headers: {
            "Accept" : "text/html; charset=utf-8",
            "Content-Type": "text/html; charset=utf-8"
        },
        success:function(data){
            console.log("ajax()请求结束,结果：" );
            console.log(data);
        }
    });
    $("#jquery_ajax_get").click(function() {
        $.ajax();
        $.get("./xhr1Servlet?name=zhangsan&age=23", function (data) {
            console.log(data);
        }, "text");

        $.get("./xhr2Servlet", {"name": "zhangsan", "age": 23}, function (data) {
            console.log(data);
        }, "json");
    });

    $("#jquery_ajax_post").click(function() {
        $.post("./xhr1Servlet?name=zhangsan&age=23", function (data) {
            console.log(data);
        }, "text");

        $.post("./xhr2Servlet", {"name": "zhangsan", "age": 23}, function (data) {
            console.log(data);
        }, "json");

        //运行报错，因为header is application/x-www-form-urlencoded
        $.post("./xhr2postServlet", {"name": "zhangsan", "age": 23}, function (data) {
            console.log(data);
        }, "json");
    });
});

