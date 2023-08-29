# GitHub Repository List API

This api is designed to allow users to get the list of non-fork repositories with additional information about the name of repository, its owner's login and the list of branches with name and last commit sha.
## API Endpoint
The API endpoint to retrieve the list of repositories is:
```
GET /api/github/{username}/repositories
```
API will return information in format:
```
[
    {
        "name": ${repository name},
        "ownerLogin": ${repository name},
        "branches": [
            {
                "name": ${branch name},
                "lastCommitSha": ${sha}
            },
            {
                //next branch
            }
        ]
    },
    {
        //next repository
    }
```

## Request Headers
The following request header is required:
```
Accept: application/json
```
Only JSON responses are supported.

##Error handling

**・404 - User not found**

If the provided GitHub user does not exist, the API will return a response with a 404 error in the following format:
```
{
    "status": 404,
    "message": "User not found"
}
```

**・406 - Not Acceptable**

If the request header Accept is not set to application/json, the API will return a response with a 406 error in the following format:

```
{
    "status": 406,
    "message": "Wrong Accept header"
}
```