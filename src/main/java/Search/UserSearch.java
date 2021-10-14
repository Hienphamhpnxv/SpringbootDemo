package Search;

import Entity.User;

import java.util.List;

public interface UserSearch {
    List<User> findByAge(int begin, int end, int skip, int take);
    List<User> findByGender(String gender, int skip, int take);
    List<User> findByJob(List<Integer> jobs, int skip, int take);
}
