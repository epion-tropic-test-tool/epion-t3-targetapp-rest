package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    private OffsetDateTime start;

    private OffsetDateTime due;

    private OffsetDateTime actualStart;

    private OffsetDateTime actualEnd;

    private Integer status;

    private Integer priority;

    private List<String> tags;
}
