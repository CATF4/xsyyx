<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <title>result</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="description" content="ouym"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/result.css">

</head>
<body>
<div class="content">
    <div class="s_form">
        <div class="logo">
            <a id="result_logo" href="#">
                <img src="/resources/images/logo2.png" alt="到百度首页" title="到百度首页">
            </a>
        </div>


        <div id="ul">
            <a class="mnav" href="/">回到首页</a>

        </div>
    </div>
    <div class="s_tag">

    </div>
    <div class="s_num">
        <p>演示结果
        <p>
    </div>

    <div class="s_result">

        <div id="st" class="st">
            <h2 class="hd">初始状态：</h2>
            <div class="example_code">
                <p>${result.controlIntial}</p>
                <p>${result.stackIntial}</p>
                <p>${result.denvIntial}</p>
            </div>
        </div>
        <h2 class="ks">开始演算</h2>
        <c:forEach var="results" items="${result.processDtoList}" varStatus="status">
            <div id="rs" class="st">
                <h2 class="hd">step${status.index+1}</h2>
                <div class="example_code">
                    <p>${results.regStr}</p>
                    <p>${results.controlStr}</p>
                    <p>${results.stackStr}</p>
                    <p>${results.denvStr}</p>
                </div>
            </div>
        </c:forEach>
        <h2 id="rs">结束演算</h2>
    </div>


</div>
</body>
</html>