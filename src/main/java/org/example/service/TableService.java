package org.example.service;

import java.util.ArrayList;
import java.util.List;
import org.example.DBManager;
import org.example.component.Table;
import org.springframework.stereotype.Service;

@Service
public class TableService {

  public List<Table> getTables(){
    List<Table> list = new ArrayList<>();
    list.add(DBManager.table);
    return list;
  }
}
