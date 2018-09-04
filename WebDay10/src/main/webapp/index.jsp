<html>
<body>
<h2>Hello World!</h2>
</body>
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    window.onload=function () {
        alert("hello world")
    }

    $(function () {
        alert("jquery hello world")
    })


</script>
<script type="text/javascript" src="/js/main.js"></script>


<%--<img id="image" src="/image/Capture001.png">--%>

<input type="button" value="change" onclick="change('/image/2.jpg')">


<input type="radio" name="sex" value="male" checked="checked">
<input type="radio" name="sex" value="female" onclick="radioClick()">

<input type="password" name="password" id="password" onclick="checkPassword()">


<input type="checkbox" name="names" value="赵大" onchange="checkboxClick()"/>赵大
<input type="checkbox" name="names" value="王二" onchange="checkboxClick()"/>王二
<input type="checkbox" name="names" value="张三" onchange="checkboxClick()"/>张三


</html>
