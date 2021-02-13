package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.domain.ErrorResponse;
import io.pragra.learning.jpademo.domain.RefData;
import io.pragra.learning.jpademo.repo.RefDataRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="Ref")
public class RefController {
    @Autowired
    private RefDataRepo refDataRepo;
    @ApiResponses( {
            @ApiResponse(code=201,message="Created",response = Author.class),
            @ApiResponse(code=400, message="BadRequest", response= ErrorResponse.class)

    })

    @GetMapping("/api/ref")
    public List<RefData> getRefData(){
        return refDataRepo.findAll();
    }

}
