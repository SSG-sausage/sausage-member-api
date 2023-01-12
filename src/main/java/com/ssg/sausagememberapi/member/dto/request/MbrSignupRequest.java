package com.ssg.sausagememberapi.member.dto.request;

import com.ssg.sausagememberapi.member.entity.Mbr;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MbrSignupRequest {

    @NotBlank
    @Schema(description = "멤버 ID", requiredMode = RequiredMode.REQUIRED)
    private String mbrLoginId;

    @NotBlank
    @Schema(description = "멤버 PWD", requiredMode = RequiredMode.REQUIRED)
    private String mbrPwd;

    @NotBlank
    @Schema(description = "멤버 이름", requiredMode = RequiredMode.REQUIRED)
    private String mbrNm;


    @Column(name = "멤버 휴대폰 번호", nullable = false)
    private String mbrHpno;

    @Column(name = "멤버 이미지 URL", nullable = false)
    private String mbrImgUrl;

    public Mbr toEntity() {
        return Mbr.builder()
                .mbrLoginId(mbrLoginId)
                .mbrNm(mbrNm)
                .mbrPwd(mbrPwd)
                .mbrHpno(mbrHpno)
                .mbrImgUrl(mbrImgUrl)
                .build();
    }
}
