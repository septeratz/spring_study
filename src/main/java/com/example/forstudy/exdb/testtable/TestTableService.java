package com.example.forstudy.exdb.testtable;

import com.example.forstudy.exception.testtable.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TestTableService {
    private final TestTableRepository testTableRepository;

    public TestTableResDTO showTable(Long id) {
        TestTable testTable = testTableRepository.findById(id).orElseThrow(() ->
                    new NotFoundUserException("존재하지 않는 사용자입니다.")
                );
        return TestTableResDTO.fromTable(testTable);
    }

    public TestTableResDTO addTable(TestTableReqDTO dto) {
        TestTable testTable =  new TestTable();
        testTable.setName(dto.name());
        testTable.setAge(dto.age());
        testTable.setMemo(dto.memo());
        LocalDateTime date = LocalDateTime.now();
        testTable.setDate(date);

        return TestTableResDTO.fromTable(testTableRepository.save(testTable));
    }
}
