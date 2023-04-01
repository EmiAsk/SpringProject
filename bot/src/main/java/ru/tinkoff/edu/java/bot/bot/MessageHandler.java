package ru.tinkoff.edu.java.bot.bot;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.bot.command.HelpCommandHandler;
import ru.tinkoff.edu.java.bot.dto.HandledUpdate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MessageHandler {
    public final CommandsHandler commandsHandler;
    public final HelpCommandHandler helpCommand;
    public final MessageSender messageSender;

    // probably needs refactoring
    public HandledUpdate handle(Update update, State state) {

        SendMessage request;
        State newState = State.NONE;

        if (state == State.TRACK_LINK) {
            request = messageSender.send(update, "Got this link tracked, thanks.");
        } else {
            request = messageSender.send(update, "Unknown message. Try using /help.");
        }

        return HandledUpdate.builder()
                .request(Optional.of(request))
                .newState(newState)
                .build();
    }
}
