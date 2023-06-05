package com.smu.smuenip.application.rank;

import com.smu.smuenip.domain.dto.RankDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "유저 랭킹")
public interface RankControllerSwagger {

    @ApiOperation("유저 랭킹 리스트")
    public List<RankDto> getRanking(@RequestParam(value = "value") String value);

}
