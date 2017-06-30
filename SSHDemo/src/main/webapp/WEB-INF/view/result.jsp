<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <title>result</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="ouym" />
    <link rel="stylesheet" type="text/css" href="/resources/css/result.css">

</head>
<body>
<div class="content">
    <div class="s_form">
        <div class="logo">
            <a id="result_logo" href="#">
                <img src="/resources/images/baidu_jgylogo3.gif" alt="到百度首页" title="到百度首页">
            </a>
        </div>


        <div class="serch">
            <form action="">
                <input id="kw" name="wd" class="s_ipt" value="${query}" maxlength="255" autocomplete="off"/>
                <input id="mysubmit" type="submit" value="百度一下"/>
            </form>
        </div>

        <div id ="ul">
            <a class="mnav" href="./index.html">百度首页</a>
            <a class="mnav" href="">设置</a>
            <a class="mnav" href="">登录</a>
        </div>
    </div>
    <div class="s_tag">
        <img src="/resources/images/test.png" >
    </div>
    <div class="s_num">
        <p>百度为您找到相关结果约1000个<p>
    </div>
    <div class="s_result">
        <div class="s_left">

        </div>
        <div class="s_right">

        </div>
    </div >
    <div class="s_footer">
        <img src="/resources/images/footer.png" >
    </div>

</div>
</body>
</html>