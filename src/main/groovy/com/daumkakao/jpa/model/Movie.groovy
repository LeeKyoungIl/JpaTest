package com.daumkakao.jpa.model

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

/**
 * Created by kellin on 9/9/15.
 */
@Entity
// 구분자 값을 지정한다.
@DiscriminatorValue("M")
class Movie extends Item{

    String director
    String actor
}
