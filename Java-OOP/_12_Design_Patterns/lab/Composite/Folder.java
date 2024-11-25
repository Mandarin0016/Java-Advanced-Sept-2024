package Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {

    private List<FileSystemComponent> components;

    public Folder() {
        this.components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        this.components.add(component);
    }

    @Override
    public int getSize() {

        int size = 0;
        for (FileSystemComponent component : components) {
            size += component.getSize();
        }
        return size;
    }
}
