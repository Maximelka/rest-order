package nc.rest.model;

import lombok.Getter;
import lombok.Setter;

public class Order {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Point startPoint;

    @Getter
    @Setter
    private Point endPoint;

    @Getter
    @Setter
    private String status;

}
