package com.cloud.ws.Repository;

import com.cloud.ws.Model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommissionRepository extends JpaRepository<Commission, Long> {

    @Query("SELECT commision from Commission commision order by commision.idCommission desc limit 1")
    public Commission getCommissionActuel();
}
