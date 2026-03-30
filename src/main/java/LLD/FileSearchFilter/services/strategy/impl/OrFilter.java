package main.java.LLD.FileSearchFilter.services.strategy.impl;

import main.java.LLD.FileSearchFilter.File;
import main.java.LLD.FileSearchFilter.services.strategy.Filter;

public class OrFilter implements Filter {

    private Filter f1;
    private Filter f2;

    public OrFilter(Filter f1,Filter f2){
        this.f1=f1;
        this.f2=f2;
    }


    @Override
    public boolean apply(File file) {
        return f1.apply(file) || f2.apply(file);
    }
}
