package com.ssg.sausagememberapi.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MbrLonginRequest {

    @NotBlank
    @Schema(description = "멤버 ID", requiredMode = RequiredMode.REQUIRED)
    private String mbrLoginId;

    @NotBlank
    @Schema(description = "멤버 PWD", requiredMode = RequiredMode.REQUIRED)
    private String mbrPwd;
}
