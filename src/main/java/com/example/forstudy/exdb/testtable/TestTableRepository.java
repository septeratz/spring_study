package com.example.forstudy.exdb.testtable;

import com.example.forstudy.exdb.testtable.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTableRepository extends JpaRepository<TestTable, Long>{


}