package ro.uvt.commands;

import org.springframework.stereotype.Component;

@Component
public class CreateSectionCommand implements Command {
    @Override
    public String execute() {
        return "Command: Creating a new Section.";
    }
}