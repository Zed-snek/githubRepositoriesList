package ed.githubrepositorylistapi.service;

import ed.githubrepositorylistapi.dto.Branch;
import ed.githubrepositorylistapi.dto.RepositoryDto;
import ed.githubrepositorylistapi.dto.githubApi.GithubBranch;
import ed.githubrepositorylistapi.dto.githubApi.GithubRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class GithubService {

    public ArrayList<RepositoryDto> getRepositoriesByUsername(String username) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GithubRepository[]> response = restTemplate.getForEntity(
                "https://api.github.com/users/" + username + "/repos",
                GithubRepository[].class
        );

        ArrayList<RepositoryDto> list = new ArrayList<>();

        GithubRepository[] repositories = response.getBody(); //todo check if isn't fork
        if (repositories != null) {
            for (GithubRepository r : repositories) {
                if (!r.isFork()) {
                    list.add(RepositoryDto.builder()
                            .name(r.getName())
                            .ownerLogin(r.getOwner().getLogin())
                            .branches(getBranchesByUserAndRepository(username, r.getName()))
                            .build());
                }
            }
        }

        return list;
    }

    public ArrayList<Branch> getBranchesByUserAndRepository(String username, String repository) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<GithubBranch[]> response = template.getForEntity(
                "https://api.github.com/repos/" + username +"/" + repository + "/branches",
                GithubBranch[].class
        );
        ArrayList<Branch> list = new ArrayList<>();

        var body = response.getBody();
        if (body != null) {
            for (GithubBranch gb : body) {
                list.add(Branch.builder()
                        .name(gb.getName())
                        .lastCommitSha(gb.getCommit().getSha())
                        .build());
            }
        }

        return list;
    }

}
