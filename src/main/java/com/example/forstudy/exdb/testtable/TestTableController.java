package com.example.forstudy.exdb.testtable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TestTableController {
    private final TestTableService testTableService;
    public TestTableController(TestTableService testTableService) {
        this.testTableService = testTableService;
    }
    @GetMapping("/testTable/{testTableId}")
    public ResponseEntity<TestTableResDTO> getTestTable(@PathVariable Long testTableId) {
        TestTableResDTO testTableResDTO = testTableService.showTable(testTableId);

        return new ResponseEntity<>(testTableResDTO, HttpStatus.OK);
    }
}
