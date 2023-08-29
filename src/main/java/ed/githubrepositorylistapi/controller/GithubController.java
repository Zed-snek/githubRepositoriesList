package ed.githubrepositorylistapi.controller;

import ed.githubrepositorylistapi.dto.RepositoryDto;
import ed.githubrepositorylistapi.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    @GetMapping(value = "/{username}/repositories", headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RepositoryDto> getRepositoriesByUsername(@PathVariable String username) {

        return githubService.getRepositoriesByUsername(username);
    }



}
