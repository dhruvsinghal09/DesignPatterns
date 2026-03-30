package main.java.LLD.FileSearchFilter;

public class File {

    private String name;
    private int size;

    public File(String name,int size){
        this.name=name;
        this.size=size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
