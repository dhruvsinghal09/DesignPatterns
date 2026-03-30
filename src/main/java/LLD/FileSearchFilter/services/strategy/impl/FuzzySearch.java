package main.java.LLD.FileSearchFilter.services.strategy.impl;

import main.java.LLD.FileSearchFilter.File;
import main.java.LLD.FileSearchFilter.services.strategy.Filter;

public class FuzzySearch implements Filter {

    private String search;

    public FuzzySearch(String search){
        this.search=search;
    }

    @Override
    public boolean apply(File file) {
        return file.getName().contains(search);
    }
}
