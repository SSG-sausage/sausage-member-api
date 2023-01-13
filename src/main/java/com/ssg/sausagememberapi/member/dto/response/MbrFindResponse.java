package com.ssg.sausagememberapi.member.dto.response;

import com.ssg.sausagememberapi.member.entity.Mbr;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class MbrFindResponse {

    @Schema(description = "멤버 ID")
    private Long mbrId;

    @Schema(description = "멤버 로그인 ID")
    private String mbrLoginId;

    @Schema(description = "멤버 이름")
    private String mbrNm;

    @Schema(description = "멤버 이미지 Url")
    private String mbrImgUrl;

    @Schema(description = "멤버 휴대폰 번호")
    private String mbrHpno;

    public static MbrFindResponse of(Mbr mbr) {
        return MbrFindResponse.builder()
                .mbrId(mbr.getId())
                .mbrLoginId(mbr.getMbrLoginId())
                .mbrNm(mbr.getMbrNm())
                .mbrImgUrl(mbr.getMbrImgUrl())
                .mbrHpno(mbr.getMbrHpno())
                .build();
    }
}
