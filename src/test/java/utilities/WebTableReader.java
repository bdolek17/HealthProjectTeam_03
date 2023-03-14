package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableReader {

    private WebDriver driver;
    private By tableLocator;
    private Boolean isfirstRowIncludesHeader=false;  //if web table does not have thead or tbody tag
    private Boolean hasTHEADTag=false;
    private By locatorTHeadRows;

    private Boolean hasTBODYTag=false;
    private By locatorTBodyRows;
    private WebElement webTable;

    private WebElement headerRow;
    private List<WebElement> headerColumns;

    private List<WebElement> bodyRows;
    private int columnsCount=0;
    private int rowsCount=0;


    public void setDriver(WebDriver driver) { this.driver = driver;  }


    public void setTableLocator(By tableLocator) { this.tableLocator = tableLocator; }

    public void isfirstRowIncludesHeader(Boolean isfirstRowIncludesHeader) { this.isfirstRowIncludesHeader = isfirstRowIncludesHeader;   }

    public void hasTHEADTag(Boolean hasTHEADTag) { this.hasTHEADTag = hasTHEADTag;   }

    public void setLocatorTHeadRows(By locatorTHeadRows) { this.locatorTHeadRows = locatorTHeadRows; }

    public void hasTBODYTag(Boolean hasTBODYTag) { this.hasTBODYTag = hasTBODYTag; }

    public void setLocatorTBodyRows(By locatorTBodyRows) { this.locatorTBodyRows = locatorTBodyRows;  }

    public WebElement getWebTable() { return webTable;  }

    public WebElement getHeaderRow() { return headerRow; }

    public List<WebElement> getHeaderColumns() { return headerColumns; }

    public List<WebElement> getBodyRows() { return bodyRows; }

    public int getColumnsCount() {  return columnsCount; }

    public int getRowsCount() { return rowsCount; }


    public WebTableReader(WebDriver driver) { this.driver=driver;}

    public WebTableReader(By tableLocator,WebDriver driver) {
        this.tableLocator = tableLocator;
        this.driver=driver;
    }

    public WebTableReader(By tableLocator, Boolean isfirstRowIncludesHeader) {
        this.tableLocator = tableLocator;
        this.isfirstRowIncludesHeader = isfirstRowIncludesHeader;
    }


    public void loadWebTable() {
        if (tableLocator != null) {
            webTable = driver.findElement(tableLocator);
        }
    }

    public List<List<WebElement>> toLists() {
        List<List<WebElement>> data=new ArrayList<>();
        List<WebElement> temp=null;
        List<WebElement> rowColumns=null;

        if(isfirstRowIncludesHeader && !hasTHEADTag && !hasTBODYTag){
            webTable = driver.findElement(tableLocator);
            List<WebElement> dataRows=webTable.findElements(By.tagName("tr"));
            headerRow=dataRows.get(0);
            bodyRows=dataRows.stream().skip(1).collect(Collectors.toList());
        }
        else {
            //suppose that it has thead and tbody
            headerRow=driver.findElements(locatorTHeadRows).get(0);
            bodyRows=driver.findElements(locatorTBodyRows);
        }

        //Header
        rowColumns=(hasTHEADTag)?headerRow.findElements(By.tagName("th")):headerRow.findElements(By.tagName("td"));
        data.add(rowColumns); //HEADER
        columnsCount=rowColumns.size();
        //Body
        for(WebElement row:bodyRows){
            rowColumns =row.findElements(By.tagName("td"));
            data.add(rowColumns); //BODY
        }

        rowsCount=(isfirstRowIncludesHeader)?(data.size()-1): data.size();
        return  data;
    }


}