package Search;

import Entity.Gender;
import Entity.User;
import Entity.UserReponsive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserSearchH implements UserSearch {

    @Autowired
    UserReponsive userReponsive;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<User> findByAge(int begin, int end, int skip, int take) {
        Criteria criteria = Criteria.where("age").gte(begin).lte(end);
        Query query = Query.query(criteria);
        query.limit(take);
        query.skip((skip*take)-take);
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> findByGender(String gender, int skip, int take) {
        Criteria criteria = Criteria.where("gender").is(Gender.valueOf(gender.toUpperCase()));
        Query query = Query.query(criteria);
        query.limit(take);
        query.skip((skip*take)-take);
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public List<User> findByJob(List<Integer> jobs, int skip, int take) {
        Criteria criteria = Criteria.where("jobs").all(jobs);
        Query query = Query.query(criteria);
        query.limit(take);
        query.skip((skip*take)-take);
        return mongoTemplate.find(query, User.class);
    }
}
