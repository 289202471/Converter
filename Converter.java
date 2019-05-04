package converter;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * Copyright © 2019 FM. nuaa. All rights reserved.
 *
 * @Project: demo
 * @Package: Converter
 * @FileType: Class
 * @ClassName: Converter
 * @Version 1.0
 * @Author: zong
 * @Mail: 289202471@qq.com
 * @Company: nuaa
 * @Date: 2019/5/4 8:04
 * @Description: A tool used to turn lowercase to uppercase or turn uppercase to lowercase
 */
public class Converter {
    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:49
     * @Description: A class to get the system clipboard
     **/
    public Clipboard clipboard;

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:50
     * @MethodName: Converter
     * @Param: []
     * @Return: void
     * @Description: the constructor to init the cliboard
     **/
    public Converter(){
        clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:50
     * @MethodName: putTextIntoCliboard
     * @Param: [text] the text
     * @Return: void
     * @Description: put the text into the cliboard
     **/
    public void putTextIntoCliboard(String text) {
        Transferable tText=new StringSelection(text);
        clipboard.setContents(tText,null);
    }

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:51
     * @MethodName: getTextFromCliboard
     * @Param: []
     * @Return: java.lang.String  the text that the user copy from somewhere
     * @Description: get the text that the user copy from somewhere.
     **/
    public String getTextFromCliboard() throws IOException, UnsupportedFlavorException {
        String result="";
        Transferable tText=clipboard.getContents(null);

        if (tText != null) {
            /*
              @Author: zong
             * @Mail: 289202471@qq.com
             * @Date: 2019/5/4 8:51
             * @Description: check whether the contents form the cliboard are String
             */
            if (tText.isDataFlavorSupported(DataFlavor.stringFlavor))
                result=(String)tText.getTransferData(DataFlavor.stringFlavor);
        }

        return result;
    }
    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:52
     * @MethodName: upper
     * @Param: [lower] the lower case
     * @Return: java.lang.String the case been turned upper.
     * @Description: Upper the LowerCase .
     **/
    public String upper(String lower){
        return lower.toUpperCase();
    }

    /**
     * @Author: zong
     * @Mail: 289202471@qq.com
     * @Date: 2019/5/4 8:53
     * @MethodName: lower
     * @Param: [upper] the upper case
     * @Return: java.lang.String the case been turned lower .
     * @Description: Lower the UpperCase .
     **/
    public String lower(String upper){
        return upper.toLowerCase();
    }
}
