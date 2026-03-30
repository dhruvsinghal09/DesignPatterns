package main.java.LLD.FileSearchFilter.services.strategy.impl;

import main.java.LLD.FileSearchFilter.File;
import main.java.LLD.FileSearchFilter.services.strategy.Filter;

public class SizeFilter implements Filter {

    private int fileSize;

    public SizeFilter(int fileSize){
        this.fileSize=fileSize;
    }

    @Override
    public boolean apply(File file) {
        return file.getSize()==fileSize;
    }
}
