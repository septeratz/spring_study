package com.example.forstudy.exdb.testtable;

import java.time.LocalDateTime;

public record TestTableResDTO(Long id, String name, int age,
                              String memo, LocalDateTime date) {

    public static TestTableResDTO fromTable(TestTable t) {

        return new TestTableResDTO(t.getId(), t.getName(),
                t.getAge(), t.getMemo(), t.getDate());

    }
}
