package sbs.rosedev.springFirst.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sbs.rosedev.springFirst.entity.InvestorProfile;

public interface InvestorProfileRepository
        extends JpaRepository<InvestorProfile, Long> {
    Optional<InvestorProfile> findByInvestorId(String investorId);
}
