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
public class MbrLoginResponse {

    @Schema(description = "멤버 ID")
    private Long mbrId;

    @Schema(description = "멤버 로그인 ID")
    private String mbrLoginId;

    @Schema(description = "멤버 이름")
    private String mbrNm;

    @Schema(description = "멤버 이미지 Url")
    private String mbrImgUrl;

    public static MbrLoginResponse of(Mbr mbr) {
        return MbrLoginResponse.builder()
                .mbrId(mbr.getMbrId())
                .mbrLoginId(mbr.getMbrLoginId())
                .mbrNm(mbr.getMbrNm())
                .mbrImgUrl(mbr.getMbrImgUrl())
                .build();
    }
}
