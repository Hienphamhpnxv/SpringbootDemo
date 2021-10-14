package Controller;


import Repuest.JobRequest;
import Search.UserSearchH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping
public class UserSearch {
    @Autowired
    UserSearchH searcher;

    @GetMapping
    public ResponseEntity<?> searchByAge(@RequestParam("begin") Optional<Integer> beginAge,
                                         @RequestParam("end") Optional<Integer> endAge,
                                         @RequestParam("skip") Optional<Integer> skipParam,
                                         @RequestParam("take") Optional<Integer> takeParam) {
        int begin = beginAge.orElse(20);
        int end = endAge.orElse(55);
        int skip = skipParam.orElse(0);
        int take = takeParam.orElse(5);
        return ResponseEntity.ok(searcher.findByAge(begin, end, skip, take));
    }
    @GetMapping
    public ResponseEntity<?> searchByGender(@RequestParam("gender") Optional<String> gender,
                                            @RequestParam("skip") Optional<Integer> skipParam,
                                            @RequestParam("take") Optional<Integer> takeParam) {
        int skip = skipParam.orElse(0);
        int take = takeParam.orElse(5);
        return ResponseEntity.ok(searcher.findByGender(gender.orElse("male"), skip, take));
    }
    @GetMapping
    public ResponseEntity<?> searchByJob(@RequestBody JobRequest jobs,
                                         @RequestParam("skip") Optional<Integer> skipParam,
                                         @RequestParam("take") Optional<Integer> takeParam) {
        int skip = skipParam.orElse(0);
        int take = takeParam.orElse(5);
        return ResponseEntity.ok(searcher.findByJob(jobs.getJobs(), skip, take));
    }
}
