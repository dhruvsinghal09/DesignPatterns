package main.java.LLD.FileSearchFilter.services.strategy;

import main.java.LLD.FileSearchFilter.File;

public interface Filter {

    boolean apply(File file);
}
