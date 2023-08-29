package ed.githubrepositorylistapi.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RepositoryDto {

    String name;
    String ownerLogin;
    List<Branch> branches;
}
