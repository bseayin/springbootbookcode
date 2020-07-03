package com.zz.util;/**
 * @Description: 描述
 * @Author: Bsea
 * @CreateDate: ${Date}
 */

import com.zz.entity.Member;
import com.zz.form.MemberForm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: java类作用描述
 * @Author: Bsea
 * @CreateDate: 2019/10/14$ 20:22$
 */
public class FormUtil {
    public  static  void filterBean(){
        MemberForm member=new MemberForm();
        Member member2=new Member();
        member.setId("3453");
        member.setName("sdf");


        member2.setId("3453");
        member2.setName("sdf7777");
        member2.setSex("男");
        try {
            Field[] declaredFields = member.getClass().getDeclaredFields();
            for (Field field:declaredFields) {
                System.out.println(field);
                field.setAccessible(true);
                System.out.println(field.getName());
                Object o = field.get(member);
                System.out.println(o);
                if(o!=null){
                    String fieldName=field.getName();
                    String methodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                    Method[] declaredMethods = member2.getClass().getDeclaredMethods();
                    for (Method method:declaredMethods) {
                        System.out.println(method);
                        System.out.println("methodName***"+methodName);
                        if(method.getName().equals(methodName)){
                            method.invoke(member2,o);
                        }
                    }

                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MemberForm member=new MemberForm();
        Member member2=new Member();
        member.setId("3453");
        member.setName("sdf");


        member2.setId("3453");
        member2.setName("sdf7777");
        member2.setSex("男");
        Field[] declaredFields = member.getClass().getDeclaredFields();
        for (Field field:declaredFields) {
            System.out.println(field);
            field.setAccessible(true);
            System.out.println(field.getName());
            Object o = field.get(member);
            System.out.println(o);
            if(o!=null){
               String fieldName=field.getName();
               String methodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                Method[] declaredMethods = member2.getClass().getDeclaredMethods();
                for (Method method:declaredMethods) {
                    System.out.println(method);
                    System.out.println("methodName***"+methodName);
                    if(method.getName().equals(methodName)){
                        method.invoke(member2,o);
                    }
                }

            }

        }
        System.out.println("final member2="+member2);

    }
}
