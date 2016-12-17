package poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chen.jk.service.OutProductService;
import com.chen.jk.vo.OutProductVO;

public class TestMyPOI {

	@Test
	public void testMyPOI() throws FileNotFoundException{
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("beans.xml");
		OutProductService opc = (OutProductService)cpx.getBean("outProductServiceImpl");
		print("2011-12",opc);
		
	}
	
	public void print(String outPutTime,OutProductService outProductService) throws FileNotFoundException{
		List<OutProductVO> data = outProductService.find(outPutTime);
		Workbook wb = new HSSFWorkbook();
		Sheet sh = wb.createSheet();
		Row row = null;
		Cell cell = null;
		CellStyle cs = wb.createCellStyle();
		Font fs = wb.createFont();
		sh.addMergedRegion(new CellRangeAddress(0,0,1,8));
		
		OutProductVO outProduct =null;
		String[] titles = {"客户","订单号","货号","数量","工厂","工厂交期","船期","条款"};
		int colNum = 1;
		int rowNum = 0;
		row = sh.createRow(rowNum++);
		cell  = row.createCell(1);
		cell.setCellValue(outPutTime.replace("-", "年").replace("-0", "年")+"月出货表");
		cell.setCellStyle(bigTitleStyle(wb));
		System.out.println("sas");
		sh.setColumnWidth(0, 1*256);
		sh.setColumnWidth(1, 16*256);
		sh.setColumnWidth(2, 16*256);
		sh.setColumnWidth(3, 16*256);
		sh.setColumnWidth(4, 16*256);
		sh.setColumnWidth(5, 16*256);
		sh.setColumnWidth(6, 16*256);
		sh.setColumnWidth(7, 16*256);
		
		row = sh.createRow(rowNum++);
		CellStyle titleCs = textStyle(wb);
		for(int i=0;i<titles.length;i++){
			cell = row.createCell(colNum++);
			cell.setCellValue(titles[i]);
			cell.setCellStyle(titleCs);
		}
		CellStyle textCs = textStyle(wb);
		for(int i=0;i<data.size();i++){
			colNum = 1;
			outProduct = data.get(i);
			row = sh.createRow(rowNum++);
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getCustomName());
			cell.setCellStyle(textCs);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getContractNo());
			cell.setCellStyle(textCs);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getProductNo());
			cell.setCellStyle(textCs);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getcNumber());
			cell.setCellStyle(textCs);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getFactoryName());
			cell.setCellStyle(textCs);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getDeliveryPeriod());
			cell.setCellStyle(textCs);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getShipTime());
			cell.setCellStyle(textCs);
			
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getTradeTerms());
			cell.setCellStyle(textCs);
			
		}
		OutputStream out = new FileOutputStream(new File("D://outProduct.xls"));
		try {
			wb.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CellStyle bigTitleStyle(Workbook workBook){
		CellStyle cs = workBook.createCellStyle();
		Font font  = workBook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)16);
		cs.setFont(font);
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cs.setAlignment(CellStyle.ALIGN_CENTER);
		return cs;
	}
	
	public CellStyle titleStyle(Workbook workBook){
		CellStyle cs = workBook.createCellStyle();
		Font font  = workBook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setFontName("黑体");
		font.setFontHeightInPoints((short)12);
		cs.setFont(font);
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cs.setAlignment(CellStyle.ALIGN_CENTER);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		return cs;
	}
	
	public CellStyle textStyle(Workbook workBook){
		CellStyle cs = workBook.createCellStyle();
		Font font  = workBook.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short)10);
		cs.setFont(font);
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cs.setAlignment(CellStyle.ALIGN_LEFT);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		return cs;
	}
	
	
}
