package com.daumkakao.jpa.model

import javax.persistence.MappedSuperclass
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * Created by kellin on 9/9/15.
 *
 * 모든 테이블에서 사용될 공통 필드.
 *  - 등록일
 *  - 마지막 수정일
 */
@MappedSuperclass
class BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    Date createDate

    @Temporal(TemporalType.TIMESTAMP)
    Date lastModifiedDate
}
