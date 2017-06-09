package com.gua.spring.web.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 类StockExcelStoreService.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年4月10日 下午7:54:41
 */
@Service("stockExcelStoreService")
public class StockExcelStoreService implements StoreService<List<String>> {

    private final static Logger logger = LoggerFactory.getLogger(StockExcelStoreService.class);

    @Override
    public boolean store(List<List<String>> dataList) {
        if (CollectionUtils.isEmpty(dataList)) {
            return false;
        }

        boolean isStoreSucess = false;
        try {
            // 创建工作薄
            @SuppressWarnings("resource")
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 创建工作表
            HSSFSheet sheet = workbook.createSheet("sheet1");

            for (int row = 0; row < dataList.size(); row++) {
                List<String> datas = dataList.get(row);
                HSSFRow rows = sheet.createRow(row);
                for (int col = 0; col < datas.size(); col++) {
                    // 向工作表中添加数据
                    rows.createCell(col).setCellValue(datas.get(col));
                }
            }

            File xlsFile = new File("stocksExcel.xls");
            FileOutputStream xlsStream = new FileOutputStream(xlsFile);
            workbook.write(xlsStream);
            isStoreSucess = true;
        } catch (IOException e) {
            logger.error("store failed!");
        }

        return isStoreSucess;
    }

}
