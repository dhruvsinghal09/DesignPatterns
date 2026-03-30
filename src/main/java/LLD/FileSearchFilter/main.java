package main.java.LLD.FileSearchFilter;

import main.java.LLD.FileSearchFilter.services.strategy.impl.*;

import java.util.List;

public class main {

    public static void main(String[] args){
        Directory directory = new Directory();
        directory.addFiles(new File("f1",30));
        directory.addFiles(new File("f2",40));
        directory.addFiles(new File("f3",50));
        directory.addFiles(new File("f4",60));
        directory.addFiles(new File("f5",70));
        directory.addFiles(new File("f2",70));
        directory.addFiles(new File("f6",70));
        directory.addFiles(new File("Mayank",70));

        directory.listAllFiles();

        List<File> fileList = directory.searchDirectory(new NameFilter("f1"));
        System.out.println(fileList);

        List<File> fileList1 = directory.searchDirectory(new SizeFilter(50));
        System.out.println(fileList1);

        List<File> fileList2 = directory.searchDirectory(new AndFilter(new NameFilter("f2"), new SizeFilter(40)));
        System.out.println(fileList2);

        List<File> fileList3 = directory.searchDirectory(new OrFilter(new NameFilter("f2"), new SizeFilter(70)));
        System.out.println(fileList3);

        List<File> fileList4 = directory.searchDirectory(new FuzzySearch("an"));
        System.out.println(fileList4);

    }
}
