package com.daumkakao.jpa.bo

import com.daumkakao.jpa.model.Member
import com.daumkakao.jpa.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by kellin on 9/7/15.
 */
@Service
class HelloWorldBO {

    @Autowired
    private UserRepository userRepository;

    boolean insertUser () {
        Member user = new Member();
        user.name = URLEncoder.encode("개똥이", "UTF-8")

        userRepository.save(user)

        true
    }

    String getUser () {
        Member user = userRepository.findOne(1L)

        user.name
    }
}
