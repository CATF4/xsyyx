package com.ssm.demo.core.util;

/**
 * Describe：规则常量表
 * Created by 欧阳猛 on 2017/7/1.
 */
public class ConstTab {

    public final static String 常量规则 = "常量规则：(vs, const(c):e, delta) => (c:vs, e, delta)";
    public final static String 变量规则 = "变量规则：(vs, var(c):e, delta) => (delta(x):vs, e, delta)";
    public final static String 乘法规则 = "乘法规则：(n1:n2:vs, mul:e, delta) => (n:vs, e, delta), n= n1*n2";
    public final static String 除法规则 = "除法规则：(n1:n2:vs, div:e, delta) => (n:vs, e, delta), n= n1/n2";
    public final static String 减法规则 = "减法规则：(n1:n2:vs, sub:e, delta) => (n:vs, e, delta), n= n1-n2";
    public final static String 加法规则 = "加法规则：(n1:n2:vs, add:e, delta) => (n:vs, e, delta), n= n1+n2";
    public final static String 小于等于 = "小于等于比较规则：(n1:n2:vs, se:e, delta) => (n:vs, e, delta), n = (n1<=n2)";
    public final static String 大于等于 = "大于等于比较规则：(n1:n2:vs, ge:e, delta) => (n:vs, e, delta), n = (n1>=n2)";
    public final static String 分解规则 = "分解规则:(vs, op(e1,e2):e, delta) => (vs, e2:e1:op:e, delta)";
}
