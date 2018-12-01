package com.brotuny.proj.notifications;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.petersamokhin.bots.sdk.clients.Group;
import com.petersamokhin.bots.sdk.objects.Message;

public class VkBot {
  private final Integer botId = 174706111;
  private final String token =
          "c072921a8b96694b9866c939e1150f994d5c3e93a8e4bbd8b981f24810e00f84bb1c8cd481569a3bc78d5";
  private final Set<Integer> users = new HashSet<>();
  private Group group;

  public VkBot() {
    group = new Group(botId, token);
    group.onSimpleTextMessage(message -> {
              if (users().contains(message.authorId())) {
                new Message()
                        .from(group)
                        .to(message.authorId())
                        .text("Пользователь " + message.authorId() + " уже есть в расылке")
                        .send();
              } else {
                saveUser(message.authorId());
                new Message()
                        .from(group)
                        .to(message.authorId())
                        .text("Пользователь " + message.authorId() + " зарегистрирован в рассылку")
                        .send();
              }
            }
    );
  }

  private void saveUser(Integer id) {
    synchronized (users) {
      users.add(id);
    }
  }

  private List<Integer> users() {
    synchronized (users) {
      return new ArrayList<>(users);
    }
  }
}
