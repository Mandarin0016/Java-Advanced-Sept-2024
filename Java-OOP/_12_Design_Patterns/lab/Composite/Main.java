package Composite;

public class Main {

    public static void main(String[] args) {

        File fileA = new File();
        File fileB = new File();
        File fileC = new File();

        Folder root = new Folder();
        Folder folderB = new Folder();

        folderB.addComponent(fileB);
        folderB.addComponent(fileC);

        root.addComponent(fileA);
        root.addComponent(folderB);

        System.out.println(root.getSize());
    }
}
