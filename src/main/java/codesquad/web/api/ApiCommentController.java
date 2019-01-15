package codesquad.web.api;

import codesquad.domain.issue.Comment;
import codesquad.domain.user.User;
import codesquad.security.LoginUser;
import codesquad.service.IssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/issues/{issueId}/comments")
public class ApiCommentController {

    private static final Logger log = LoggerFactory.getLogger(ApiCommentController.class);

//    @Resource(name = "issueService")
//    private IssueService issueService;      //데브툴스로 서버 재시작하면, Consider defining a bean named 'issueService' in your configuration. 에러 뜸 (최초 서버 실행에는 안뜨고 잘 작동함 왜냐)

    @Autowired
    private IssueService issueService;

    @PostMapping("")
    public ResponseEntity create(@LoginUser User loginUser, @PathVariable long issueId, @Valid @RequestBody Comment comment) {
        log.debug("create 접근!!!!!!!!!!!!!!!!!!!!!!");
        issueService.addComment(loginUser, issueId, comment); //얘는 직접적으로 commentRepository.save를 안해주는데?? 디비에 들어가나?
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(String.format("/api/issues/%d", issueId)));
        return new ResponseEntity<Comment>(comment, headers, HttpStatus.CREATED);
    }
}
