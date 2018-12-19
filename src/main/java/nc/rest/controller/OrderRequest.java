package nc.rest.controller;

import lombok.Getter;
import lombok.Setter;
import nc.rest.model.Point;

import javax.validation.constraints.NotNull;

public class OrderRequest {

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @NotNull
    private Point startPoint;

    @Getter
    @Setter
    @NotNull
    private Point endPoint;

    @Getter
    @Setter
    @NotNull
    private String status;
}
