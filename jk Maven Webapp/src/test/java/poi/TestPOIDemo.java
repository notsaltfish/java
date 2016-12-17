package poi;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;


public class TestPOIDemo {
	@Test
	public void HSSF() throws IOException{
		//1.创建工作簿
		Workbook wb = new HSSFWorkbook();
		//2.创建表
		Sheet sh1 = wb.createSheet();
		//3.创建行
		Row row1 = sh1.createRow(4);
		//4.创建单元格
		Cell cell1 = row1.createCell(4);
		cell1.setCellValue("i m ready for what will happen in the future");
		
		//5.创建样式
		CellStyle cStyle = wb.createCellStyle();
		//6.创建字体
		Font font = wb.createFont();
		font.setFontName("微软雅黑");
		font.setFontHeightInPoints((short)(16));
		cStyle.setFont(font);
		cell1.setCellStyle(cStyle);
		
		Row row2 = sh1.createRow(5);
		Cell cell2 = row2.createCell(5);
		cell2.setCellValue("even the something i most love in the past would hurt me ");
		cStyle = wb.createCellStyle();
		font = wb.createFont();
		font.setFontName("微软雅黑");
		font.setFontHeightInPoints((short)10);
		cell2.setCellStyle(cStyle);
		
		OutputStream out = new FileOutputStream(new File("D://TEST.xls"));
		wb.write(out);
		out.close();
		
		
	}
	
	
}
