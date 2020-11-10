package ru.mtuci.labaapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mtuci.apilab.model.Individual;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface IndividualRepository extends JpaRepository <Individual,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Individual p WHERE p.id=:id")
    int delete(@Param("id") Long id );

}
