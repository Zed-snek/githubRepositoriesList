package ed.githubrepositorylistapi.dto.githubApi;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GithubBranch {

    String name;
    GithubCommit commit;

}
