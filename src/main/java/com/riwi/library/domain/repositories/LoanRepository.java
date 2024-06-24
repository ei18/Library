package com.riwi.library.domain.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.library.domain.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
    Long countByBookIdAndReservationDate(Long bookId, LocalDate reservationDate);

    List<Loan> findAllByUser_Id(Long userId);

    List<Loan> findAllByBook_Id(Long bookId);
}
