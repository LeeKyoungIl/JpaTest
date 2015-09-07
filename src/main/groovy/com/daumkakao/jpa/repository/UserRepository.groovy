package com.daumkakao.jpa.repository

import com.daumkakao.jpa.model.Member
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by kellin on 9/7/15.
 */
interface UserRepository extends JpaRepository<Member, Integer> {
}
