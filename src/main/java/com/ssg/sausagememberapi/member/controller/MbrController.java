package com.ssg.sausagememberapi.member.controller;

import com.ssg.sausagememberapi.common.dto.ErrorResponse;
import com.ssg.sausagememberapi.common.dto.SuccessResponse;
import com.ssg.sausagememberapi.common.success.SuccessCode;
import com.ssg.sausagememberapi.member.dto.request.MbrLonginRequest;
import com.ssg.sausagememberapi.member.dto.response.MbrFindResponse;
import com.ssg.sausagememberapi.member.dto.response.MbrLoginResponse;
import com.ssg.sausagememberapi.member.service.MbrService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Member", description = "멤버")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MbrController {

    private final MbrService mbrService;

    @Operation(summary = "멤버 조회", responses = {
            @ApiResponse(responseCode = "200", description = "멤버 조회 성공"),
            @ApiResponse(responseCode = "404", description = "일치하는 멤버 ID가 존재하지 않습니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/member/{memberId}")
    public ResponseEntity<SuccessResponse<MbrFindResponse>> findById(@PathVariable @Valid Long memberId) {
        return SuccessResponse.success(SuccessCode.OK_SUCCESS, mbrService.findMbrById(memberId));
    }

    @Operation(summary = "멤버 로그인", responses = {
            @ApiResponse(responseCode = "201", description = "로그인 성공입니다."),
            @ApiResponse(responseCode = "401", description = "비밀번호 불일치 401 에러입니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "일치하는 멤버 로그인 ID가 존재하지 않습니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PostMapping("/auth/login")
    public ResponseEntity<SuccessResponse<MbrLoginResponse>> login(@RequestBody @Valid MbrLonginRequest request) {
        return SuccessResponse.success(SuccessCode.LOGIN_SUCCESS, mbrService.login(request));
    }
}
