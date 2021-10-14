package Config;

import Entity.Gender;
import Entity.Job;
import Entity.User;
import Entity.UserReponsive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class UserConfig implements CommandLineRunner {
    @Autowired
    UserReponsive userReponsive;

    @Override
    public void run(String... args) throws Exception {

        if (userReponsive.findAll(PageRequest.of(0, 1)).getSize() != 0 && !userReponsive.findAll(PageRequest.of(0, 1)).isEmpty()) {
            return;
        }
        for (int i = 0; i < 10000000; i++) {
            User user = new User();
            user.setAddress("hhhhhh");
            user.setAge(ThreadLocalRandom.current().nextInt(10, 60));
            user.setBirth(LocalDate.of(2021 - user.getAge(),
                    ThreadLocalRandom.current().nextInt(1, 31),
                    ThreadLocalRandom.current().nextInt(1, 12)));
            user.setGender(Gender.valueOf(Math.random() < 0.5 ? "MALE" : "FEMALE"));
            user.setName("user" + (i + 1));
            user.setJobs(renderListJob());
            System.out.println(userReponsive.save(user));
        }

    }


    public List<Job> renderListJob(){
        Map<Integer, Job> mapJob = new HashMap<Integer, Job>();
        int j = 0;
        int size = (int) (Math.random() * 9)+1;
        while ( j < size) {
            int rdIdx = ThreadLocalRandom.current().nextInt(25);
            if(!mapJob.containsKey(rdIdx)) {
                j++;
                mapJob.put(rdIdx, Job.values()[rdIdx]);
            }

        }
        return mapJob.entrySet().stream().map((e)->{
            return e.getValue();
        }).collect(Collectors.toList());
    }
}
