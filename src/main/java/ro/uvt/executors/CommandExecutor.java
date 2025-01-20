package ro.uvt.executors;

import org.springframework.stereotype.Component;
import ro.uvt.commands.Command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandExecutor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void executeAsync(Command command) {
        executorService.submit(command::execute);
    }

    public String executeSync(Command command) {
        return command.execute();
    }
}