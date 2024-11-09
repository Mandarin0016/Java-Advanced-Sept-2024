package solid;

import java.util.List;

public interface Calculator<T extends Product> {

    double sum(List<T> products);

    double average(List<T> products);
}
