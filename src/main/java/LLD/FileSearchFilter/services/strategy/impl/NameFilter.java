package main.java.LLD.FileSearchFilter.services.strategy.impl;

import main.java.LLD.FileSearchFilter.File;
import main.java.LLD.FileSearchFilter.services.strategy.Filter;

public class NameFilter implements Filter {

    private String searchName;

    public NameFilter(String searchName){
        this.searchName=searchName;
    }
    @Override
    public boolean apply(File file) {
        return file.getName().equalsIgnoreCase(searchName);
    }
}
