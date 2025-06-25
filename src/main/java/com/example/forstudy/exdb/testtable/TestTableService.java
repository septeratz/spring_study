package com.example.forstudy.exdb.testtable;

import com.example.forstudy.exception.testtable.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
