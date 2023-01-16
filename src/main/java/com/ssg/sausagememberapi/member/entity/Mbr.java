package com.ssg.sausagememberapi.member.entity;


import com.ssg.sausagememberapi.common.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "MBR")
@Getter
@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PUBLIC)
public class Mbr extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MBR_ID")
    private Long mbrId;

    @Column(name = "MBR_LOGIN_ID", nullable = false)
    private String mbrLoginId;

    @Column(name = "MBR_NM", nullable = false)
    private String mbrNm;

    @Column(name = "MBR_PWD", nullable = false)
    private String mbrPwd;

    @Column(name = "MBR_HPNO", nullable = false)
    private String mbrHpno;

    @Column(name = "MBR_IMG_URL", nullable = false)
    private String mbrImgUrl;
}