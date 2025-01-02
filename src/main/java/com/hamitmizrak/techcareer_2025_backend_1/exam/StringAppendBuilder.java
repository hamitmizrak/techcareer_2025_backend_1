package com.hamitmizrak.techcareer_2025_backend_1.exam;

public class StringAppendBuilder {

    public static void main(String[] args) {
        String deneme1="Hatay",deneme2="Malatya",deneme3="Elazığ";

        // 1.YOL
        String norm=deneme1+deneme2+deneme3;
        System.out.println(norm);

        // 2.YOL
        String norm2=deneme1.concat(deneme2).concat(deneme3);
        System.out.println(norm2);

        // 3.YOL
        StringBuilder builder=new StringBuilder();
        builder.append(deneme1).append(deneme2).append(deneme3);
        String result=builder.toString();
        System.out.println(result);

        // 4.YOL
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(deneme1).append(deneme2).append(deneme3);
        String result2=stringBuffer.toString();
        System.out.println(result2);

    }
}
