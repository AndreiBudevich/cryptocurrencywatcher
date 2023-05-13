package com.cryptocurrencywatcher.repository.usercryptocurrency;

import com.cryptocurrencywatcher.model.UserCryptocurrency;
import com.cryptocurrencywatcher.repository.CommonCrudRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserCryptocurrencyCrudRepository extends CommonCrudRepository<UserCryptocurrency> {

    @EntityGraph(attributePaths = {"user", "cryptocurrency"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT uC FROM UserCryptocurrency uC")
    List<UserCryptocurrency> getAllWithUserAndCryptocurrency();
}
