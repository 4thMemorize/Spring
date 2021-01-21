package org.memorize.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("asyncTask")
public class AsyncTask {
    @Async("asyncExecutor")
    public Map<String, Object> asyncExecutor() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> result = new HashMap<>();
        System.out.println("========= THREAD STARTED =========");
        result.put("thread", true);
        System.out.println("========= THREAD CLOSED =========");
        System.out.println(result);
        return result;
    }
}
