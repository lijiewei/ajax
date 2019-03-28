function xhr1_get(){
    var xhr = new XMLHttpRequest();
    //默认是异步请求async:true
    xhr.open("GET","./xhr1Servlet?name=zhangsan&age=23",true);
    //设置响应数据解析格式(优先级大于后端设置)
    // xhr.overrideMimeType('text/html;charset=UTF-8');
    xhr.onreadystatechange = function(e) {
        if(this.readyState === 4 && this.status === 200){
            console.log(this.response);
        }
    }
    xhr.send();
}

function xhr1_post(){
    var data = "name=zhangsan&age=23";
    var xhr = new XMLHttpRequest();
    xhr.open("POST","./xhr1Servlet",true);
    //必须设置请求头，因为request.getParameter()获取的参数只能是符合URL编码格式的
    // ajax的默认请求ContentType:text/plain(纯文本)
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.onreadystatechange = function(e) {
        if(this.readyState === 4 && this.status === 200){
            console.log(this.response);
        }
    }
    //data数据格式必须符合URL编码字符串格式,如：“param1=value1&param2=value2”
    xhr.send(data);
}

function xhr2_get() {
    var xhr = new XMLHttpRequest();
    xhr.responseType = "json";
    xhr.open("GET", "./xhr2Servlet?name=zhangsan&age=23", true);
    //注册相关事件回调处理函数
    xhr.onload = function(e) {
        if(this.status == 200||this.status == 304){
            console.log(this.response);
        }
    };
    xhr.send();
}

function xhr2_post() {
    var formData = new FormData();
    formData.append('name', 'zhangsan');
    formData.append('age', 12);
    var xhr = new XMLHttpRequest();
    //设置xhr请求的超时时间
    xhr.timeout = 3000;
    //设置响应返回的数据格式
    xhr.responseType = "text";
    //创建一个 post 请求，采用异步
    xhr.open('POST', './xhr2Servlet', true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    //注册相关事件回调处理函数
    xhr.onload = function(e) {
        if(this.status == 200||this.status == 304){
            console.log(this.response);
        }
    };
    xhr.send(formData);
}