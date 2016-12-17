package com.chen.jk.controller.cargo.outproduct;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.jk.controller.BaseController;
import com.chen.jk.service.OutProductService;
import com.chen.jk.util.DownloadUtil;
import com.chen.jk.vo.OutProductVO;

@Controller
public class OutProductController extends BaseController{
	
	@Resource
	private OutProductService outProductService;
	
	@RequestMapping("/cargo/outproduct/toprint.action")
	public String toPrint(){
		
		return "/cargo/outproduct/jOutProduct.jsp";
	}
	
	
	/**
	 * 使用XSSF 该对象能够打印更大量的数据
	 * @param outPutTime
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/cargo/outproduct/print.action")
	public void printByXSSF(String outPutTime,HttpServletResponse response,HttpServletRequest request) throws IOException{
		String path = request.getSession().getServletContext().getRealPath("/")+"make/xlsprint/";
		
		InputStream is =  new FileInputStream(new File(path+"templateOfProduct.xlsx"));
		Workbook wb = new XSSFWorkbook(is);//不需要再new  Workbook 直接使用这个对象就可以
	    Sheet sh = wb.getSheetAt(0);
	    
       //获取大标题的风格
	    Row  rbigTitle= sh.getRow(0);
       Cell cbigTitle = rbigTitle.getCell(1);
       CellStyle csBigTitle = cbigTitle.getCellStyle();
      
       //获取每个列值的字体风格
       Row rText = sh.getRow(2);
       float height = rText.getHeightInPoints();
       Cell cText1 = rText.getCell(1);
       CellStyle csText1 = cText1.getCellStyle();
       
       Cell cText2 = rText.getCell(2);
       CellStyle csText2 = cText2.getCellStyle();
       Cell cText3 = rText.getCell(3);
       CellStyle csText3 = cText3.getCellStyle();
       Cell cText4 = rText.getCell(4);
       CellStyle csText4 = cText4.getCellStyle();
       Cell cText5 = rText.getCell(5);
       CellStyle csText5 = cText5.getCellStyle();
       Cell cText6 = rText.getCell(6);
       CellStyle csText6 = cText6.getCellStyle();
       Cell cText7 = rText.getCell(7);
       CellStyle csText7 = cText7.getCellStyle();
       Cell cText8 = rText.getCell(8);
       CellStyle csText8 = cText8.getCellStyle();
		
		
	    		
	    List<OutProductVO> data = outProductService.find(outPutTime);
		//Workbook wb = new HSSFWorkbook();
		//Sheet sh = wb.createSheet();
		Row row = null;
		Cell cell = null;
		
		OutProductVO outProduct =null;
		int colNum = 1;
		int rowNum = 1;
		row = sh.getRow(0);
		cell  = row.getCell(1);
		cell.setCellValue(outPutTime.replace("-", "年").replace("-0", "年")+"月出货表");
		rowNum++;//跳过静态表头
		
		
	
		for(int i=0;i<data.size();i++){
			colNum = 1;
			outProduct = data.get(i);
			row = sh.createRow(rowNum++);
			//row.setHeightInPoints(rText.getHeightInPoints());
			row.setHeightInPoints(height);
			//System.out.println(rText.getHeightInPoints());
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getCustomName());
			cell.setCellStyle(csText1);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getContractNo());
			cell.setCellStyle(csText2);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getProductNo());
			cell.setCellStyle(csText3);
			
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getcNumber());
			cell.setCellStyle(csText4);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getFactoryName());
			cell.setCellStyle(csText5);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getDeliveryPeriod());
			cell.setCellStyle(csText6);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getShipTime());
			cell.setCellStyle(csText7);
			
			
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getTradeTerms());
			cell.setCellStyle(csText8);
			
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			wb.write(out);
			out.close();
			DownloadUtil du = new DownloadUtil();
			du.download(out, response, "productReport.xlsx");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 使用模板来打印
	 * @param outPutTime
	 * @throws IOException 
	 */
	//@RequestMapping("/cargo/outproduct/print.action")
	public void printByTemplate(String outPutTime,HttpServletResponse response,HttpServletRequest request) throws IOException{
		String path = request.getSession().getServletContext().getRealPath("/")+"make/xlsprint/";
		
		InputStream is =  new FileInputStream(new File(path+"templateOfProduct.xls"));
		Workbook wb = new HSSFWorkbook(is);//不需要再new  Workbook 直接使用这个对象就可以
	    Sheet sh = wb.getSheetAt(0);
	    
       //获取大标题的风格
	    Row  rbigTitle= sh.getRow(0);
       Cell cbigTitle = rbigTitle.getCell(1);
       CellStyle csBigTitle = cbigTitle.getCellStyle();
      
       //获取每个列值的字体风格
       Row rText = sh.getRow(2);
       Cell cText1 = rText.getCell(1);
       CellStyle csText1 = cText1.getCellStyle();
       Cell cText2 = rText.getCell(2);
       CellStyle csText2 = cText2.getCellStyle();
       Cell cText3 = rText.getCell(3);
       CellStyle csText3 = cText3.getCellStyle();
       Cell cText4 = rText.getCell(4);
       CellStyle csText4 = cText4.getCellStyle();
       Cell cText5 = rText.getCell(5);
       CellStyle csText5 = cText5.getCellStyle();
       Cell cText6 = rText.getCell(6);
       CellStyle csText6 = cText6.getCellStyle();
       Cell cText7 = rText.getCell(7);
       CellStyle csText7 = cText7.getCellStyle();
       Cell cText8 = rText.getCell(8);
       CellStyle csText8 = cText8.getCellStyle();
		
		
	    		
	    List<OutProductVO> data = outProductService.find(outPutTime);
		//Workbook wb = new HSSFWorkbook();
		//Sheet sh = wb.createSheet();
		Row row = null;
		Cell cell = null;
		
		OutProductVO outProduct =null;
		int colNum = 1;
		int rowNum = 0;
		row = sh.createRow(rowNum++);
		row.setHeight(rbigTitle.getHeight());
		cell  = row.createCell(1);
		cell.setCellValue(outPutTime.replace("-", "年").replace("-0", "年")+"月出货表");
		cell.setCellStyle(csBigTitle);
		rowNum++;//跳过静态表头
		
		
	
		for(int i=0;i<data.size();i++){
			colNum = 1;
			outProduct = data.get(i);
			row = sh.createRow(rowNum++);
			row.setHeight(rText.getHeight());
			System.out.println("HSSF:"+rText.getHeightInPoints());
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getCustomName());
			cell.setCellStyle(csText1);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getContractNo());
			cell.setCellStyle(csText2);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getProductNo());
			cell.setCellStyle(csText3);
			
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getcNumber());
			cell.setCellStyle(csText4);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getFactoryName());
			cell.setCellStyle(csText5);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getDeliveryPeriod());
			cell.setCellStyle(csText6);
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getShipTime());
			cell.setCellStyle(csText7);
			
			
			
			cell = row.createCell(colNum++);
			cell .setCellValue(outProduct.getTradeTerms());
			cell.setCellStyle(csText8);
			
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			wb.write(out);
			out.close();
			DownloadUtil du = new DownloadUtil();
			du.download(out, response, "productReport.xls");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//@RequestMapping("/cargo/outproduct/print.action")
	public void print(String outPutTime,HttpServletResponse response) throws FileNotFoundException{
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
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			wb.write(out);
			out.close();
			DownloadUtil du = new DownloadUtil();
			du.download(out, response, "productReport.xls");
			
			
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
