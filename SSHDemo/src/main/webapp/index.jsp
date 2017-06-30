<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <title>抽象机演示</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="ouym" />
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css">

</head>
<body>
<div class="content">

    <div id ="ul">
        <a class="mnav" id ="more" href="${website}/ryfg" style="background: #38f;color:#fff">小组成员</a>
        <a class="mnav" href="#" title="项目负责、任务分配">张家鑫</a>
        <a class="mnav" href="#" title="项目搭建、后端实施">欧阳猛</a>
        <a class="mnav" href="#" title="需求设计、资料整理">赵博研</a>
        <a class="mnav" href="#" title="理论指导、版本控制">潘雪峰</a>
        <a class="mnav" href="#" title="前端设计与实现">徐壮志</a>
        <a class="mnav" href="#" title="单元测试与维护">齐鹏</a>
    </div>
    <div class="logo">
        <img hidefocus="true" src="/resources/images/bd_logo2.png" height="129" width="270">
    </div>
    <div class="serch">
        <form action="/user/index" method="post">
            <input id="kw" name="wd" class="s_ipt" value="" maxlength="255" autocomplete="off"/>
            <input id="mysubmit" type="submit" value="输入表达式"/>
        </form>
    </div>
    <div class = "footer">
        <p>形式语义学 第二次作业汇报</p>
        <p>2017年7月@汇报人：欧阳猛</p>
    </div>

</div>
</body>

</html>