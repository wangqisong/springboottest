package com.example.springboottest.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import java.io.File;
import java.io.IOException;

/**
 * @author: wangqisong
 * @date: 2020/4/7
 * @Description:
 */
public class JxlTest {
    public static void main(String[] args) {
        try {
           String path = "C:\\Users\\Administrator\\Desktop\\test.xls";
           /*  String s = "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊" +
                    "啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊";
            StringBuilder sb = new StringBuilder(s);
           *//* while (sb.length() <= 32600) {
                sb.append(s);
            }
            if (sb.length()<32776){
                sb.append("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            }*//*
            String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            StringBuilder sb2 = new StringBuilder(s2);
            while (sb2.length() <= 32600) {
                sb2.append(s2);
            }
            if (sb2.length() < 32776) {
                sb2.append("1啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            }
            System.out.println(sb2.length());
            JxlTest.export(path, sb2.toString());*/
            read(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void export(String path, String content) throws Exception {

        File xlsFile = new File(path);
        WorkbookSettings wbs = new WorkbookSettings();
        wbs.setGCDisabled(true);

        /*WritableFont wf2 = new WritableFont(WritableFont.createFont("微软雅黑"), 10, WritableFont.NO_BOLD, false);
        WritableCellFormat wcf_content = new WritableCellFormat(wf2);
        wcf_content.setWrap(true); //自动换行
        wcf_content.setAlignment(Alignment.CENTRE);//水平居中
        wcf_content.setVerticalAlignment(VerticalAlignment.CENTRE);//垂直居中*/

        WritableWorkbook wwb = Workbook.createWorkbook(xlsFile, wbs);
        WritableSheet ws = wwb.createSheet("data1", 0);
        ws.mergeCells(0, 0, 1, 0);
        Label label = new Label(0, 0, content);
        ws.addCell(label);
        wwb.write();
        wwb.close();
    }

    public static  void read(String path) throws Exception{
        File xlsFile = new File(path);
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        Sheet sheet = workbook.getSheet(0);
        Cell cell = sheet.getCell(0, 0);
        String contents = cell.getContents();
        System.out.println("===:"+contents.length());
        System.out.println(contents);
    }
}
