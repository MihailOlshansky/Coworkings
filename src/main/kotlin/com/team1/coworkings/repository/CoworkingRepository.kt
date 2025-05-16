package com.team1.coworkings.repository

import com.team1.coworkings.entity.Coworking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CoworkingRepository : JpaRepository<Coworking, Long> {

    @Query("select c " +
            "from Coworking c " +
            "where (:labelMask is null or c.label ilike :labelMask) " +
            "and (:address is null or c.address = :address) " +
            "and (:capacity is null or c.capacity >= :capacity) " +
            "and (:openFrom is null or c.openFrom <= :openFrom) " +
            "and (:openTo is null or c.openTo >= :openTo)")
    fun findByFilters(
        @Param("labelMask") labelMask: String?,
        @Param("address") address: String?,
        @Param("capacity") capacity: Int?,
        @Param("openFrom") openFrom: String?,
        @Param("openTo") openTo: String?
    ): List<Coworking>
}