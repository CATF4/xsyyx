package com.ssm.demo.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ssm.demo.core.util.ConstTab.*;


/**
 * Describe：抽象机演示过程
 * Created by 欧阳猛 on 2017/6/30.
 */
public class MyLeProcess {

    private String control[] = new String[100];
    private String stack[] = new String[100];
    private static String denv;
    private static Map<String, Integer> Denv = new HashMap<String, Integer>();
    private int controlsize, stacktop;

    private String controlIntial = "[";
    private String stackIntial = "[";
    private String denvIntial = "[";

    List<String> regList = new ArrayList<>();//分解规则
    List<String> controlList = new ArrayList<>();//control
    List<String> stackList = new ArrayList<>();//动态栈
    String denvStr = "";

    @SuppressWarnings("static-access")
    public MyLeProcess(String exp, String denv)
    {
        controlsize = 0;
        stacktop = 0;
        Denv.clear();
        this.control[controlsize++] = exp;
        //System.out.println(control[0]);
        this.denv=denv;
        init_Denv();
    }

    /*public static void main(String[] args) {
        String exp = "ge(add(var(x),mul(cons(2),var(y))),var(z))";
        String denv = "[x->34, y->7, z->50]";
        MyLeProcess myLeProcess = new MyLeProcess(exp,denv);
        System.out.println("抽象机动态演练");
        myLeProcess.cal();
        myLeProcess.printResult();

    }*/


    public void printResult(){
        System.out.println("开始****************************************************************");
        int len = controlList.size();
        for (int i = 0 ; i < len ; i++){
            System.out.println(regList.get(i));
            System.out.println(controlList.get(i));
            System.out.println(stackList.get(i));
            System.out.println(denvStr);
            System.out.println("");
        }
        System.out.println("结束***************************************************************** ");
    }

    public void cal()
    {

        //初始状态**************************************************************************
        System.out.println("初始状态:");

        for (int i = controlsize - 1; i >= 0; i--)
        {
            controlIntial += control[i];
            if (i != 0)
                controlIntial += ", ";
        }
        controlIntial += "]";
        controlIntial = "Control: "+controlIntial;
        System.out.println(controlIntial);


        for (int i = stacktop - 1; i >= 0; i--)
        {
            stackIntial += stack[i];
            if (i != 0)
                stackIntial += ", ";
        }
        stackIntial += "]";
        stackIntial = "Stack   :"+stackIntial;
        System.out.println(stackIntial);


        Boolean flaginitial = false;
        for (Map.Entry<String, Integer> x : Denv.entrySet())
        {
            if (flaginitial)
                denvIntial += ", ";
            flaginitial = true;
            denvIntial += x.getKey() + "->" + String.valueOf(x.getValue());
        }
        denvIntial += "]";
        denvIntial = "动态环境   :"+denvIntial;
        System.out.println(denvIntial);

        //计算**************************************************************************
        while (controlsize > 0)
        {
            String now = control[controlsize - 1];
            controlsize--;
            String fir = getfirString(now);
            if (fir.equals("ge"))
            {
                if (now.length() > 2)
                    Devide(now);
                else
                    gaoGe();
            }
            else if (fir.equals("se"))
            {
                if (now.length() > 2)
                    Devide(now);
                else
                    gaoSe();
            }
            else if (fir.equals("add"))
            {
                if (now.length() > 3)
                    Devide(now);
                else
                    gaoAdd();
            }
            else if (fir.equals("sub"))
            {
                if (now.length() > 3)
                    Devide(now);
                else
                    gaoSub();
            }
            else if (fir.equals("mul"))
            {
                if (now.length() > 3)
                    Devide(now);
                else
                    gaoMul();
            }
            else if (fir.equals("div"))
            {
                if (now.length() > 3)
                    Devide(now);
                else
                    gaoDiv();
            }
            else if (fir.equals("cons"))
            {
                regList.add(常量规则);
                //System.out.println("常量规则：(vs, const(c):e, delta) => (c:vs, e, delta)");
                stack[stacktop++] = getAll(now);
            }
            else
            {
                regList.add(变量规则);
                //System.out.println("变量规则：(vs, var(c):e, delta) => (delta(x):vs, e, delta)");
                stack[stacktop++] = String.valueOf(Denv.get(getAll(now)));
            }

            String controlOut = "[";
            for (int i = controlsize - 1; i >= 0; i--)
            {
                controlOut += control[i];
                if (i != 0)
                    controlOut += ", ";
            }
            controlOut += "]";
            controlOut = "Control: "+controlOut;
            controlList.add(controlOut);
            //System.out.println("Control: "+controlOut);

            String stackOut = "[";
            for (int i = stacktop - 1; i >= 0; i--)
            {
                stackOut += stack[i];
                if (i != 0)
                    stackOut += ", ";
            }
            stackOut += "]";
            stackOut = "Stack   :"+stackOut;
            stackList.add(stackOut);
            //System.out.println("Stack   :"+stackOut);

            String denvOut = "[";
            Boolean flagOut = false;
            for (Map.Entry<String, Integer> x : Denv.entrySet())
            {
                if (flagOut)
                    denvOut += ", ";
                flagOut = true;
                denvOut += x.getKey() + "->" + String.valueOf(x.getValue());
            }
            denvOut += "]";
            denvOut = "动态环境   :"+denvOut;
            denvStr = denvOut;
            //System.out.println("DEnv   :"+denvOut);

        }



    }





    private String getAll(String now)
    {
        // TODO Auto-generated method stub
        int len = now.length(), i = 0;
        while (i < len && now.charAt(i) != '(')
            i++;
        i++;
        String ret = "";
        while (i < len && now.charAt(i) != ')')
        {
            ret += now.charAt(i);
            i++;
        }
        return ret;
    }

    private void gaoDiv()
    {
        // TODO Auto-generated method stub
        regList.add(除法规则);
        //System.out.println("除法规则：(n1:n2:vs, div:e, delta) => (n:vs, e, delta), n= n1/n2");
        int a = Integer.valueOf(stack[--stacktop]);
        int b = Integer.valueOf(stack[--stacktop]);
        stack[stacktop++] = String.valueOf(a / b);
    }

    private void gaoMul()
    {
        // TODO Auto-generated method stub
        regList.add(乘法规则);
        //System.out.println("乘法规则：(n1:n2:vs, mul:e, delta) => (n:vs, e, delta), n= n1*n2");
        int a = Integer.valueOf(stack[--stacktop]);
        int b = Integer.valueOf(stack[--stacktop]);
        stack[stacktop++] = String.valueOf(a * b);
    }

    private void gaoSub()
    {
        // TODO Auto-generated method stub
        regList.add(减法规则);
        //System.out.println("减法规则：(n1:n2:vs, sub:e, delta) => (n:vs, e, delta), n= n1-n2");
        int a = Integer.valueOf(stack[--stacktop]);
        int b = Integer.valueOf(stack[--stacktop]);
        stack[stacktop++] = String.valueOf(a - b);
    }

    private void gaoAdd()
    {
        // TODO Auto-generated method stub
        regList.add(加法规则);
        //System.out.println("加法规则：(n1:n2:vs, add:e, delta) => (n:vs, e, delta), n= n1+n2");
        int a = Integer.valueOf(stack[--stacktop]);
        int b = Integer.valueOf(stack[--stacktop]);
        stack[stacktop++] = String.valueOf(a + b);
    }

    private void gaoSe()
    {
        // TODO Auto-generated method stub
        regList.add(小于等于);
        //System.out.println("比较规则：(n1:n2:vs, se:e, delta) => (n:vs, e, delta), n = (n1<=n2)");
        int a = Integer.valueOf(stack[--stacktop]);
        int b = Integer.valueOf(stack[--stacktop]);
        if (a <= b)
            stack[stacktop++] = "true";
        else
            stack[stacktop++] = "false";
    }

    private void gaoGe()
    {
        // TODO Auto-generated method stub
        regList.add(大于等于);
        //System.out.println("比较规则：(n1:n2:vs, ge:e, delta) => (n:vs, e, delta), n = (n1>=n2)");
        int a = Integer.valueOf(stack[--stacktop]);
        int b = Integer.valueOf(stack[--stacktop]);
        if (a >= b)
            stack[stacktop++] = "true";
        else
            stack[stacktop++] = "false";
    }

    private String getfirString(String now)
    {
        // TODO Auto-generated method stub
        int len = now.length(), i = 0;
        char c = now.charAt(i);
        while (i < len && (c < 'a' || c > 'z'))
        {
            i++;
            if (i < len)
                c = now.charAt(i);
        }
        String ret = "";
        while (i < len && c >= 'a' && c <= 'z')
        {
            ret += c;
            i++;
            if (i < len)
                c = now.charAt(i);
        }
        return ret;
    }

    private void Devide(String now)
    {
        // TODO Auto-generated method stub
        regList.add(分解规则);
        //System.out.println("分解规则:(vs, op(e1,e2):e, delta) => (vs, e2:e1:op:e, delta)");
        control[controlsize++] = getfirString(now);
        control[controlsize++] = getPartone(now);
        control[controlsize++] = getParttwo(now);
    }

    private String getPartone(String now)
    {
        // TODO Auto-generated method stub
        int len = now.length(), i = 0;
        while (i < len && now.charAt(i) != '(')
            i++;
        i++;
        String ret = "";
        int cnt = 0;
        while (i < len && now.charAt(i) == ' ')
            i++;
        //      System.out.print(i);
        while (i < len && (now.charAt(i) != ',' || cnt != 0))
        {
            ret += now.charAt(i);
            if (now.charAt(i) == '(')
                cnt++;
            if (now.charAt(i) == ')')
                cnt--;
            i++;
        }
        //      System.out.println(" Debug partone: " + ret);
        return ret;
    }

    private String getParttwo(String now)
    {
        // TODO Auto-generated method stub
        int len = now.length(), i = 0;
        while (i < len && now.charAt(i) != '(')
            i++;
        i++;
        int cnt = 0;
        while (i < len && now.charAt(i) == ' ')
            i++;
        //      System.out.print(i);
        while (i < len && (now.charAt(i) != ',' || cnt != 0))
        {
            if (now.charAt(i) == '(')
                cnt++;
            if (now.charAt(i) == ')')
                cnt--;
            i++;
        }
        i++;
        while (i < len && now.charAt(i) == ' ')
            i++;
        String ret = "";
        while (i < len - 1)
        {
            ret += now.charAt(i);
            i++;
        }
        return ret;
    }

    /**
     * 初始化动态环境
     * 将<变量:值>放入Denv map
     */
    private static void init_Denv()
    {
        // TODO Auto-generated method stub
        int len = denv.length();


        for (int i = 0; i < len; i++)
        {
            char c = denv.charAt(i);
            while (i < len && (c < 'a' || c > 'z'))
            {
                i++;
                if (i < len)
                    c = denv.charAt(i);
            }
            String letter = "";
            while (i < len && c >= 'a' && c <= 'z')
            {
                letter += c;
                i++;
                if (i < len)
                    c = denv.charAt(i);
            }
            while (i < len && (c < '0' || c > '9'))
            {
                i++;
                if (i < len)
                    c = denv.charAt(i);
            }
            int number = 0;
            while (i < len && c >= '0' && c <= '9')
            {
                number = number * 10 + c - '0';
                i++;
                if (i < len)
                    c = denv.charAt(i);
            }
            //          System.out.println(tmp + num);
            Denv.put(letter, number);
        }
    }

    public List<String> getRegList() {
        return regList;
    }

    public List<String> getControlList() {
        return controlList;
    }

    public List<String> getStackList() {
        return stackList;
    }

    public String getDenvStr() {
        return denvStr;
    }

    public String getControlIntial() {
        return controlIntial;
    }

    public String getStackIntial() {
        return stackIntial;
    }

    public String getDenvIntial() {
        return denvIntial;
    }
}
