package org.example;

import org.example.component.Column;
import org.example.component.Row;
import org.example.component.Table;
import org.example.component.column.CharColumn;
import org.example.component.column.ColumnType;
import org.example.component.column.IntegerColumn;
import org.example.component.column.MoneyColumn;
import org.example.component.column.MoneyInvlColumn;
import org.example.component.column.RealColumn;
import org.example.component.column.StringColumn;

public class DBManager {

  private static DBManager instance;

  private DBManager() {
  }

  public static DBManager getInstance() {
    if (instance == null) {
      instance = new DBManager();
    }
    return instance;
  }

  public static Table table;

  public static void populateTable() {
    table = new Table("testTable");
    table.addColumn(new IntegerColumn("column1"));
    table.addColumn(new RealColumn("column2"));
    table.addColumn(new StringColumn("column3"));
    table.addColumn(new CharColumn("column4"));
    table.addColumn(new MoneyColumn("column5"));
    table.addColumn(new MoneyInvlColumn("column6","0","1000"));
    Row row1 = new Row();
    row1.values.add("10");
    row1.values.add("10.0");
    row1.values.add("10");
    row1.values.add("1");
    row1.values.add("10.00");
    row1.values.add("10.00");
    table.addRow(row1);
    Row row2 = new Row();
    row2.values.add("15");
    row2.values.add("15.0");
    row2.values.add("15");
    row2.values.add("3");
    row2.values.add("15.00");
    row2.values.add("15.00");
    table.addRow(row2);
    Row row3 = new Row();
    row3.values.add("10");
    row3.values.add("10.0");
    row3.values.add("10");
    row3.values.add("1");
    row3.values.add("10.00");
    row3.values.add("10.00");
    table.addRow(row3);
  }

  public static void deleteRow(int rowIndex){

    if (rowIndex != -1) {

      table.deleteRow(rowIndex);
    }
  }

  public static void deleteDuplicateRows() {
    int i = 0;
    boolean flag = true;
    while(i<table.rows.size()){
      flag = true;
      for (int j = i+1; j < table.rows.size(); j++) {
        if (table.rows.get(i).values.equals(table.rows.get(j).values)) {
          deleteRow(i);
          flag = false;
          break;
        }
      }
      if (flag){
        i++;
      }
    }
  }
}
