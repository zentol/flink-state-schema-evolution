package io.peleg.kryo;

import io.peleg.JobRunner;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DataStreamJob {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        JobRunner<User> jobRunner = new JobRunner<User>(new RandomUserSourceFunction());

        jobRunner.run(env);
    }
}
