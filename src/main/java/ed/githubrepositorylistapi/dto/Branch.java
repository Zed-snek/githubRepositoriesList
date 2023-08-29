package ed.githubrepositorylistapi.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Branch {

    String name;
    String lastCommitSha;

}
