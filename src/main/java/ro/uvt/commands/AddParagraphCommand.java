package ro.uvt.commands;

import org.springframework.stereotype.Component;

@Component
public class AddParagraphCommand implements Command {
    @Override
    public String execute() {
        return "Command: Adding a new Paragraph.";
    }
}