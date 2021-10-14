package Entity;

public enum Job {
    TEACHER("Teacher", 1),
    CODER("Coder", 2),
    DOCTOR("Doctor", 3),
    ENGINEER("Engineer", 4),
    NURSE("Nurse", 5),
    FARMER("Farmer", 6);

    private final String name_job;
    private final int order;

    Job(String name_job, int order){
        this.name_job = name_job;
        this.order = order;
    }
    public String getName_job(){
        return name_job;
    }
    public  int getOrder(){
        return order;
    }
}
