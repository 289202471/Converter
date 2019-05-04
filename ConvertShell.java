package converter;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Copyright © 2019 FM. nuaa. All rights reserved.
 *
 * @Project: demo
 * @Package: converter
 * @FileType: Class
 * @ClassName: ConvertShell
 * @Version 1.0
 * @Author: zong
 * @Mail: 289202471@qq.com
 * @Company: nuaa
 * @Date: 2019/5/4 8:26
 * @Description: the shell for the converter.
 */
public class ConvertShell {
    //A converter
    public static Converter c=new Converter();
    //A scanner to get the user choice
    public static Scanner sc=new Scanner(System.in);

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:44
     * @MethodName: getTextFromCliboard
     * @Param: []
     * @Return: java.lang.String the text that the user copy from somewhere.
     * @Description: get the text that the user copy from somewhere.
     **/
    public static String getTextFromCliboard(){
        String input="";
        try {
            input=c.getTextFromCliboard();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        }
        return input;
    }

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:45
     * @MethodName: putTextToCliboard
     * @Param: [output] the text which would be sent to the cliboard
     * @Return: void
     * @Description: put the text into the Cliboard and user can use it by " ctrl + v ".
     **/
    public static void putTextToCliboard(String output){
        c.putTextIntoCliboard(output);
    }

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:47
     * @MethodName: doChocie
     * @Param: [choice] an int to show user choice .
     * @Return: int choice or 0(no function match the choice)
     * @Description: do what the user choose to do .
     **/
    public static int doChocie(int choice){
        switch(choice){
            case 1:{
                String input=getTextFromCliboard();
                String output=c.upper(input);
                putTextToCliboard(output);
                return 1;
            }
            case 2:{
                String input=getTextFromCliboard();
                String output=c.lower(input);
                putTextToCliboard(output);
                return 2;
            }
            default:return 0;
        }
    }

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:46
     * @MethodName: main
     * @Param: [args]
     * @Return: void
     * @Description: main
     **/
    public static void main(String[] args) {
        String input="";
        String output="";

        input=getTextFromCliboard();

        int choice=1;
        while(choice!=0){
            /*
             * @Author: zong
             * @Mail: 289202471@qq.com
             * @Date: 2019/5/4 8:46
             * @Description: ask user to choice the action
             **/
            System.out.println("Please choose what you want to do:(1 or 2 exit(0))");
            System.out.println("1.Upper");
            System.out.println("2.Lower");
            choice=sc.nextInt();
            doChocie(choice);
        }
    }
}
