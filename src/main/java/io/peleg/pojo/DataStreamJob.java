package io.peleg.pojo;

import io.peleg.JobRunner;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DataStreamJob {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.getConfig().registerPojoType(User.class);
        env.getConfig().disableForceKryo();

        JobRunner<User> jobRunner = new JobRunner<User>(new RandomUserSourceFunction());

        jobRunner.run(env);
    }
}
