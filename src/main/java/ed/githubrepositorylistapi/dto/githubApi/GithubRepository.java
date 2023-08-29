package ed.githubrepositorylistapi.dto.githubApi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class GithubRepository {

    String name;
    boolean fork;
    GithubOwner owner;

}
