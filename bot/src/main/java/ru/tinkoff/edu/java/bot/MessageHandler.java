package ru.tinkoff.edu.java.bot;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.command.HelpCommandHandler;
import ru.tinkoff.edu.java.bot.meta.State;
import ru.tinkoff.edu.java.bot.dto.HandledUpdate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MessageHandler { ;
    public final MessageSender messageSender;

    // probably needs refactoring
    public HandledUpdate handle(Update update, State state) {

        SendMessage request;
        State newState = State.NONE;

        switch (state) {
            case TRACK -> {
                request = messageSender.send(update, "Got this link tracked, thanks.");
            }
            case UNTRACK -> {
                request = messageSender.send(update, "Got this link untracked, thanks.");
            }
            default -> {
                request = messageSender.send(update, "Unknown command. Try using /help.");
            }
        }

        return HandledUpdate.builder()
                .request(Optional.of(request))
                .newState(newState)
                .build();
    }
}