package main.java.LLD.FileSearchFilter;

import main.java.LLD.FileSearchFilter.services.strategy.Filter;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private List<File> files;

    public Directory(){
        this.files=new ArrayList<>();
    }

    public void addFiles(File file){
        files.add(file);
    }

    public boolean removeFile(File file){
        return files.remove(file);
    }

    public void listAllFiles(){
        for(File file:files){
            System.out.print("FileName: " + file.getName() + " ");
        }
    }

    public List<File> searchDirectory(Filter filter){
        List<File> fileList = new ArrayList<>();
        for(File file:files){
            if(filter.apply(file))
                fileList.add(file);
        }
        return fileList;
    }
}
