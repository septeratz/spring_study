package com.example.forstudy.exdb.testtable;

import lombok.Data;
import java.time.LocalDateTime;

public record TestTableReqDTO(
        String name,
        int age,
        String memo,
        LocalDateTime date
) {}