package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientWebTable {
    private WebDriver driver;
    private By tableLocator;
    private By locatorTHeadRows;
    private By locatorTBodyRows;
    private WebElement webTable;

    private WebElement headerRow;
    private List<String> headerRowTexts=null;

    private List<WebElement> bodyRows;
    private int columnsCount=0;
    private int rowsCount=0;
    private List<WebElement> rowColumns;

    private Map<String,Map<String,WebElement>> patientData=new HashMap<>();  //Map<patientID,Map<ColumnName,WebElement>>

    public Map<String, Map<String, WebElement>> getPatientData() {
        return patientData;
    }

    public PatientWebTable(By locatorTHeadRows, By locatorTBodyRows) {
        this.locatorTHeadRows = locatorTHeadRows;
        this.locatorTBodyRows = locatorTBodyRows;
        this.driver=Driver.getDriver();
    }

    private void setHeaderRowTexts(){
        headerRow=driver.findElements(locatorTHeadRows).get(0);
        rowColumns=headerRow.findElements(By.tagName("th"));
        headerRowTexts=new ArrayList<>();
        for(WebElement col:rowColumns){
            headerRowTexts.add((col.getText().trim().length()>0)?col.getText():"buttons");
        }
    }

    public void loadCurrentPage(List<WebElement> bRows) {
        if(headerRowTexts==null) setHeaderRowTexts();

        bodyRows= (bRows==null)?driver.findElements(locatorTBodyRows):bRows;

        Map<String,WebElement> tableData;
        for(WebElement row:bodyRows){
            rowColumns =row.findElements(By.tagName("td"));
            tableData=new HashMap<>();
            int colIndex=0;
            for(WebElement col:rowColumns){
                tableData.put(headerRowTexts.get(colIndex),col);
                colIndex++;
            }
            patientData.put(rowColumns.get(0).getText(),tableData);
        }
    }

    public void loadAllPages(List<List<WebElement>> allPagesBodyRows) {
        for(List<WebElement> singlePageBodyRows:allPagesBodyRows){
            loadCurrentPage(singlePageBodyRows);
        }
    }

}
